package course1


import scala.io.Source

object Ticker extends App {
  //AA 17.80
  case class ticker(ticker: String, curMarketPrice: BigDecimal)

  // 2011-02-24	iShares :MSCI EAFE Idx	ETR	SELL	10000	72.06
  case class trading(date: String, party: String, ticker: String, action: String, numShares: BigInt,
                     tradePrice: BigDecimal)

  val marketFile = "C:\\tmp\\test_data\\marks.txt"
  val bufferedSourceMarket = Source.fromFile(marketFile)
  val markerLines = bufferedSourceMarket.getLines()
  val listOfTickers: Array[ticker] = markerLines.map {
    line => {
      val cols = line.split("\t").map(_.trim)
      ticker(cols(0), BigDecimal(cols(1)))
    }
  }.toArray
  //listOfTickers.foreach(t => println(t))
  bufferedSourceMarket.close()




  //  val tradingFile1 = "C:\\tmp\\test_data\\xae"
  //  val bufferedSourceTrading1 = Source.fromFile(tradingFile1)
  //  val trading1Lines = bufferedSourceTrading1.getLines()
  //  val listOfTradingDetails1: Array[trading] = trading1Lines.map {
  //    line => {
  //      val cols = line.split("\t").map(_.trim)
  //      trading(cols(0), cols(1), cols(2), cols(3), BigInt(cols(4)), BigDecimal(cols(5)))
  //    }
  //  }.toArray
  //  listOfTradingDetails1.foreach(t => println(t))
  //  bufferedSourceTrading1.close()
}
