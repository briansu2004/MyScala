// P28 (**) Sorting a list of lists according to length of sublists.
//     a) We suppose that a list contains elements that are lists themselves.
//        The objective is to sort the elements of the list according to their
//        length.  E.g. short lists first, longer lists later, or vice versa.
//     Example:
//     scala> lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
//     res0: List[List[Symbol]] = List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))
//
//     b) Again, we suppose that a list contains elements that are lists
//        themselves.  But this time the objective is to sort the elements
//        according to their length frequency; i.e. in the default, sorting is
//        done ascendingly, lists with rare lengths are placed, others with a
//        more frequent length come later.
//     Example:
//     scala> lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
//     res1: List[List[Symbol]] = List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))
//
//     Note that in the above example, the first two lists in the result have
//     length 4 and 1 and both lengths appear just once.  The third and fourth
//     lists have length 3 and there are two list of this length.  Finally, the
//     last three lists have length 2.  This is the most frequent length.

import java.time.{Duration, LocalDateTime}

object P28 {

  //  def lsort[A](ls: List[List[A]]): List[List[A]] =
  //    ls sort {
  //      _.length < _.length
  //    }

  def lsort[T](ls: List[List[T]]) = {
    ls.sortWith { (a, b) => a.length < b.length }
  }

  //  def lsortFreq[A](ls: List[List[A]]): List[List[A]] = {
  //    val freqs = Map(encode(ls map {
  //      _.length
  //    } sort {
  //      _ < _
  //    }) map {
  //      _.swap
  //    }: _*)
  //    ls sort { (e1, e2) => freqs(e1.length) < freqs(e2.length) }
  //  }

  def lsortFreq[T](ls: List[List[T]]) = {
    val lengthMap = scala.collection.mutable.Map[Int, Int]()

    for (l <- ls) {
      val len = l.length
      if (!lengthMap.contains(len)) {
        lengthMap(len) = 1
      } else {
        lengthMap(len) += 1
      }
    }

    ls sortWith { (a, b) => lengthMap(a.length) < lengthMap(b.length) }
  }

  def main(args: Array[String]): Unit = {
    val lst = List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n),
      List('o))

    var start = LocalDateTime.now()
    println(s"After sorting the list $lst: \n${lsort(lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    start = LocalDateTime.now()
    println(s"After sorting the list $lst by freqency: \n${lsortFreq(lst)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
