// P14 (*) Duplicate the elements of a list.
//     Example:
//     scala> duplicate(List('a, 'b, 'c, 'c, 'd))
//     res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

import java.time.{Duration, LocalDateTime}

object P14 {
  def duplicate01[T](l: List[T]): List[T] = l flatMap {
    e => List(e, e)
  }

  def duplicate02[T](l: List[T]): List[T] = l flatMap {
    e => e :: e :: Nil
  }

  def duplicate03[T](l: List[T]): List[T] = l flatMap {
    e => List.fill(2)(e)
  }

  def main(args: Array[String]): Unit = {
    val lst = List('a, 'b, 'c, 'c, 'd)

    var start = LocalDateTime.now()
    println(s"After duplicating the $lst: \n${duplicate01(lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"After duplicating the $lst: \n${duplicate02(lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"After duplicating the $lst: \n${duplicate03(lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
