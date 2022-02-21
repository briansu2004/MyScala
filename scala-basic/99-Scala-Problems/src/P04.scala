// P04 (*) Find the number of elements of a list.
//     Example:
//     scala> length(List(1, 1, 2, 3, 5, 8))
//     res0: Int = 6

import java.time.{Duration, LocalDateTime}
import scala.annotation.tailrec

object P04 {
  def length[T](l: List[T]): Int = {
    l.length
  }

  def lengthWithRecursion[T](l: List[T]): Int = l match {
    case Nil => 0
    case _ :: tail => 1 + lengthWithRecursion(tail)
  }

  // JVM doesn't do tail-call elimination in the general case.
  // Scala *will* do it if the method is either final or is a local function.
  // In this case, `lengthR` is a local function, so it should be properly optimized.
  // For more information, see
  // http://blog.richdougherty.com/2009/04/tail-calls-tailrec-and-trampolines.html
  def lengthWithTailRecursion[T](l: List[T]): Int = {
    @tailrec
    def lengthR(result: Int, curList: List[T]): Int = curList match {
      case Nil => result
      case _ :: tail => lengthR(result + 1, tail)
    }

    lengthR(0, l)
  }

  // More pure functional solution, with folds.
  // Using foldLeft is fundamental in recursive function
  // and will help you prevent stack-overflow exceptions.
  def lengthWithFoldLeft[A](l: List[A]): Int = l.foldLeft(0) { (c, _) => c + 1 }

  // Using foldRight instead
  def lengthWithFoldRight[A](l: List[A]): Int = l.foldRight(0) { (_, c) => c + 1 }

  /*
  The primary difference is the order in which the fold operation iterates through the collection in question. foldLeft starts on the left side—the first item—and iterates to the right; foldRight starts on the right side—the last item—and iterates to the left. fold goes in no particular order.

  Because fold does not go in any particular order, there are constraints on the start value and thus return value (in all three folds the type of the start value must be the same as the return value).

  The first constraint is that the start value must be a supertype of the object you're folding. In our first example we were folding on a type List[Int] and had a start type of Int. Int is a supertype of List[Int].

  The second constraint of fold is that the start value must be neutral, i.e. it must not change the result. For example, the neutral value for an addition operation would be 0, 1 for multiplication, Nil lists, etc.
   */

  def main(args: Array[String]): Unit = {
    val lst = List(1, 1, 2, 3, 5, 8)

    var start = LocalDateTime.now()
    println("Using the built-in function: ")
    println(s"The length of $lst is: ${length(lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println("Using the recursion: ")
    println(s"The length of $lst is: ${lengthWithRecursion(lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toNanos
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed nanoseconds")

    println(s"Wait for 1 second")
    Thread.sleep(1000L)

    start = LocalDateTime.now()
    println("Using the tail recursion: ")
    println(s"The length of $lst is: ${lengthWithTailRecursion(lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toNanos
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed nanoseconds")

    println(s"Wait for 1 second")
    Thread.sleep(1000L)

    start = LocalDateTime.now()
    println("Using the foldLeft: ")
    println(s"The length of $lst is: ${lengthWithFoldLeft(lst)}")
    end = LocalDateTime.now()
    //    elapsed = Duration.between(start, end).toMillis
    //    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
    elapsed = Duration.between(start, end).toNanos
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed nanoseconds")

    start = LocalDateTime.now()
    println("Using the foldRight: ")
    println(s"The length of $lst is: ${lengthWithFoldRight(lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toNanos
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed nanoseconds")
  }
}
