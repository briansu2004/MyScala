
// P55 (**) Construct completely balanced binary trees.
//     In a completely balanced binary tree, the following property holds for
//     every node: The number of nodes in its left subtree and the number of
//     nodes in its right subtree are almost equal, which means their difference
//     is not greater than one.
//
//     Define an object named Tree.  Write a function Tree.cBalanced to
//     construct completely balanced binary trees for a given number of nodes.
//     The function should generate all solutions.  The function should take as
//     parameters the number of nodes and a single value to put in all of them.
//
//     scala> Tree.cBalanced(4, "x")
//     res0: List(Node[String]) = List(T(x T(x . .) T(x . T(x . .))), T(x T(x . .) T(x T(x . .) .)), ...

//import binarytree55._
import binarytree55.Tree.cBalanced

//import java.time.{Duration, LocalDateTime}

object P55 {
  def main(args: Array[String]): Unit = {
    //println(s"3/2 is: " + 3/2) // 1
    var n = 1
    var v = "x"
//    var start = LocalDateTime.now()
    println(s"All completely balanced binary trees for $n and $v are:\n ${cBalanced(n, v)}")
//    var elapsed = Duration.between(start, LocalDateTime.now()).toMillis
//    println(s"Elapsed:\t$elapsed milliseconds")

    n = 2
//    start = LocalDateTime.now()
    println(s"All completely balanced binary trees for $n and $v are:\n ${cBalanced(n, v)}")
//    elapsed = Duration.between(start, LocalDateTime.now()).toMillis
//    println(s"Elapsed:\t$elapsed milliseconds")

    n = 3
    //    start = LocalDateTime.now()
    println(s"All completely balanced binary trees for $n and $v are:\n ${cBalanced(n, v)}")
    //    elapsed = Duration.between(start, LocalDateTime.now()).toMillis
    //    println(s"Elapsed:\t$elapsed milliseconds")

    n = 4
    //    start = LocalDateTime.now()
    println(s"All completely balanced binary trees for $n and $v are:\n ${cBalanced(n, v)}")
    //    elapsed = Duration.between(start, LocalDateTime.now()).toMillis
    //    println(s"Elapsed:\t$elapsed milliseconds")

    n = 5
    //    start = LocalDateTime.now()
    println(s"All completely balanced binary trees for $n and $v are:\n ${cBalanced(n, v)}")
    //    elapsed = Duration.between(start, LocalDateTime.now()).toMillis
    //    println(s"Elapsed:\t$elapsed milliseconds")
  }
}
