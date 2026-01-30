import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.*
import org.apache.spark.sql.types.*
import org.apache.spark.sql.Row // Added this

@main def runAnalysis(): Unit =
  System.setProperty("hadoop.home.dir", "C:\\hadoop")

  // val spark = SparkSession.builder()
  //   .appName("Stock Portfolio Demo")
  //   .master("local[*]")
  //   .getOrCreate()

  val spark = SparkSession.builder()
    .appName("Stock Portfolio Demo")
    .master("local[*]")
    .config("spark.hadoop.io.native.lib.available", "false")
    .config("spark.hadoop.fs.file.impl", "org.apache.hadoop.fs.LocalFileSystem")
    .getOrCreate()

  // REMOVED: import spark.implicits.* // This is often the cause of the Reflection error in Scala 3/Spark 3 mix

  spark.sparkContext.setLogLevel("WARN")

  println("--- Spark Session Started (Scala 3 Mode) ---")

  val stockSchema = StructType(Array(
    StructField("ticker", StringType, nullable = false),
    StructField("shares", IntegerType, nullable = true),
    StructField("avg_cost", DoubleType, nullable = true),
    StructField("currency", StringType, nullable = true),
    StructField("current_price", DoubleType, nullable = true)
  ))

  // Read Data
  val rawDf = spark.read
    .option("header", "true")
    .schema(stockSchema)
    .option("mode", "DROPMALFORMED") 
    .csv("data/stocks.csv")

  println(s"Valid records loaded: ${rawDf.count()}")

  // Transform using DataFrame API (this doesn't require reflection)
  val analyzedDf = rawDf
    .withColumn("market_value", col("shares") * col("current_price"))
    .withColumn("total_cost", col("shares") * col("avg_cost"))
    .withColumn("unrealized_gain", col("market_value") - col("total_cost"))
    .withColumn("gain_percentage", round((col("unrealized_gain") / col("total_cost")) * 100, 2))
    .withColumn("normalized_gain_usd", 
      when(col("currency") === "CAD", col("unrealized_gain") * 0.74)
      .otherwise(col("unrealized_gain"))
    )

  // Show in console
  analyzedDf.show()

  // Write JSON
  val outputPath = "output/angular_data"
  analyzedDf.write.mode("overwrite").json(outputPath)

  println(s"Analysis complete. JSON written to $outputPath")

  spark.stop()
  