// P18 (**) Extract a slice from a list.
//     Given two indices, I and K, the slice is the list containing the elements
//     from and including the Ith element up to but not including the Kth
//     element of the original list.  Start counting the elements with 0.
//
//     Example:
//     scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: List[Symbol] = List('d, 'e, 'f, 'g)
import java.time.{Duration, LocalDateTime}

object P18 {
  // Built-in
  def sliceB[T](i:Int, k: Int, l: List[T]): List[T] = l.slice(i, k)

  // Functional 01
  def sliceF01[T](i:Int, k: Int, l: List[T]): List[T] = l drop i take (k - (i max 0))

  // Functional 02
  def sliceF02[T](i:Int, k: Int, l: List[T]): List[T] = l.take(k).drop(i)

  def main(args: Array[String]): Unit = {
    val i = 3
    val k = 7
    val lst = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

    var start = LocalDateTime.now()
    println(s"Using built-in: ")
    println(s"After slicing the $lst: \n${sliceB(i, k, lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using functional 01: ")
    println(s"After slicing the $lst: \n${sliceF01(i, k, lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"Using functional 02: ")
    println(s"After slicing the $lst: \n${sliceF02(i, k, lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
