// P72 (*) Construct the postorder sequence of the tree nodes.
//     Write a method postorder which constructs the postorder sequence of the
//     nodes of a multiway tree.  The result should be a List.
//
//     scala> "afg^^c^bd^e^^^".postorder
//     res0: List[Char] = List(g, f, c, d, e, b, a)

import multiwaytree72._

object P72 {
  def main(args: Array[String]): Unit = {
    var str = "afg^^c^bd^e^^"
    println(s"The postorder of multiway tree $str is: ${MTree.string2MTree(str).postorder}")
    println(s"The preorder of multiway tree $str is: ${MTree.string2MTree(str).preorder}")
  }
}
