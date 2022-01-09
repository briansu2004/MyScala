// P62B (*) Collect the nodes at a given level in a list.
//      A node of a binary tree is at level N if the path from the root to the
//      node has length N-1.  The root node is at level 1.  Write a method
//      atLevel to collect all nodes at a given level in a list.
//
//      scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(2)
//      res0: List[Char] = List(b, c)
//
//      Using atLevel it is easy to construct a method levelOrder which creates
//      the level-order sequence of the nodes.  However, there are more
//      efficient ways to do that.

import binarytree62B._

object P62B {
  def main(args: Array[String]): Unit = {
    var lvl = 2

    var nd = Node('x', Node('x'), End)
    println(s"The nodes count of a binary tree $nd are: ${nd.nodeCount}")
    println(s"The leaves count of a binary tree $nd are: ${nd.leafCount}")
    println(s"The leaves of a binary tree $nd are: ${nd.leafList}")
    println(s"The internal nodes count of a binary tree $nd are: ${nd.internalNodesCount}")
    println(s"The internal nodes of a binary tree $nd are: ${nd.internalList}")
    println(s"The nodes of $nd at level $lvl are: ${nd.atLevel(lvl)}")

    nd = Node('a', Node('b'), Node('c', Node('d'), Node('e')))
    println(s"The nodes count of a binary tree $nd are: ${nd.nodeCount}")
    println(s"The leaves count of a binary tree $nd are: ${nd.leafCount}")
    println(s"The leaves of a binary tree $nd are: ${nd.leafList}")
    println(s"The internal nodes count of a binary tree $nd are: ${nd.internalNodesCount}")
    println(s"The internal nodes of a binary tree $nd are: ${nd.internalList}")
    println(s"The nodes of $nd at level $lvl are: ${nd.atLevel(lvl)}")

    nd = Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End)))
    println(s"The nodes count of a binary tree $nd are: ${nd.nodeCount}")
    println(s"The leaves count of a binary tree $nd are: ${nd.leafCount}")
    println(s"The leaves of a binary tree $nd are: ${nd.leafList}")
    println(s"The internal nodes count of a binary tree $nd are: ${nd.internalNodesCount}")
    println(s"The internal nodes of a binary tree $nd are: ${nd.internalList}")
    println(s"The nodes of $nd at level $lvl are: ${nd.atLevel(lvl)}")
    lvl = 3
    println(s"The nodes of $nd at level $lvl are: ${nd.atLevel(lvl)}")
    lvl = 4
    println(s"The nodes of $nd at level $lvl are: ${nd.atLevel(lvl)}")
    lvl = 5
    println(s"The nodes of $nd at level $lvl are: ${nd.atLevel(lvl)}")
  }
}
