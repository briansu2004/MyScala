// P71 (*) Determine the internal path length of a tree.
//     We define the internal path length of a multiway tree as the total sum of
//     the path lengths from the root to all nodes of the tree.  By this
//     definition, the tree in the figure of problem P70 has an internal path
//     length of 9.  Write a method internalPathLength to return that sum.
//
//     scala> "afg^^c^bd^e^^".internalPathLength
//     res0: Int = 9


import multiwaytree71._

object P71 {
  def main(args: Array[String]): Unit = {
    var str = "afg^^c^bd^e^^"
    println(s"The internal path length of multiway tree $str is: ${MTree.string2MTree(str).internalPathLength}")
//    println(s"The external path length of multiway tree $str is: ${MTree.string2MTree(str).externalPathLength}")

//    var mt = MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e')))))
//    println(s"The external path length of multiway tree $mt is: ${mt.externalPathLength}")
  }
}
