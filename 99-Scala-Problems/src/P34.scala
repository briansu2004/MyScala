// P34 (**) Calculate Euler's totient function phi(m).
//     Euler's so-called totient function phi(m) is defined as the number of
//     positive integers r (1 <= r < m) that are coprime to m.  As a special
//     case, phi(1) is defined to be 1.
//
//     scala> 10.totient
//     res0: Int = 4

import java.time.{Duration, LocalDateTime}

object P34 {
  def phi(n: Int): Int = ((1 to n) filter {
    P33.isCoprimeTo(_, n)
  }).length

  def main(args: Array[String]): Unit = {
    var n = 10

    var start = LocalDateTime.now()
    println(s"The Euler's totient function of $n is: ${phi(n)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    n = 365
    println(s"The Euler's totient function of $n is: ${phi(n)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    n = 899
    println(s"The Euler's totient function of $n is: ${phi(n)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
