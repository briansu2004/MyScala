sealed trait Tree {
  def flatten: List[Int]
}

case class Node(children: List[Tree]) extends Tree {
  def flatten = children.flatMap(_.flatten)
}

case class Leaf(n: Int) extends Tree {
  def flatten = List(n)
}

object fla {
  def main(args: Array[String]): Unit = {
    val t = Node(List(Leaf(1), Leaf(2), Node(List(Leaf(5), Leaf(6)))));

    println(t.flatten);
  }
}
