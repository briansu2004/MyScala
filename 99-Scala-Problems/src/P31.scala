// P31 (**) Determine whether a given integer number is prime.
//     scala> 7.isPrime
//     res0: Boolean = true

// A fairly naive implementation for primality testing is simply: a number is
// prime if it it not divisible by any prime number less than or equal to its
// square root.
// Here, we use a Stream to create a lazy infinite list of prime numbers.  The
// mutual recursion between `primes` and `isPrime` works because of the limit
// on `isPrime` to the square root of the number being tested.

/*
// Stream is deprecated
// (Since version 2.13.0) Use LazyList (which is fully lazy) instead of Stream (which has a lazy tail only)
import scala.math.BigInt
object Main extends App {
  val fibs: LazyList[BigInt] =
    BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map{ n => n._1 + n._2 }
  fibs.take(5).foreach(println)
}
*/

//import scala.Int.MaxValue
import java.time.{Duration, LocalDateTime}

object P31 {
  def isPrime(start: Int): Boolean =
    (start > 1) && (primes takeWhile {
      _ <= Math.sqrt(start)
    } forall {
      start % _ != 0
    })

  //val primes = Stream.cons(2, Stream.from(3, 2) filter { _.isPrime })
  //val primes = List(2, 3, 5) filter (_.isPrime)

  //val primes = List(2, 3, 5, 7, 11, 13, 17, 19)
  val primes = Stream.cons(2, Stream.from(3, 2));

  def main(args: Array[String]): Unit = {
    var n = 7;

    var start = LocalDateTime.now()
    println(s"$n is prime? ${isPrime(n)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    n = 9;
    println(s"$n is prime? ${isPrime(n)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    n = 11;
    println(s"$n is prime? ${isPrime(n)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    n = 12;
    println(s"$n is prime? ${isPrime(n)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    n = 435675323;
    println(s"$n is prime? ${isPrime(n)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    n = 435675327;
    println(s"$n is prime? ${isPrime(n)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}

// A fairly naive implementation for primality testing is simply: a number is
// prime if it it not divisible by any prime number less than or equal to its
// square root.
// Here, we use a Stream to create a lazy infinite list of prime numbers.  The
// mutual recursion between `primes` and `isPrime` works because of the limit
// on `isPrime` to the square root of the number being tested.

// Readers interested in more sophisticated (and more efficient) primality tests
// are invited to read http://primes.utm.edu/prove/index.html .  Implementation
// in Scala is left as an exercise for the reader.

// Similarly, a more efficient, functional, lazy, infinite prime list can be found
// at http://article.gmane.org/gmane.comp.lang.haskell.cafe/19470 .  (Haskell
// implementation.)

//  def isPrime(n: Long): Boolean = {
//    false
//  }
