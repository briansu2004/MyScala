val fibs: LazyList[BigInt] =
  BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }
fibs.take(20).foreach(println)

val fib: LazyList[BigInt] = {
  def fs(prev: BigInt, curr: BigInt): LazyList[BigInt] = prev #:: fs(curr, prev + curr)

  fs(0, 1)
}
fib(10)
