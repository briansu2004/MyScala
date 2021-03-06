object PartitionByValue3 {
  def partitionByValue[A, B](m: Map[A, List[Int]], n: Int): List[Map[A, List[Int]]] = {
    var o1: Map[A, List[Int]] = Map()
    var o2: Map[A, List[Int]] = Map()
    m.map {
      case (k, lst) =>
        o1 = o1 ++ Map(k -> lst.span(_ <= n)._1)
        o2 = o2 ++ Map(k -> lst.span(_ <= n)._2)
    }
    List(o1, o2)
  }

  def main(args: Array[String]): Unit = {
    val mp: Map[String, List[Int]] = Map("a" -> List(1, 2, 3), "b" -> List(2, 3))
    println(partitionByValue(mp, 2))
  }
}
// Expected output:
// (Map("a" -> List(1, 2), "b" -> List(2)), Map("a" -> List(3), "b" -> List(3)))
