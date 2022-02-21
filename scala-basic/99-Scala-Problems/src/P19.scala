// P19 (**) Rotate a list N places to the left.
//     Examples:
//     scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
//
//     scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
import java.time.{Duration, LocalDateTime}

object P19 {
  // Functional
  def rotate[T](n: Int, l: List[T]): List[T] =  {
    //if (l.isEmpty) l

    val nBounded = if (l.isEmpty) 0 else n % l.length
    if (nBounded < 0) rotate(nBounded + l.length, l)
    else (l drop nBounded) ::: (l take nBounded)
  }

  def main(args: Array[String]): Unit = {
    val lst = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

    var n = 3
    var start = LocalDateTime.now()
    println(s"After rotating the $lst: \n${rotate(n, lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    n = -2
    start = LocalDateTime.now()
    println(s"After rotating the $lst: \n${rotate(n, lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
