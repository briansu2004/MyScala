// P12 (**) Decode a run-length encoded list.
//     Given a run-length code list generated as specified in problem P10,
//     construct its uncompressed version.
//
//     Example:
//     scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
//     res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

import java.time.{Duration, LocalDateTime}

object P12 {
  def decode[T](l: List[(Int, T)]): List[T] = {
    l flatMap { e => List.fill(e._1)(e._2) }
  }

  def main(args: Array[String]): Unit = {
    val lst = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))

    var start = LocalDateTime.now()
    println(s"After decoding the $lst: \n${decode(lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
