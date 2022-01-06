// P35 (**) Determine the prime factors of a given positive integer.
//     Construct a flat list containing the prime factors in ascending order.
//
//     scala> 315.primeFactors
//     res0: List[Int] = List(3, 3, 5, 7)

import java.time.{Duration, LocalDateTime}

object P35 {
  def primeFactors(n: Int): List[Int] = {
    def primeFactorsR(n: Int, ps: LazyList[Int]): List[Int] =
      if (P31_2.isPrime(n)) List(n)
      else if (n % ps.head == 0) ps.head :: primeFactorsR(n / ps.head, ps)
      else primeFactorsR(n, ps.tail)

    primeFactorsR(n, P31_2.primes)
  }

  def main(args: Array[String]): Unit = {
    var n = 315

    var start = LocalDateTime.now()
    println(s"The prime factors of $n: ${primeFactors(n)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    n = 5
    println(s"The prime factors of $n: ${primeFactors(n)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    n = 15
    println(s"The prime factors of $n: ${primeFactors(n)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
    start = LocalDateTime.now()

    n = 27
    println(s"The prime factors of $n: ${primeFactors(n)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
