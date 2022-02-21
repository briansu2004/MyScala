// P20 (*) Remove the Kth element from a list.
//     Return the list and the removed element in a Tuple.  Elements are
//     numbered from 0.
//
//     Example:
//     scala> removeAt(1, List('a, 'b, 'c, 'd))
//     res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)

import java.time.{Duration, LocalDateTime}

object P20 {
  // match
  def removeAt[T](n: Int, l: List[T]): (List[T], T) = l.splitAt(n) match {
    case (Nil, _) if n < 0 => throw new NoSuchElementException
    case (pre, e :: post) => (pre ::: post, e)
    case (pre, Nil) => throw new NoSuchElementException
  }

  // My solution (with built-in take & drop)
  def removeAtMine01[T](n: Int, l: List[T]): (List[T], T) = {
    (l.take(n) ::: l.takeRight(l.length - n - 1), l.take(n + 1).drop(n).head)
  }

  // My solution (with built-in zipWithIndex)
  def removeAtMine02[T](n: Int, l: List[T]): (List[T], T) = {
    ((l.zipWithIndex filter { v => v._2 != n } map {
      _._1
    }), (l.zipWithIndex filter { v => v._2 == n } map {
      _._1
    }).head)
  }

  def main(args: Array[String]): Unit = {
    val lst = List('a, 'b, 'c, 'd)
    var n = 1

    var start = LocalDateTime.now()
    println(s"Using match: ")
    println(s"After removing $n of the $lst: \n${removeAt(n, lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using my solution 01: ")
    println(s"After removing $n of the $lst: \n${removeAtMine01(n, lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using my solution 02: ")
    println(s"After removing $n of the $lst: \n${removeAtMine02(n, lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    //    n = 2
    //    start = LocalDateTime.now()
    //    println(s"Using my solution: ")
    //    println(s"After removing $n of the $lst: \n${removeAtMine(n, lst)}")
    //    end = LocalDateTime.now()
    //    elapsed = Duration.between(start, end).toMillis
    //    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
