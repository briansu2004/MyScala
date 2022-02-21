// P59 (**) Construct height-balanced binary trees.
//     In a height-balanced binary tree, the following property holds for every
//     node: The height of its left subtree and the height of its right subtree
//     are almost equal, which means their difference is not greater than one.
//
//     Write a method Tree.hbalTrees to construct height-balanced binary trees
//     for a given height with a supplied value for the nodes.  The function
//     should generate all solutions.
//
//     scala> Tree.hbalTrees(3, "x")
//     res0: List[Node[String]] = List(T(x T(x T(x . .) T(x . .)) T(x T(x . .) T(x . .))), T(x T(x T(x . .) T(x . .)) T(x T(x . .) .)), ...

import binarytree59._

object P59 {
  def main(args: Array[String]): Unit = {
    var n = 1
    var v = "x"
    println(s"All height-balanced binary trees for $n and $v are:\n ${Tree.hbalTrees(n, v)}")

    n = 2
    println(s"All height-balanced binary trees for $n and $v are:\n ${Tree.hbalTrees(n, v)}")

    n = 3
    println(s"All height-balanced binary trees for $n and $v are:\n ${Tree.hbalTrees(n, v)}")

//    n = 4
//    println(s"All height-balanced binary trees for $n and $v are:\n ${Tree.hbalTrees(n, v)}")
//
//    n = 5
//    println(s"All height-balanced binary trees for $n and $v are:\n ${Tree.hbalTrees(n, v)}")
  }
}
