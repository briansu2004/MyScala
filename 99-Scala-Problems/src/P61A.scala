// 61A (*) Collect the leaves of a binary tree in a list.
//     A leaf is a node with no successors.  Write a method leafList to
//     collect them in a list.
//
//     scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList
//     res0: List[Char] = List(b, d, e)

// Note that leafCount from P61 is no longer an abstract method.

import binarytree61A._

object P61A {
  def main(args: Array[String]): Unit = {
    var nd = Node('x', Node('x'), End)
    println(s"The leaves count of a binary tree $nd are: ${nd.leafCount}")
    println(s"The leaves of a binary tree $nd are: ${nd.leafList}")

    nd = Node('a', Node('b'), Node('c', Node('d'), Node('e')))
    println(s"The leaves count of a binary tree $nd are: ${nd.leafCount}")
    println(s"The leaves of a binary tree $nd are: ${nd.leafList}")

    nd = Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End)))
    println(s"The leaves count of a binary tree $nd are: ${nd.leafCount}")
    println(s"The leaves of a binary tree $nd are: ${nd.leafList}")
  }
}
