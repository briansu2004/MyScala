// P40 (**) Goldbach's conjecture.
//     Goldbach's conjecture says that every positive even number greater than 2
//     is the sum of two prime numbers.  E.g. 28 = 5 + 23.  It is one of the
//     most famous facts in number theory that has not been proved to be correct
//     in the general case.  It has been numerically confirmed up to very large
//     numbers (much larger than Scala's Int can represent).  Write a function
//     to find the two prime numbers that sum up to a given even integer.
//
//     scala> 28.goldbach
//     res0: (Int, Int) = (5,23)

import java.time.{Duration, LocalDateTime}

object P40 {
  def goldbach(n: Int): (Int, Int) =
    P31_2.primes takeWhile {
      _ <= n / 2
    } find { p => P31_2.isPrime(n - p) } match {
      case None => throw new IllegalArgumentException
      case Some(p1) => (p1, n - p1)
    }

  def main(args: Array[String]): Unit = {
    var n = 28
    var start = LocalDateTime.now()
    println(s"The two prime numbers that sum up to a given even integer $n is: ${goldbach(n)}")
    var elapsed = Duration.between(start, LocalDateTime.now()).toMillis
    println(s"Elapsed:\t$elapsed milliseconds")

    n = 4365776
    start = LocalDateTime.now()
    println(s"The two prime numbers that sum up to a given even integer $n is: ${goldbach(n)}")
    elapsed = Duration.between(start, LocalDateTime.now()).toMillis
    println(s"Elapsed:\t$elapsed milliseconds")

    n = 849647656
    start = LocalDateTime.now()
    println(s"The two prime numbers that sum up to a given even integer $n is: ${goldbach(n)}")
    elapsed = Duration.between(start, LocalDateTime.now()).toMillis
    println(s"Elapsed:\t$elapsed milliseconds")
  }
}
