// P27 (**) Group the elements of a set into disjoint subsets.
//     a) In how many ways can a group of 9 people work in 3 disjoint subgroups
//        of 2, 3 and 4 persons?  Write a function that generates all the
//        possibilities.
//        Example:
//        scala> group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
//        res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida)), ...
//     b) Generalize the above predicate in a way that we can specify a list
//        of group sizes and the predicate will return a list of groups.
//        scala> group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
//        res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David), List(Evi, Flip, Gary, Hugo, Ida)), ...
//     Note that we do not want permutations of the group members;
//     i.e. ((Aldo, Beat), ...) is the same solution as ((Beat, Aldo), ...).
//     However, we make a difference between ((Aldo, Beat), (Carla, David), ...)
//     and ((Carla, David), (Aldo, Beat), ...).
//     You may find more about this combinatorial problem in a good book on
//     discrete mathematics under the term "multinomial coefficients".

import java.time.{Duration, LocalDateTime}

object P27 {

  import P26.combinations

//  def group3[T](ls: List[T]): List[List[List[T]]] =
//    for {
//      a <- combinations(2, ls)
//      noA = ls diff a
//      b <- combinations(3, noA)
//    } yield List(a, b, noA diff b)

  def group[T](ns: List[Int], ls: List[T]): List[List[List[T]]] = ns match {
    case Nil => List(Nil)
    case n :: ns => combinations(n, ls) flatMap { c =>
      group(ns, ls diff c) map {
        c :: _
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val st = List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")

    var ns = List(2, 3, 4)
    var start = LocalDateTime.now()
    println(s"Group the elements of a set $st into disjoint subsets $ns is: \n${group(ns, st)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")

    ns = List(2, 2, 5)
    start = LocalDateTime.now()
    println(s"Group the elements of a set $st into disjoint subsets $ns is: \n${group(ns, st)}")
    end = LocalDateTime.now()
    elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
