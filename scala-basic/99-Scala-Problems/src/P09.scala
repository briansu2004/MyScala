// P09 (**) Pack consecutive duplicates of list elements into sub-lists.
//     If a list contains repeated elements they should be placed in separate sub-lists.
//
//     Example:
//     scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//     res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
import java.time.{Duration, LocalDateTime}

object P09 {
  // Standard recursion
  def pack[T](l: List[T]): List[List[T]] = {
    if (l.isEmpty) {
      List(List())
    } else {
      val (packed, next) = l span {
        _ == l.head
      }
      if (next == Nil) {
        List(packed)
      } else {
        packed :: pack(next)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val lst = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

    var start = LocalDateTime.now()
    println("Using standard recursion: ")
    println(s"After packing the $lst: \n${pack(lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

//    println("Using tail recursion: ")
//    println(s"After packing the $lst: \n${tailrecPack(lst)}")
  }
}
