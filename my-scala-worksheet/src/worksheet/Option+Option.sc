import cats.implicits._

def addOptionInt(a: Option[Int], b: Option[Int]): Option[Int] = {
  (a, b) match {
    case (None, None) => None
    case (None, v@Some(_)) => v
    case (v@Some(_), None) => v
    case (Some(v1), Some(v2)) => Some(v1 + v2)
  }
}

def output(a: Option[Int], b: Option[Int]): Unit = {
  println(s"a: $a; b: $b")
  //println(s"for (x <- a; y <- b) yield x + y = ${for (x <- a; y <- b) yield x + y}")
  println(s"for (x <- a.orElse(Some(0)); y <- b.orElse(Some(0))) yield x + y = ${for (x <- a.orElse(Some(0)); y <- b.orElse(Some(0))) yield x + y}")
  println(s"a.flatMap(x => b.map(x + _)) = ${a.flatMap(x => b.map(x + _))}")
  println(s"(a ++ b).reduceOption(_ + _) = ${(a ++ b).reduceOption(_ + _)}")
  println(s"a |+| b = ${a |+| b}")
  println(s"addOptionInt(a,b) = ${addOptionInt(a, b)}")
  //println(s"a.getOrElse(0) + b.getOrElse(0) = ${a.getOrElse(0) + b.getOrElse(0)}")
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







