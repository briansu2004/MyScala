package binarytree57

sealed abstract class Tree[+T] {
  def isMirrorOf[V](tree: Tree[V]): Boolean

  def isSymmetric: Boolean

  def addValue[U >: T <% Ordered[U]](x: U): Tree[U]
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString: String = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"

  def isMirrorOf[V](tree: Tree[V]): Boolean = tree match {
    case t: Node[V] => left.isMirrorOf(t.right) && right.isMirrorOf(t.left)
    case _ => false
  }

  def isSymmetric: Boolean = left.isMirrorOf(right)

  def addValue[U >: T <% Ordered[U]](x: U) =
    if (x < value) Node(value, left.addValue(x), right)
    else Node(value, left, right.addValue(x))
}

case object End extends Tree[Nothing] {
  override def toString = "."

  def isMirrorOf[V](tree: Tree[V]): Boolean = tree == End

  def isSymmetric: Boolean = true

  // We still need the view bound here because it's just syntatic sugar for
  // `def addValue[U](x: U)(implicit f: (U) => Ordered[U])` and if we left it
  // out, the compiler would see the different parameter list and think we
  // were overloading `addValue` instead of overriding it.
  // def addValue[U <% Ordered[U]](x: U) = Node(x)
  override def addValue[U >: Nothing <% Ordered[U]](x: U): Tree[U] = Node(x, End, End)
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}

object Tree {
  def fromList[T <% Ordered[T]](l: List[T]): Tree[T] =
    l.foldLeft(End: Tree[T])((r, e) => r.addValue(e))
}