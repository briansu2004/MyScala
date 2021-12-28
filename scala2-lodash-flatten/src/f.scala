//object f {
//  def main(args: Array[String]): Unit = {
//    println(List(List(1, 1), 2, List(3, List(5, 8))));
//    println(List(List(1, 1), 2, List(3, List(5, 8))).flatten);
//  }
//}

//sealed trait Tree {
//  def flatten: List[Int]
//}
//
//case class Node(children: List[Tree]) extends Tree {
//  def flatten = children.flatMap(_.flatten)
//}
//
//case class Leaf(n: Int) extends Tree {
//  def flatten = List(n)
//}
//
//val t = Node(List(Leaf(1), Leaf(2), Node(List(Leaf(5), Leaf(6)))));
//
////t.flatten; // List(1, 2, 5, 6)
//
//def flat(t: Tree): List[Int] = t match {
//  case Node(children) => children.flatMap(c => flat(c))
//  case Leaf(n) => List(n)
//}
//
//flat(t);


//def flatten(ls: List[Any]): List[Any] = ls flatMap {
//  case i: List[_] => flatten(i)
//  case e => List(e)
//}
//
//val k = List(1, List(2, 3), List(List(List(List(4)), List(5)), List(6, 7)), 8)
//
//flatten(k)

object f {
  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case i: List[_] => flatten(i)
    case e => List(e)
  }

  def main(args: Array[String]): Unit = {
    val k = List(1, List(2, 3), List(List(List(List(4)), List(5)), List(6, 7)), 8);
    println(flatten(k));
  }
}