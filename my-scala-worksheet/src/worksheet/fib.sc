val fib: LazyList[BigInt] = {
  def fs(prev: BigInt, curr: BigInt): LazyList[BigInt] = prev #:: fs(curr, prev + curr)
  fs(0, 1)
}

fib(10)
