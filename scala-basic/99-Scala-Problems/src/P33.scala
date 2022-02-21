// P33 (*) Determine whether two positive integer numbers are coprime.
//     Two numbers are coprime if their greatest common divisor equals 1.
//
//     scala> 35.isCoprimeTo(64)
//     res0: Boolean = true

import java.time.{Duration, LocalDateTime}

object P33 {
  def isCoprimeTo(a: Int, b: Int): Boolean = P32.gcd(a, b) == 1

  def main(args: Array[String]): Unit = {
    var a = 18
    var b = 24

    var start = LocalDateTime.now()
    println(s"$a and $b is coprimeTo? ${isCoprimeTo(a, b)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    a = 365
    b = 240
    println(s"$a and $b is coprimeTo? ${isCoprimeTo(a, b)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    a = 899
    b = 1765
    println(s"$a and $b is coprimeTo? ${isCoprimeTo(a, b)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
