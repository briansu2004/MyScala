import Constants._
import listFileInDir.getListOfFiles
import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.util.Try

object TradingAnalysis extends App {
  private implicit def str2BigDecimal(in: String): Option[BigDecimal] = Try(BigDecimal(in)).toOption

  private implicit def str2BigInt(in: String): Option[BigInt] = Try(BigInt(in)).toOption

  val marketFile = dataFolder + separator + markFile
  val bufferedSourceMarketFile = Source.fromFile(marketFile)
  val markerLines = bufferedSourceMarketFile.getLines()
  val tickerPriceList = markerLines.map {
    line => {
      val cols = line.split(" ").map(_.trim)
      tickerPrice(cols(0), cols(1))
    }
  }.toList
  bufferedSourceMarketFile.close()

  var tradingDataList = new ListBuffer[List[trading]]()

  val dataFiles = getListOfFiles(dataFolder).filter(_.getName != markFile)
  dataFiles.foreach {
    f =>
      println(s"Handling data file $f")
      val dataFile = dataFolder + separator + f.getName
      val bufferedSourceDataFile = Source.fromFile(dataFile)
      val trading1Lines = bufferedSourceDataFile.getLines()
      val tradeList1 = trading1Lines.map {
        line =>
          val cols = line.split("\t").map(_.trim)
          trading(cols(0), cols(1), cols(2), cols(3), cols(4), cols(5))
      }.toList
      tradingDataList += tradeList1
      bufferedSourceDataFile.close()
  }

  val tradeList = tradingDataList.flatten

  val riskResultList = tradeList.groupBy(_.ticker).map {
    case (ticker, tradingList) =>
      val risk = tradingList.flatMap { rec =>
        val inOut = if (rec.action.toLowerCase() == "buy") 1 else -1
        rec.numShares.flatMap(shares => rec.tradePrice.map(price => inOut * price * BigDecimal(shares))).toList
      }.sum
      (ticker, risk)
  }.toList
  val top20RiskList = riskResultList.sortBy(_._2).take(20)
  val top20RiskValue = top20RiskList.flatMap { case (symbol, _) => tickerPriceList.zipWithIndex.map { case (v, _)
  => (v.ticker, v.curPrice)
  }.toMap.get(symbol).map(tp =>
    (symbol, tp.get))
  }
  println(s"Top 20 risks with the current market value:")
  top20RiskValue.foreach(t => println(t))

  val partyResultList = tradeList.groupBy(_.party).map {
    case (symbol, tradingList) =>
      val risk = tradingList.flatMap { rec =>
        rec.numShares.flatMap(shares => rec.tradePrice.map(price => price * BigDecimal(shares))).toList
      }.sum
      (symbol, risk)
  }.toList
  val top20PartyList = partyResultList.sortBy(_._2).take(20)
  println(s"Top 20 counter parties by trading volume:")
  top20PartyList.foreach(t => println(t))
}
