
// P05 (*) Reverse a list.
//     Example:
//     scala> reverse(List(1, 1, 2, 3, 5, 8))
//     res0: List[Int] = List(8, 5, 3, 2, 1, 1)

import java.time.{Duration, LocalDateTime}
import scala.annotation.tailrec

object P05 {
  // Built-in
  def reverse[T](l: List[T]): List[T] = {
    l.reverse
  }

  // Simple recursive.  O(n^2)
  def reverseRecursive[T](l: List[T]): List[T] = l match {
    case Nil => Nil
    case h :: tail => reverseRecursive(tail) ::: List(h)
  }
  //  :: - adds an element at the beginning of a list and returns a list with the added element
  //  ::: - concatenates two lists and returns the concatenated list
  /*
    val list1 = List(1,2)
    val list2 = List(3,4)

    list1::list2 returns:
    List[Any] = List(List(1, 2), 3, 4)

    list1:::list2 returns:
    List[Int] = List(1, 2, 3, 4)
   */

  // Tail recursive
  def reverseTailRecursive[T](l: List[T]): List[T] = {
    @tailrec
    def reverseR(result: List[T], curList: List[T]): List[T] = curList match {
      case Nil => result
      case h :: tail => reverseR(h :: result, tail)
    }

    reverseR(Nil, l)
  }

  // foldLeft
  def reverseFoldLeft[T](l: List[T]): List[T] = l.foldLeft(List[T]()) { (a, b) => b :: a }

  // foldRight
  def reverseFoldRight[T](l: List[T]): List[T] = l.foldRight(List[T]()) { (a, b) => b ::: List(a) }

  def main(args: Array[String]): Unit = {
    val lst = List(1, 1, 2, 3, 5, 8)

    var start = LocalDateTime.now()
    println("Using the built-in function: ")
    println(s"The reverse of $lst is: ${reverse(lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println("Using the simple recursion: ")
    println(s"The reverse of $lst is: ${reverseRecursive(lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toNanos
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed nanoseconds")

    start = LocalDateTime.now()
    println("Using the tail recursion: ")
    println(s"The reverse of $lst is: ${reverseTailRecursive(lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toNanos
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed nanoseconds")

    start = LocalDateTime.now()
    println("Using the foldLeft: ")
    println(s"The reverse of $lst is: ${reverseFoldLeft(lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toNanos
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed nanoseconds")

    start = LocalDateTime.now()
    println("Using the foldRight: ")
    println(s"The reverse of $lst is: ${reverseFoldRight(lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toNanos
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed nanoseconds")
  }
}
