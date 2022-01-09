// P58 (**) Generate-and-test paradigm.
//     Apply the generate-and-test paradigm to construct all symmetric,
//     completely balanced binary trees with a given number of nodes.
//
//     scala> Tree.symmetricBalancedTrees(5, "x")
//     res0: List[Node[String]] = List(T(x T(x . T(x . .)) T(x T(x . .) .)), T(x T(x T(x . .) .) T(x . T(x . .))))

import binarytree58._
import binarytree58.Tree.cBalanced

object P58 {
  def main(args: Array[String]): Unit = {
    var n = 1
    var v = "x"
    println(s"All completely symmetric balanced binary trees for $n and $v are:\n ${Tree.symmetricBalancedTrees(n, v)}")

    n = 2
    println(s"All completely symmetric balanced binary trees for $n and $v are:\n ${Tree.symmetricBalancedTrees(n, v)}")

    n = 3
    println(s"All completely symmetric balanced binary trees for $n and $v are:\n ${Tree.symmetricBalancedTrees(n, v)}")

    n = 4
    println(s"All completely symmetric balanced binary trees for $n and $v are:\n ${Tree.symmetricBalancedTrees(n, v)}")

    n = 5
    println(s"All completely symmetric balanced binary trees for $n and $v are:\n ${Tree.symmetricBalancedTrees(n, v)}")
  }
}
