package binarytree56

sealed abstract class Tree[+T] {
  def isMirrorOf[V](tree: Tree[V]): Boolean

  def isSymmetric: Boolean
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString: String = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"

  def isMirrorOf[V](tree: Tree[V]): Boolean = tree match {
    case t: Node[V] => left.isMirrorOf(t.right) && right.isMirrorOf(t.left)
    case _ => false
  }

  def isSymmetric: Boolean = left.isMirrorOf(right)
}

case object End extends Tree[Nothing] {
  override def toString = "."

  def isMirrorOf[V](tree: Tree[V]): Boolean = tree == End

  def isSymmetric: Boolean = true
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}
