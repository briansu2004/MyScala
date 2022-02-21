// P39 (*) A list of prime numbers.
//     Given a range of integers by its lower and upper limit, construct a list
//     of all prime numbers in that range.
//
//     scala> listPrimesinRange(7 to 31)
//     res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)

import java.time.{Duration, LocalDateTime}

object P39 {
  def listPrimesinRange(r: Range): List[Int] = {
    (P31_2.primes dropWhile (_ < r.start) takeWhile (_ <= r.last)).toList
  }

  def main(args: Array[String]): Unit = {
    var r: Range = (7 to 31)

    var start = LocalDateTime.now()
    println(s"The prime numbers in the range $r is: ${listPrimesinRange(r)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    r = (1197 to 57854)
    start = LocalDateTime.now()
    println(s"The prime numbers in the range $r is: ${listPrimesinRange(r)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
