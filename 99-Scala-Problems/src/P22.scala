// P22 (*) Create a list containing all integers within a given range.
//     Example:
//     scala> range(4, 9)
//     res0: List[Int] = List(4, 5, 6, 7, 8, 9)

import java.time.{Duration, LocalDateTime}
import scala.annotation.tailrec

object P22 {
  // Built-in
  def rangeB(b: Int, e: Int): List[Int] = List.range(b, e + 1)

  // Standard recursion
  def rangeRecursion(b: Int, e: Int): List[Int] =
    if (e < b) Nil
    else b :: rangeRecursion(b + 1, e)

  // TailRecursion
  def rangeTailRecursion(b: Int, e: Int): List[Int] = {
    @tailrec
    def rangeR(e: Int, curList: List[Int]): List[Int] = {
      if (e < b) curList
      else rangeR(e - 1, e :: curList)
    }
    rangeR(e, Nil)
  }

  def main(args: Array[String]): Unit = {
    val b: Int = 4
    val e: Int = 9

    var start = LocalDateTime.now()
    println(s"Using built-in: ")
    println(s"Creatting a list between $b adn $e: \n${rangeB(b, e)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using standard recursion: ")
    println(s"Creatting a list between $b adn $e: \n${rangeRecursion(b, e)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using tail recursion: ")
    println(s"Creatting a list between $b adn $e: \n${rangeTailRecursion(b, e)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
