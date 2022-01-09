// P60 (**) Construct height-balanced binary trees with a given number of nodes.
//     Consider a height-balanced binary tree of height H.  What is the maximum
//     number of nodes it can contain?  Clearly, MaxN = 2H - 1.  However, what
//     is the minimum number MinN?  This question is more difficult.  Try to
//     find a recursive statement and turn it into a function minHbalNodes that
//     takes a height and returns MinN.
//
//     scala> minHbalNodes(3)
//     res0: Int = 4
//
//     On the other hand, we might ask: what is the maximum height H a
//     height-balanced binary tree with N nodes can have?  Write a maxHbalHeight
//     function.
//
//     scala> maxHbalHeight(4)
//     res1: Int = 3
//
//     Now, we can attack the main problem: construct all the height-balanced
//     binary trees with a given nuber of nodes.
//
//     scala> Tree.hbalTreesWithNodes(4, "x")
//     res2: List[Node[String]] = List(T(x T(x T(x . .) .) T(x . .)), T(x T(x . T(x . .)) T(x . .)), ...
//
//     Find out how many height-balanced trees exist for N = 15.

import binarytree60._

import java.time.{Duration, LocalDateTime}

object P60 {
  def main(args: Array[String]): Unit = {
    var h = 3
    var n = 4
    var v = "x"

    println(s"For a height-balanced binary tree of height $h, the number of nodes are between ${Tree.minHbalNodes(h)}" +
      s" and ${Tree.maxHbalNodes(h)}.")

    println(s"For a height-balanced binary tree with $n nodes, the hight is between ${Tree.minHbalHeight(n)} and " +
      s"${Tree.maxHbalHeight(n)}.")

    h = 10
    n = 10

    println(s"For a height-balanced binary tree of height $h, the number of nodes are between ${Tree.minHbalNodes(h)}" +
      s" and ${Tree.maxHbalNodes(h)}.")

    println(s"For a height-balanced binary tree with $n nodes, the hight is between ${Tree.minHbalHeight(n)} and " +
      s"${Tree.maxHbalHeight(n)}.")

    /*
    For a height-balanced binary tree of height 50, the number of nodes are between -1408458270 and 2147483646.
    Elapsed:	70 seconds
    For a height-balanced binary tree with 50 nodes, the hight is between 6 and 7.
    Elapsed:	0 seconds
     */

    h = 55
    n = 55

    var start = LocalDateTime.now()
    println(s"For a height-balanced binary tree of height $h, the number of nodes are between ${Tree.minHbalNodes(h)}" +
      s" and ${Tree.maxHbalNodes(h)}.")
    var elapsed = Duration.between(start, LocalDateTime.now()).toSeconds
    println(s"Elapsed:\t$elapsed seconds")

    start = LocalDateTime.now()
    println(s"For a height-balanced binary tree with $n nodes, the hight is between ${Tree.minHbalHeight(n)} and " +
      s"${Tree.maxHbalHeight(n)}.")
    elapsed = Duration.between(start, LocalDateTime.now()).toSeconds
    println(s"Elapsed:\t$elapsed seconds")

    //    n = 15
    //    println(s"All the height-balanced binary trees with $n nodes are:\n ${Tree.hbalTreesWithNodes(n, v)}")
  }
}
