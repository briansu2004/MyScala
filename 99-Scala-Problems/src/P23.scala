// P23 (**) Extract a given number of randomly selected elements from a list.
//     Example:
//     scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
//     res0: List[Symbol] = List('e, 'd, 'a)
//
//     Hint: Use the answer to P20.

import java.time.{Duration, LocalDateTime}

object P23 {

  import P20.removeAt

  // Standard recursion
  def randomSelect1[T](n: Int, l: List[T]): List[T] =
    if (n <= 0) Nil
    else {
      val (rest, e) = removeAt((new util.Random).nextInt(l.length), l)
      e :: randomSelect1(n - 1, rest)
    }

  // My solution
  def randomSelectMine[T](n: Int, l: List[T]): List[T] = {
    val r = scala.util.Random
    List.range(0, n).flatMap(_ => {
      //val k = r.nextInt(l.length) + 1
      //l.take(k).drop(k - 1)
      val k = r.nextInt(l.length)
      l.slice(k, k + 1)
    })
  }

  def main(args: Array[String]): Unit = {
    val lst = List('a, 'b, 'c, 'd, 'f, 'g, 'h)
    val n = 3

    var start = LocalDateTime.now()
    println(s"Using standard recursion: ")
    println(s"After random-selecting $n elements of the $lst: \n${randomSelect1(n, lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using standard recursion again: ")
    println(s"After random-selecting $n elements of the $lst: \n${randomSelect1(n, lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using my solution with random and slice: ")
    println(s"After random-selecting $n elements of the $lst: \n${randomSelectMine(n, lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using my solution again with random and slice: ")
    println(s"After random-selecting $n elements of the $lst: \n${randomSelectMine(n, lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using my solution 3rd time with random and slice: ")
    println(s"After random-selecting $n elements of the $lst: \n${randomSelectMine(n, lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
