//Find the last but one element of a list.
//Example:
//scala> penultimate(List(1, 1, 2, 3, 5, 8))
//res0: Int = 5

object P02 {
  def secondLast[T](l: List[T]): T = {
    l.last
  }

  def secondLastWithRecursion[T](l: List[T]): T = l match {
    case h :: Nil => h
    case _ :: tail => secondLastWithRecursion(tail)
    case _ => throw new NoSuchElementException

  }

  def main(args: Array[String]): Unit = {
    val lst = List(1, 1, 2, 3, 5, 8)

    println("Using the built-in function: ")
    println(s"The last element of $lst is: ${secondLast(lst)}")

    println("Using the recursion: ")
    println(s"The last element of $lst is: ${secondLastWithRecursion(lst)}")
  }
}
