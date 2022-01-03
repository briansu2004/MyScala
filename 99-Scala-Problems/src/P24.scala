// P24 (*) Lotto: Draw N different random numbers from the set 1..M.
//     Example:
//     scala> lotto(6, 49)
//     res0: List[Int] = List(23, 1, 17, 33, 21, 37)

import java.time.{Duration, LocalDateTime}

object P24 {
  // My solution 01
  def lottoMine01(count: Int, max: Int): List[Int] = {
    val r = scala.util.Random
    List.range(0, count).flatMap(_ => List(r.nextInt(max)))
  }

  // My solution 02
  def lottoMine02(count: Int, max: Int): List[Int] = {
    val r = scala.util.Random
    //val a = 1 to count
    //val result = for (i <- 1 to count) yield r.nextInt(max)
    for (i <- List.range(0, count)) yield r.nextInt(max)
  }

  def main(args: Array[String]): Unit = {
    val count = 6
    val max = 49

    var start = LocalDateTime.now()
    println(s"Using my solution 01: ")
    println(s"Draw $count different random numbers from the set 1..$max once: \n${lottoMine01(count, max)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using my solution 01 again: ")
    println(s"Draw $count different random numbers from the set 1..$max again: \n${lottoMine01(count, max)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using my solution 01 3rd time: ")
    println(s"Draw $count different random numbers from the set 1..$max 3rd time: \n${lottoMine01(count, max)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using my solution 01 3rd time: ")
    println(s"Draw $count different random numbers from the set 1..$max: \n${lottoMine02(count, max)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using my solution 01 3rd time: ")
    println(s"Draw $count different random numbers from the set 1..$max again: \n${lottoMine02(count, max)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using my solution 01 3rd time: ")
    println(s"Draw $count different random numbers from the set 1..$max 3rd time: \n${lottoMine02(count, max)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
