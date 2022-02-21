// P15 (**) Duplicate the elements of a list a given number of times.
//     Example:
//     scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
//     res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

import java.time.{Duration, LocalDateTime}

object P15 {
  def duplicateN[T](n: Int, l: List[T]): List[T] = l flatMap {
    List.fill(n)(_)
  }

  def main(args: Array[String]): Unit = {
    val n = 3
    val lst = List('a, 'b, 'c, 'c, 'd)

    var start = LocalDateTime.now()
    println(s"After duplicating the $lst: \n${duplicateN(n, lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
