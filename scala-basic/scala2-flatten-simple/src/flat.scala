object flat {
  def flatten(l: List[Any]): List[Any] = l flatMap {
    case ls: List[_] => flatten(ls)
    case h => List(h)
  }

  def main(args: Array[String]): Unit = {
    val lst = List(List(1, 1), 2, List(3, List(5, 8)));
    println(flatten(lst));
  }
}