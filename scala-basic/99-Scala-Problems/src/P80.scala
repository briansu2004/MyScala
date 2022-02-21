
// P80 (***) Conversions.
//     Write methods to generate the graph-term and adjacency-list forms from a
//     Graph.  Write another method to output the human-friendly form for a
//     graph.  Make it the toString method for Graph.  Write one more function
//     to create a graph of Chars and Ints from a human-friendly string.  Make
//     it implicitly convert from Strings to Graphs.
//
//     scala> Graph.fromString("[b-c, f-c, g-h, d, f-b, k-f, h-g]").toTermForm
//     res0: (List[String], List[(String, String, Unit)]) = (List(d, k, h, c, f, g, b),List((h,g,()), (k,f,()), (f,b,()), (g,h,()), (f,c,()), (b,c,())))
//
//     scala> Digraph.fromStringLabel("[p>q/9, m>q/7, k, p>m/5]").toAdjacentForm
//     res1: List[(String, List[(String, Int)])] = List((m,List((q,7))), (p,List((m,5), (q,9))), (k,List()), (q,List()))

import graph80._

object P80 {
  def main(args: Array[String]): Unit = {
    var str = "[b-c, f-c, g-h, d, f-b, k-f, h-g]"
    //var g = Graph.fromString(str)

    //println(s"The multiway tree from lispy string $str is: ${MTree.fromLispyString(str)}")

  }
}
