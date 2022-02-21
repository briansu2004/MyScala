// P36 (**) Determine the prime factors of a given positive integer (2).
//     Construct a list containing the prime factors and their multiplicity.
//
//     scala> 315.primeFactorMultiplicity
//     res0: List[(Int, Int)] = List((3,2), (5,1), (7,1))
//
//     Alternately, use a Map for the result.
//     scala> 315.primeFactorMultiplicity
//     res0: Map[Int,Int] = Map(3 -> 2, 5 -> 1, 7 -> 1)

import java.time.{Duration, LocalDateTime}

object P36 {
  def primeFactorMultiplicity(n: Int): Map[Int, Int] = {
    def factorCount(n: Int, p: Int): (Int, Int) =
      if (n % p != 0) (0, n)
      else factorCount(n / p, p) match {
        case (c, d) => (c + 1, d)
      }

    def factorsR(n: Int, ps: LazyList[Int]): Map[Int, Int] =
      if (n == 1) Map()
      else if (P31_2.isPrime(n)) Map(n -> 1)
      else {
        val nps = ps.dropWhile(n % _ != 0)
        val (count, dividend) = factorCount(n, nps.head)
        Map(nps.head -> count) ++ factorsR(dividend, nps.tail)
      }

    factorsR(n, P31_2.primes)
  }

  def primeFactors(n: Int): List[(Int, Int)] =
    (primeFactorMultiplicity(n) map { v => (v._1, v._2) }).toList

  def main(args: Array[String]): Unit = {
    var n = 315

    var start = LocalDateTime.now()
    println(s"The prime factors of $n: ${primeFactorMultiplicity(n)} ${primeFactors(n)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    n = 5
    println(s"The prime factors of $n: ${primeFactorMultiplicity(n)} ${primeFactors(n)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    n = 15
    println(s"The prime factors of $n: ${primeFactorMultiplicity(n)} ${primeFactors(n)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
    start = LocalDateTime.now()

    n = 27
    println(s"The prime factors of $n: ${primeFactorMultiplicity(n)} ${primeFactors(n)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
