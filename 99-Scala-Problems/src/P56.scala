// P56 (**) Symmetric binary trees.
//     Let us call a binary tree symmetric if you can draw a vertical line
//     through the root node and then the right subtree is the mirror image of
//     the left subtree.  Add an isSymmetric method to the Tree class to check
//     whether a given binary tree is symmetric.  Hint: Write an isMirrorOf
//     method first to check whether one tree is the mirror image of another.
//     We are only interested in the structure, not in the contents of the
//     nodes.
//
//     scala> Node('a', Node('b'), Node('c')).isSymmetric
//     res0: Boolean = true

import binarytree56._

object P56 {
  def main(args: Array[String]): Unit = {
    var bt = Node('a')
    println(s"Is the tree $bt symmetric:\n ${bt.isSymmetric}")

    bt = Node('a', End, Node('c'))
    println(s"Is the tree $bt symmetric:\n ${bt.isSymmetric}")

    bt = Node('a', Node('b'), Node('c'))
    println(s"Is the tree $bt symmetric:\n ${bt.isSymmetric}")

    bt = Node('a',
      Node('b', Node('d'), Node('e')),
      Node('c', End, Node('f', Node('g'), End)))
    println(s"Is the tree $bt symmetric:\n ${bt.isSymmetric}")
  }
}
