// P70 (**) Tree construction from a node string.
//     We suppose that the nodes of a multiway tree contain single characters.
//     In the depth-first order sequence of its nodes, a special character ^ has
//     been inserted whenever, during the tree traversal, the move is a
//     backtrack to the previous level.
//
//     By this rule, the tree in the figure opposite is represented as:
//     afg^^c^bd^e^^^
//
//     Define the syntax of the string and write a function string2MTree to
//     construct an MTree from a String.  Make the function an implicit
//     conversion from String.  Write the reverse function, and make it the
//     toString method of MTree.
//
//     scala> MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e'))))).toString
//     res0: String = afg^^c^bd^e^^^
import multiwaytree70._

object P70 {
  def main(args: Array[String]): Unit = {
    var mt = MTree('a', List(MTree('f')))
    println(s"The node count of multiway tree $mt is: ${mt.nodeCount}")

    mt = MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e')))))
    println(s"The node count of multiway tree $mt is: ${mt.nodeCount}")
  }
}
