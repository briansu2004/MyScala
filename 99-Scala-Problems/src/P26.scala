// P26 (**) Generate the combinations of K distinct objects chosen from the N
//          elements of a list.
//     In how many ways can a committee of 3 be chosen from a group of 12
//     people?  We all know that there are C(12,3) = 220 possibilities (C(N,K)
//     denotes the well-known binomial coefficient).  For pure mathematicians,
//     this result may be great.  But we want to really generate all the possibilities.
//
//     Example:
//     scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
//     res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...

import java.time.{Duration, LocalDateTime}

object P26 {
  // flatMapSublists is like list.flatMap, but instead of passing each element
  // to the function, it passes successive sublists of L.
  def flatMapSublists[A, B](l: List[A])(f: (List[A]) => List[B]): List[B] =
    l match {
      case Nil => Nil
      case sublist@(_ :: tail) => f(sublist) ::: flatMapSublists(tail)(f)
    }

  def combinations[T](n: Int, ls: List[T]): List[List[T]] =
    if (n == 0) List(Nil)
    else flatMapSublists(ls) { sl =>
      combinations(n - 1, sl.tail) map {
        sl.head :: _
      }
    }

  def main(args: Array[String]): Unit = {
    val lst = List('a, 'b, 'c, 'd, 'e, 'f)
    val n = 3

    var start = LocalDateTime.now()
    println(s"The combinations of $n distinct objects chosen from the list $lst is: \n${combinations(n, lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
