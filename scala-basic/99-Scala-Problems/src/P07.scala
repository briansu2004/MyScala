// P07 (**) Flatten a nested list structure.
//     Example:
//     scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
//     res0: List[Any] = List(1, 1, 2, 3, 5, 8)

object P07 {
  // Impl 1
  def flatten01[T](l: List[T]): List[T] = l.flatMap {
    case a: List[T] => flatten01(a)
    case a: T => List(a)
  }

  // Impl 02
  def flatten02[T](l: List[T]): List[T] = l flatMap {
    case a: List[T] => flatten02(a)
    case a: T => List(a)
  }

  def main(args: Array[String]): Unit = {
    val lst = List(List(1, 1), 2, List(3, List(5, 8)))

    println("Implementation 01: ")
    println(s"The flatten $lst is: ${flatten01(lst)}")

    println("Implementation 02: ")
    println(s"The flatten $lst is: ${flatten02(lst)}")

//    println("Implementation 03: ")
//    println(s"The flatten $lst is: ${flatten03(lst)}")
  }
}
