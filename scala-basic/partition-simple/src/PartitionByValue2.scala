object PartitionByValue2 {
  def main(args: Array[String]): Unit = {
    val mp: Map[String, List[Int]] = Map("a" -> List(1, 2, 3), "b" -> List(2, 3))
    var o1: Map[String, List[Int]] = Map()
    var o2: Map[String, List[Int]] = Map()
    mp.map {
      case(k, lst) =>
        o1 = o1 ++ Map(k -> lst.span(_ <= 2)._1)
        o2 = o2 ++ Map(k -> lst.span(_ <= 2)._2)
    } : Unit
    println(List(o1, o2))
  }
}
// Expected output:
// (Map("a" -> List(1, 2), "b" -> List(2)), Map("a" -> List(3), "b" -> List(3)))
