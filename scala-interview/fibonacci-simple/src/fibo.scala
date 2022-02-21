import java.time.{Duration, LocalDateTime}
import scala.annotation.tailrec

object fibo {
  def fib1(n:Int):Int = {
    @tailrec
    def fib_tr(n: Int, a: Int, b: Int): Int = n match {
      case 0 => a;
      case _ => fib_tr(n - 1, b, a + b)
    }
    fib_tr(n, 0, 1)
  }

  //val fibStream: Stream[Any] = 0 #:: 1 #:: (fibStream zip fibStream.tail).map(n => n._1 + n._2)

  val fibStream: Stream[BigInt] = {
    def fs(prev: BigInt, curr: BigInt): Stream[BigInt] = prev #:: fs(curr, prev + curr)
    fs(0, 1)
  }

  val fibLazy: LazyList[BigInt] = {
    def fs(prev: BigInt, curr: BigInt): LazyList[BigInt] = prev #:: fs(curr, prev + curr)
    fs(0, 1)
  }

  def main(args: Array[String]): Unit = {
    var start = LocalDateTime.now()
    //(0 to 10).foreach(n => println(s"The Fibonacci number of $n is: ${fib1(n)}"))
    (0 to 10).foreach(n => print(fib1(n) + " "))
    var elapsed = Duration.between(start, LocalDateTime.now()).toMillis
    println(s"Elapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    //(0 to 10).foreach(n => println(s"The Fibonacci number of $n is: ${fibStream(n)}"))
    (0 to 10).foreach(n => print(fibStream(n) + " "))
    elapsed = Duration.between(start, LocalDateTime.now()).toMillis
    println(s"Elapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    //(0 to 10).foreach(n => println(s"The Fibonacci number of $n is: ${fibLazy(n)}"))
    (0 to 10).foreach(n => print(fibLazy(n) + " "))
    elapsed = Duration.between(start, LocalDateTime.now()).toMillis
    println(s"Elapsed:\t$elapsed milliseconds")
  }
}
