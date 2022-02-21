// P16 (**) Drop every Nth element from a list.
//     Example:
//     scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
import java.time.{Duration, LocalDateTime}

object P16 {
  // Functional
  def drop[T](n: Int, l: List[T]): List[T] =  {
    l.zipWithIndex filter { v => (v._2 + 1) % n != 0 } map { _._1 }
  }

  def main(args: Array[String]): Unit = {
    val n = 3
    val lst = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

    var start = LocalDateTime.now()
    println(s"After droping the $lst: \n${drop(n, lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
