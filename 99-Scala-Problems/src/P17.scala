// P17 (*) Split a list into two parts.
//     The length of the first part is given.  Use a Tuple for your result.
//
//     Example:
//     scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

import java.time.{Duration, LocalDateTime}

object P17 {
  // Built-in
  def splitB[T](n: Int, l: List[T]): (List[T], List[T]) = l.splitAt(n)

  // Functional
  def splitF[T](n: Int, l: List[T]): (List[T], List[T]) = (l.take(n), l.drop(n))

  def main(args: Array[String]): Unit = {
    val n = 3
    val lst = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

    var start = LocalDateTime.now()
    println(s"Using built-in: ")
    println(s"After splitting the $lst: \n${splitB(n, lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using functional: ")
    println(s"After splitting the $lst: \n${splitF(n, lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
