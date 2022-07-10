/* Utopian Tree */
println('-' * 50)
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
println('-' * 50)
println("Factroial")
val factorial: LazyList[Int] = {
  def f: LazyList[Int] = {
    1.toInt #:: f.zipWithIndex.map { n => n._1 * (n._2 + 2) }
  }

  1 #:: f
}
(0 to 10).foreach(x => println(factorial(x)))

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
