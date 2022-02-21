// P21 (*) Insert an element at a given position into a list.
//     Example:
//     scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
//     res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)

import java.time.{Duration, LocalDateTime}

object P21 {
  // Using splitAt
  def insertAt[T](e: T, n: Int, l: List[T]): (List[T]) = l.splitAt(n) match {
    case (pre, post) => pre ::: e :: post
  }

  // My solution (with built-in take & drop)
  def insertAtMine[T](e: T, n: Int, l: List[T]): (List[T]) = {
    l.take(n) ::: e :: l.takeRight(l.length - n)
  }

  def main(args: Array[String]): Unit = {
    val lst = List('a, 'b, 'c, 'd)
    var e = 'new
    var n = 1

    var start = LocalDateTime.now()
    println(s"Using splitAt: ")
    println(s"After inserting $e at the position $n to the $lst: \n${insertAt(e, n, lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using my solution with take and takeRight: ")
    println(s"After inserting $e at the position $n to the $lst: \n${insertAtMine(e, n, lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
/*
a ::: b is equivalent to b.:::(a)
 */