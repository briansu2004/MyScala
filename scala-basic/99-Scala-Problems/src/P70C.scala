// P70C (*) Count the nodes of a multiway tree.
//      Write a method nodeCount which counts the nodes of a given multiway
//      tree.
//
//      scala> MTree('a', List(MTree('f'))).nodeCount
//      res0: Int = 2

import multiwaytree70C._

object P70C {
  def main(args: Array[String]): Unit = {
    var mt = MTree('a', List(MTree('f')))
    println(s"The node count of multiway tree $mt is: ${mt.nodeCount}")

    mt = MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e')))))
    println(s"The node count of multiway tree $mt is: ${mt.nodeCount}")
  }
}
