package course3

object Test extends App {

  import MapTools.implicits._
  import TraversableGeneric.implicits._

  val myMap = Map("a" -> List(1, 2), "b" -> List(2, 3, 4))
  println(myMap.filterByValues(_ > 2))
  println(myMap.partitionByValues(_ > 2))

//  val myList = List(List(1, 2), List(2, 3, 4))
//  println(myList.filterByValues(_ > 2))
//  println(myList.partitionByValues(_ > 2))
}
