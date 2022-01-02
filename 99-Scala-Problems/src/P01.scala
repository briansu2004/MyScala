//Find the last element of a list.
//Example:
//scala> last(List(1, 1, 2, 3, 5, 8))
//res0: Int = 8

object P01 {
  def last[T](l: List[T]): T = {
    l.last
  }

  def lastWithRecursion[T](l: List[T]): T = l match {
    case h :: Nil => h
    case _ :: tail => lastWithRecursion(tail)
    case _ => throw new NoSuchElementException

  }

  def main(args: Array[String]): Unit = {
    val lst = List(1, 1, 2, 3, 5, 8)

    println("Using the built-in function: ")
    println(s"The last element of $lst is: ${last(lst)}")

    println("Using the recursion: ")
    println(s"The last element of $lst is: ${lastWithRecursion(lst)}")
  }
}
