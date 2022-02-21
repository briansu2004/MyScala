// P03 (*) Find the Kth element of a list.
//     By convention, the first element in the list is element 0.
//
//     Example:
//     scala> nth(2, List(1, 1, 2, 3, 5, 8))
//     res0: Int = 2

object P03 {
  def nth[T](n: Int, l: List[T]): T = {
    if (n >= 0 && n < l.length)
      l(n)
    else
      throw new NoSuchElementException
  }

  def nthRecursive[T](n: Int, l: List[T]): T = (n, l) match {
    case(0, h :: _) => h
    case(n, _ :: tail) => nthRecursive(n - 1, tail)
    case (_, Nil) => throw new NoSuchElementException
  }

  def main(args: Array[String]): Unit = {
    val lst = List(1, 1, 2, 3, 5, 8)

    println("Using the built-in function: ")
    println(s"The 0th element of $lst is: ${nth(0, lst)}")
    println(s"The 1st element of $lst is: ${nth(1, lst)}")
    println(s"The 2nd element of $lst is: ${nth(2, lst)}")
    println(s"The 3rd element of $lst is: ${nth(2, lst)}")
    println(s"The 4th element of $lst is: ${nth(4, lst)}")
    println(s"The 5th element of $lst is: ${nth(5, lst)}")
    //println(s"The 6th element of $lst is: ${nth(6, lst)}")
    //println(s"The 7th element of $lst is: ${nth(7, lst)}")

    println("Using the recursion: ")
    println(s"The 0th element of $lst is: ${nthRecursive(0, lst)}")
    println(s"The 1st element of $lst is: ${nthRecursive(1, lst)}")
    println(s"The 2nd element of $lst is: ${nthRecursive(2, lst)}")
    println(s"The 3rd element of $lst is: ${nthRecursive(2, lst)}")
    println(s"The 4th element of $lst is: ${nthRecursive(4, lst)}")
    println(s"The 5th element of $lst is: ${nthRecursive(5, lst)}")
    //println(s"The 6th element of $lst is: ${nthRecursive(6, lst)}")
    //println(s"The 7th element of $lst is: ${nth(7, lst)}")
  }
}
