package multiwaytree70C

case class MTree[+T](value: T, children: List[MTree[T]]) {
  def this(value: T) = this(value, List())

  override def toString = "M(" + value.toString + " {" + children.map(_.toString).mkString(",") + "})"

  def nodeCount: Int = children.foldLeft(1)(_ + _.nodeCount)
}

object MTree {
  def apply[T](value: T) = new MTree(value, List())

  def apply[T](value: T, children: List[MTree[T]]) = new MTree(value, children)

}
