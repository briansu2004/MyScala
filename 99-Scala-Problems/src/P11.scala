// P11 (*) Modified run-length encoding.
//     Modify the result of problem P10 in such a way that if an element has no
//     duplicates it is simply copied into the result list.  Only elements with
//     duplicates are transferred as (N, E) terms.
//
//     Example:
//     scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//     res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))

import java.time.{Duration, LocalDateTime}

object P11 {

  import P10.encode

  def encodeModified[T](l: List[T]): List[Any] = {
    encode(l) map { t => if (t._1 == 1) t._2 else t }
  }

  def main(args: Array[String]): Unit = {
    val lst = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

    var start = LocalDateTime.now()
    println("Using standard recursion: ")
    println(s"After modified encoding the $lst: \n${encodeModified(lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}

/*
_._1 calls the method _1 on the wildcard parameter _, which gets the first element of a tuple.
Thus, sortWith(_._1 < _._1) sorts the list of tuple by their first element.

++ does concatenation for sequences.
Usually you can use flatten for that.

Use ::: instead of ++
 */