import java.time.{Duration, LocalDateTime}

object fs1 {
  val fibLazy: LazyList[BigInt] = {
    def fs(prev: BigInt, curr: BigInt): LazyList[BigInt] = prev #:: fs(curr, prev + curr)
    fs(0, 1)
  }

  def main(args: Array[String]): Unit = {
    var start = LocalDateTime.now()
    (100 to 110).foreach(n => println(s"The Fibonacci number of $n is: ${fibLazy(n)}"))
    var elapsed = Duration.between(start, LocalDateTime.now()).toMillis
    println(s"Elapsed:\t$elapsed milliseconds")
  }
}
