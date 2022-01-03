// P08 (**) Eliminate consecutive duplicates of list elements.
//     If a list contains repeated elements they should be replaced with a
//     single copy of the element. The order of the elements should not be
//     changed.
//
//     Example:
//     scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//     res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)

import java.time.{Duration, LocalDateTime}
import scala.annotation.tailrec

object P08 {
  // Standard recursive
  def compressRecursive[T](l: List[T]): List[T] = l match {
    case Nil => Nil
    case h :: tail => h :: compressRecursive(tail.dropWhile(_ == h))
  }

  // Tail recursive 01
  def compressTailRecursive01[T](l: List[T]): List[T] = {
    @tailrec
    def compressR(result: List[T], curList: List[T]): List[T] = curList match {
      case Nil => result.reverse
      case h :: tail => compressR(h :: result, tail.dropWhile(_ == h))
    }

    compressR(Nil, l)
  }

  // Tail recursive 02
  def compressTailRecursive02[T](l: List[T]): List[T] = {
    @tailrec
    def compressR(result: List[T], curList: List[T]): List[T] = curList match {
      case Nil => result
      case h :: tail => compressR(result ::: List(h), tail.dropWhile(_ == h))
    }

    compressR(Nil, l)
  }

  // Using foldRight
  def compressFoldRight[T](l: List[T]): List[T] = l.foldRight(List[T]()) { (left, right) =>
    if (right.isEmpty || right.head != left) left :: right
    else right
  }

  // Using foldLeft
  def compressFoldLeft[T](l: List[T]): List[T] = l.foldLeft(List[T]()) { (left, right) =>
    if (left.isEmpty || left.last != right) left ::: List(right)
    else left
  }

  /*
  List(1, 2, 3).foldLeft(0)(_ + _)
  // ((0 + 1) + 2) + 3
  // = 6
  List(1, 2, 3).foldRight(0)(_ + _)
  // 1 + (2 + (3 + 0))
  // = 6
   */

  def main(args: Array[String]): Unit = {
    val lst = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

    var start = LocalDateTime.now()
    println("Using standard recursion: ")
    println(s"The compressed $lst is:\n ${compressRecursive(lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println("Using tail recursion 01: ")
    println(s"The compressed $lst is:\n ${compressTailRecursive01(lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toNanos
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed nanoseconds")

    start = LocalDateTime.now()
    println("Using tail recursion 02: ")
    println(s"The compressed $lst is:\n ${compressTailRecursive02(lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toNanos
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed nanoseconds")

    start = LocalDateTime.now()
    println("Using foldRight: ")
    println(s"The compressed $lst is:\n ${compressFoldRight(lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toNanos
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed nanoseconds")

    start = LocalDateTime.now()
    println("Using foldLeft: ")
    println(s"The compressed $lst is:\n ${compressFoldLeft(lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toNanos
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed nanoseconds")
  }
}
