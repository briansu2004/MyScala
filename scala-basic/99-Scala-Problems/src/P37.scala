// P37 (**) Calculate Euler's totient function phi(m) (improved).
//     See problem P34 for the definition of Euler's totient function.  If the
//     list of the prime factors of a number m is known in the form of problem
//     P36 then the function phi(m>) can be efficiently calculated as follows:
//     Let [[p_1, m_1], [p_2, m_2], [p_3, m_3], ...] be the list of prime
//     factors (and their multiplicities) of a given number m.  Then phi(m) can
//     be calculated with the following formula:
//
//     phi(m) = (p_1-1)*p_1^(m_1-1) * (p_2-1)*p_2^(m_2-1) * (p_3-1)*p_3^(m_3-1) * ...
//
//     Note that a^b stands for the bth power of a.

import java.time.{Duration, LocalDateTime}

object P37 {
  def phi(n: Int): Int = P36.primeFactorMultiplicity(n).foldLeft(1) { (r, f) =>
    f match {
      case (p, m) => r * (p - 1) * Math.pow(p, m - 1).toInt
    }
  }
  // 10 -> 4
  // 10 -> (2, 1), (5, 1) -> (2 - 1) * 2 ^ 0 * (5 - 1) * 4 ^ 0 -> 4

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
