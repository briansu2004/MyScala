
def gamePrices(p: Int, d: Int, m: Int): LazyList[Int] = {
  p #:: (p - d) #:: gamePrices(p, d, m).zip(gamePrices(p, d, m).tail).map { n => if (n._2 - d > m) n._2 - d else m }
}
(0 to 10).foreach(n => println(s"The game prices of $n are: ${gamePrices(20, 3, 6)(n)}"))

def gameCostAccu(p: Int, d: Int, m: Int): LazyList[Int] = {
  gamePrices(p, d, m).map(n => gamePrices(p, d, m).slice(0, gamePrices(p, d, m).indexOf(n) + 1).sum)
}
(0 to 10).foreach(n => println(s"The game cost accu of $n are: ${gameCostAccu(20, 3, 6)(n)}"))

// crash
val res = gameCostAccu(20, 3, 6).takeWhile(n => n <= 70)
res.length



// gameCostAccu(20, 3, 6).filter(n => n <= 70).length // long running

//((0 to 70) filter gameCostAccu(20, 3, 6))(1)

// gameCostAccu(20, 3, 6).filter(n => n <= 70).max // crash

def gamePrices: LazyList[Int] = {
  val p = 20
  val d = 3
  val m = 6
  p #:: (p - d) #:: gamePrices.zip(gamePrices.tail).map { n => if (n._2 - d > m) n._2 - d else m }
}
(0 to 10).foreach(n => println(s"The game prices of $n are: ${gamePrices(n)}"))


/* Square Number */
println("-" * 50)
println("Square Number")
val squares: LazyList[Long] = {
  def f: LazyList[Long] = {
    1 #:: f.zipWithIndex.map {
      n => (n._2 + 2).toLong * (n._2 + 2).toLong
    }
  }

  f
}
(0 to 10).foreach(x => println(squares(x)))
squares.filter(n => n >= 3 && n <= 9)
//squares.filter(n => n >= 3 && n <= 9).length //java.lang.StackOverflowError
//squares.filter(n => n >= 3 && n <= 9).size //java.lang.StackOverflowError


/* Utopian Tree */
println("-" * 50)
println("Utopian Tree")
val utopianTree: LazyList[Int] = {
  def f: LazyList[Int] = {
    1 #:: f.zipWithIndex.map {
      n => if (n._2 % 2 == 0) n._1 * 2 else n._1 + 1
    }
  }

  f
}
(0 to 10).foreach(x => println(utopianTree(x)))


/* Factorial */
println("-" * 50)
println("Factroial")
// Int
val factorial: LazyList[Int] = {
  def f: LazyList[Int] = {
    1.toInt #:: f.zipWithIndex.map { n => n._1 * (n._2 + 2) }
  }

  1 #:: f
}
(0 to 10).foreach(x => println(factorial(x)))
// BigInt
val factorialBigInt: LazyList[BigInt] = {
  def f: LazyList[BigInt] = {
    BigInt(1) #:: f.zipWithIndex.map { n => n._1 * (n._2 + 2) }
  }

  1 #:: f
}
(0 to 25).foreach(x => println(factorialBigInt(x)))

// List can't have a lot of elements so the index can't be BigInt that large
// It is designed to be Int (handeled by Int)

//
//// 1 2 6 24 120 720 5040 40320
//val factorials: LazyList[BigInt] = {
//  BigInt(1) #:: factorials.zipWithIndex.map { n => n._1 * (n._2 + 2) }
//}
//factorials.take(8).foreach(println)
//factorials(0)
//factorials(1)
//factorials(2)
//factorials(3)
//
//val fact: LazyList[Int] = {
//  1.toInt #:: fact.zipWithIndex.map { n => n._1 * (n._2 + 2) }
//}
//fact(0)
//fact(1)
//fact(2)

/* Fib */
val fibs: LazyList[BigInt] =
  BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }
fibs.take(20).foreach(println)

val fib: LazyList[BigInt] = {
  def fs(prev: BigInt, curr: BigInt): LazyList[BigInt] = prev #:: fs(curr, prev + curr)

  fs(0, 1)
}
fib(10)

(100000 to 100010).foreach(n => println(s"The Fibonacci number of $n is: ${fib(n)}"))
