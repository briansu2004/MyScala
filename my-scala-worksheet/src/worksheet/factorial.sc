
val fa: LazyList[Int] = {
  def f: LazyList[Int] = {
    1.toInt #:: f.zipWithIndex.map {
      n => {
        //println(n)
        n._1 * (n._2 + 2)
      }
    }
  }
  1 #:: f
}
fa(0)
fa(1)
fa(2)
fa(3)
fa(4)
fa(5)
fa(6)
fa(7)
fa(8)

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
