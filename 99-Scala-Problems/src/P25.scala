// P25 (*) Generate a random permutation of the elements of a list.
//     Hint: Use the solution of problem P23.
//
//     Example:
//     scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
//     res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)

import java.time.{Duration, LocalDateTime}
import scala.reflect.ClassTag
import scala.util.Random

object P25 {

  import P23._

  // Solution 01
  // O(n^2)
  def randomPermute01[T](l: List[T]): List[T] = randomSelect1(l.length, l)

  // Solution 02
  // The canonical way to shuffle imperatively is Fisher-Yates.
  // It requires a mutable array.
  // O(n)
  def randomPermute02[T:ClassTag](l: List[T]): List[T] = {
    val r = new Random()
    var a = l.toArray
    for (i <- a.length - 1 to 1 by -1) {
      val j = r.nextInt(i + 1)
      val t = a(i)
      a.update(i, a(j))
      a.update(j, t)
    }
    a.toList
  }

  def main(args: Array[String]): Unit = {
    val lst = List('a, 'b, 'c, 'd, 'e, 'f)

    var start = LocalDateTime.now()
    println(s"Using solution 01: ")
    println(s"A random permutation of the list $lst is: \n${randomPermute01(lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using solution 01 again: ")
    println(s"A random permutation of the list $lst is: \n${randomPermute01(lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using solution 02: ")
    println(s"A random permutation of the list $lst is: \n${randomPermute02(lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using solution 02: ")
    println(s"A random permutation of the list $lst is: \n${randomPermute02(lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
