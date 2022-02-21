// P61 (*) Count the leaves of a binary tree.
//     A leaf is a node with no successors.  Write a method leafCount to count
//     them.
//
//     scala> Node('x', Node('x'), End).leafCount
//     res0: Int = 1

import binarytree61._

object P61 {
  def main(args: Array[String]): Unit = {
    var nd = Node('x', Node('x'), End)
    println(s"The leaves of a binary tree $nd are: ${nd.leafCount}")

    nd = Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End)))
    println(s"The leaves of a binary tree $nd are: ${nd.leafCount}")
  }
}
