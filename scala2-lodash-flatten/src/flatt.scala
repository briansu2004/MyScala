object flatt {
  def flatten[T](l: List[T]): List[T] = l.flatMap {
    case a: List[T] => flatten(a)
    case a: T => List(a)
  }

  def main(args: Array[String]): Unit = {
    val lst = List(List(1, 1), 2, List(3, List(5, 8)));
    println(flatten(lst));
  }
}