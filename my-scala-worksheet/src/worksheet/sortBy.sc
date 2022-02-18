val myList = List(9, 7, 20, -1, 88)
myList.sortBy(_.toInt)
myList.sortBy(-_.toInt)
myList.sortBy(+_.toInt)

case class A(rate: BigInt)
val aList = List(A(10879), A(32573496), A(-203), A(288), A(897827))
aList.sortBy(_.rate)
aList.sortBy(-_.rate)

