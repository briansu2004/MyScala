// P62 (*) Collect the internal nodes of a binary tree in a list.
//     An internal node of a binary tree has either one or two non-empty
//     successors.  Write a method internalList to collect them in a list.
//
//     scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList
//     res0: List[Char] = List(a, c)

import binarytree62._

object P62 {
  def main(args: Array[String]): Unit = {
    var nd = Node('x', Node('x'), End)
    println(s"The nodes count of a binary tree $nd are: ${nd.nodeCount}")
    println(s"The leaves count of a binary tree $nd are: ${nd.leafCount}")
    println(s"The leaves of a binary tree $nd are: ${nd.leafList}")
    println(s"The internal nodes count of a binary tree $nd are: ${nd.internalNodesCount}")
    println(s"The internal nodes of a binary tree $nd are: ${nd.internalList}")

    nd = Node('a', Node('b'), Node('c', Node('d'), Node('e')))
    println(s"The nodes count of a binary tree $nd are: ${nd.nodeCount}")
    println(s"The leaves count of a binary tree $nd are: ${nd.leafCount}")
    println(s"The leaves of a binary tree $nd are: ${nd.leafList}")
    println(s"The internal nodes count of a binary tree $nd are: ${nd.internalNodesCount}")
    println(s"The internal nodes of a binary tree $nd are: ${nd.internalList}")

    nd = Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End)))
    println(s"The nodes count of a binary tree $nd are: ${nd.nodeCount}")
    println(s"The leaves count of a binary tree $nd are: ${nd.leafCount}")
    println(s"The leaves of a binary tree $nd are: ${nd.leafList}")
    println(s"The internal nodes count of a binary tree $nd are: ${nd.internalNodesCount}")
    println(s"The internal nodes of a binary tree $nd are: ${nd.internalList}")
  }
}
