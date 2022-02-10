package course1

import timetools.DateTimeWrapper._

import scala.io.Source

object readfile extends App {
  val filename = "c:\\tmp\\test\\input.csv"
  val bufferedSource = Source.fromFile(filename)

  //  for (line <- Source.fromFile(filename).getLines) {
  //    println(line)
  //  }
  val lines = bufferedSource.getLines()
  val listOfSaleDetails: Array[SaleDetails] = lines.map {
    line =>
      val cols = line.split(",").map(_.trim)

      SaleDetails(cols(0), BigDecimal(cols(1)), cols(2))
  }.toArray
  //val saleOver5k = listOfSaleDetails.map(_.amount).filter(_ > 5000)
  val saleOver5k = listOfSaleDetails.filter(_.amount > 5000)
  val salesPerDay = listOfSaleDetails.groupBy(_.time.dateNumber).map {
    case (_, arr) => arr.map(_.amount).sum
  }
  println("Here are the sales records over $5k:")
  saleOver5k.foreach(s => println(s))

  //println("2004-01-26T14:24:02.618-05:00".dateNumber.toString)  //20040126
  val maxSalesByDay = listOfSaleDetails.groupBy(_.time.dateNumber).map {
    case (_, arr) => arr.map(_.amount).sum
  }.max
  salesPerDay.foreach(s => println(s))

  case class SaleDetails(sales: String, amount: BigDecimal, time: String)

  println(s"max sales by day: $maxSalesByDay")

  bufferedSource.close()
}
