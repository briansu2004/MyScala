case class tickerPrice(ticker: String, curPrice: Option[BigDecimal])

case class trading(date: String, party: String, ticker: String, action: String, numShares: Option[BigInt],
                   tradePrice: Option[BigDecimal])
