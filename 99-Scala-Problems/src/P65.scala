// P65 (**) Layout a binary tree (2).
//     An alternative layout method is depicted in the illustration opposite.
//     Find out the rules and write the corresponding method.  Hint: On a given
//     level, the horizontal distance between neighboring nodes is constant.
//
//     Use the same conventions as in problem P64.
//
//     scala> Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree2
//     res0: PositionedNode[Char] = T[3,1]('a T[1,2]('b . T[2,3]('c . .)) T[5,2]('d . .))

// The layout rules for a node v with parent u and depth d are as follows:
// * x(v) is x(u) plus or minus 2^(m-d), where m is the maximum depth of the
//   tree.  The leftmost node has x(v) == 1.
// * y(v) == d

import binarytree65._

object P65 {
  def main(args: Array[String]): Unit = {
  }
}
