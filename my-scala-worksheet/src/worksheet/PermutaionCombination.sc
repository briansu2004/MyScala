var itr = List(1,2,3,4).combinations(2)
while (itr.hasNext) {
  //println(itr.next())
  //println(s"${itr.next()(0)}, ${itr.next()(1)}")
  val l = itr.next()
  //println(l.mkString(" "))
  println(s"${l(0)}, ${l(1)}")
}


var itr = Array(1,2,3,4).combinations(2)
while (itr.hasNext) {
  println(itr.next())
}


List(2, 0, 2, 5).permutations.mkString("\n")
List(2, 0, 2, 5).combinations(1).mkString("\n")
List(2, 0, 2, 5).combinations(2).mkString("\n")
List(2, 0, 2, 5).combinations(3).mkString("\n")
List(2, 0, 2, 5).combinations(4).mkString("\n")

List(1,2,3).permutations.mkString("\n")

List(1,2,3).combinations(2).mkString("\n")

List(1,2,3).permutations

