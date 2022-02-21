// P32 (**) Determine the greatest common divisor of two positive integer
//          numbers.
//     Use Euclid's algorithm.
//
//     scala> gcd(36, 63)
//     res0: Int = 9

import java.time.{Duration, LocalDateTime}
import scala.annotation.tailrec

object P32 {
  @tailrec
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def main(args: Array[String]): Unit = {
    var a = 18
    var b = 24

    var start = LocalDateTime.now()
    println(s"The GCD of $a and $b is prime? ${gcd(a, b)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    a = 365
    b = 240
    println(s"The GCD of $a and $b is prime? ${gcd(a, b)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    a = 899
    b = 1765
    println(s"The GCD of $a and $b is prime? ${gcd(a, b)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
