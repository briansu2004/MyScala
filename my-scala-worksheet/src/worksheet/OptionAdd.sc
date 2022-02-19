def output(a: Option[Int], b: Option[Int]): Unit = {
  println(s"a: $a; b: $b")
  println(s"(a ++ b).reduceOption(_ + _) = ${(a ++ b).reduceOption(_ + _)}")
}


var a: Option[Int] = None
var b: Option[Int] = None
output(a, b)

a = Some(1)
output(a, b)

b = Some(2)
output(a, b)

a = None
output(a, b)







