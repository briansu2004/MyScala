object fs {
  val fibLazy: LazyList[BigInt] = {
    def fs(prev: BigInt, curr: BigInt): LazyList[BigInt] = prev #:: fs(curr, prev + curr)
    fs(0, 1)
  }

  def main(args: Array[String]): Unit = {
    (100000 to 100010).foreach(n => println(s"The Fibonacci number of $n is: ${fibLazy(n)}"))
  }
}
