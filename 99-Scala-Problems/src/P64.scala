// P64 (**) Layout a binary tree (1).
//     As a preparation for drawing a tree, a layout algorithm is required to
//     determine the position of each node in a rectangular grid.  Several
//     layout methods are conceivable, one of them is shown in the illustration
//     below.
//
//     In this layout strategy, the position of a node v is obtained by the
//     following two rules:
//     * x(v) is equal to the position of the node v in the inorder sequence
//     * y(v) is equal to the depth of the node v in the tree
//
//     In order to store the position of the nodes, we add a new class with the
//     additional information.
//
//     case class PositionedNode[+T](override val value: T, override val left: Tree[T], override val right: Tree[T], x: Int, y: Int) extends Node[T](value, left, right) {
//       override def toString = "T[" + x.toString + "," + y.toString + "](" + value.toString + " " + left.toString + " " + right.toString + ")"
//     }
//
//     Write a method layoutBinaryTree that turns a tree of normal Nodes into a
//     tree of PositionedNodes.
//
//     scala> Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree
//     res0: PositionedNode[Char] = T[3,1](a T[1,2](b . T[2,3](c . .)) T[4,2](d . .))

import binarytree64._

object P64 {
  def main(args: Array[String]): Unit = {
    var bt = Node('a', Node('b', End, Node('c')), Node('d'))
    println(s"The Layout of $bt is: ${bt.layoutBinaryTree}")


  }
}
