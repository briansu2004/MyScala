package binarytree64

sealed abstract class Tree[+T] {
  def isMirrorOf[V](tree: Tree[V]): Boolean

  def isSymmetric: Boolean

  def addValue[U >: T <% Ordered[U]](x: U): Tree[U]

  def nodeCount: Int

  def leafCount: Int

  def leafList: List[T]

  def internalNodesCount: Int

  def internalList: List[T]

  def atLevel(level: Int): List[T]

  def layoutBinaryTree: Tree[T] = layoutBinaryTreeInternal(1, 1)._1

  def layoutBinaryTreeInternal(x: Int, depth: Int): (Tree[T], Int)
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

  def nodeCount: Int = left.nodeCount + right.nodeCount + 1

  def leafCount: Int = (left, right) match {
    case (End, End) => 1
    case _ => left.leafCount + right.leafCount
  }

  def leafList: List[T] = (left, right) match {
    case (End, End) => List(value)
    case _ => left.leafList ::: right.leafList
  }

  def internalNodesCount: Int = (left, right) match {
    case (End, End) => 0
    case _ => left.internalNodesCount + right.internalNodesCount + 1
  }

  def internalList: List[T] = (left, right) match {
    case (End, End) => Nil
    case _ => value :: left.internalList ::: right.internalList
  }

  def atLevel(level: Int): List[T] = level match {
    case n if n < 1 => Nil
    case 1 => List(value)
    case n => left.atLevel(n - 1) ::: right.atLevel(n - 1)
  }

  def layoutBinaryTreeInternal(x: Int, depth: Int): (Tree[T], Int) = {
    val (leftTree, myX) = left.layoutBinaryTreeInternal(x, depth + 1)
    val (rightTree, nextX) = right.layoutBinaryTreeInternal(myX + 1, depth + 1)

    (Node(value, leftTree, rightTree), nextX)
    //(PositionedNode(value, leftTree, rightTree, myX, depth), nextX)
  }
}

//case class PositionedNode[+T](override val value: T, override val left: Tree[T], override val right: Tree[T], x: Int, y: Int) extends Node[T](value, left, right) {
//  override def toString = "T[" + x.toString + "," + y.toString + "](" + value.toString + " " + left.toString + " " + right.toString + ")"
//}

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

  def nodeCount: Int = 0

  def leafCount: Int = 0

  def leafList = Nil

  def internalNodesCount: Int = 0

  def internalList = Nil

  def atLevel(level: Int) = Nil

  def layoutBinaryTreeInternal(x: Int, depth: Int) = (End, x)
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}

object Tree {
  def cBalanced[T](nodes: Int, value: T): List[Tree[T]] = nodes match {
    case n if n < 1 => List(End)
    case n if n % 2 == 1 => {
      val subtrees = cBalanced(n / 2, value)
      subtrees.flatMap(l => subtrees.map(r => Node(value, l, r)))
    }
    case n if n % 2 == 0 => {
      val lesserSubtrees = cBalanced((n - 1) / 2, value)
      val greaterSubtrees = cBalanced((n - 1) / 2 + 1, value)
      lesserSubtrees.flatMap(l => greaterSubtrees.flatMap(g => List(Node(value, l, g), Node(value, g, l))))
    }
  }

  def fromList[T <% Ordered[T]](l: List[T]): Tree[T] =
    l.foldLeft(End: Tree[T])((r, e) => r.addValue(e))

  def symmetricBalancedTrees[T](nodes: Int, value: T): List[Tree[T]] =
    cBalanced(nodes, value).filter(_.isSymmetric)

  def hbalTrees[T](height: Int, value: T): List[Tree[T]] = height match {
    case n if n < 1 => List(End)
    case 1 => List(Node(value))
    case _ => {
      val fullHeight = hbalTrees(height - 1, value)
      val short = hbalTrees(height - 2, value)
      fullHeight.flatMap((l) => fullHeight.map((r) => Node(value, l, r))) :::
        fullHeight.flatMap((f) => short.flatMap((s) => List(Node(value, f, s), Node(value, s, f))))
    }
  }

  def minHbalNodes(height: Int): Int = height match {
    case n if n < 1 => 0
    case 1 => 1
    case n => minHbalNodes(n - 1) + minHbalNodes(n - 2) + 1
  }

  def maxHbalNodes(height: Int): Int = Math.pow(2, height).toInt - 1

  def minHbalHeight(nodes: Int): Int =
    if (nodes == 0) 0
    else minHbalHeight(nodes / 2) + 1

  def maxHbalHeight(nodes: Int): Int =
    Stream.from(1).takeWhile(minHbalNodes(_) <= nodes).last

  def hbalTreesWithNodes[T](nodes: Int, value: T): List[Tree[T]] =
    (minHbalHeight(nodes) to maxHbalHeight(nodes)).flatMap(hbalTrees(_, value)).filter(_.nodeCount == nodes).toList

  def completeBinaryTree[T](nodes: Int, value: T): Tree[T] = {
    def generateTree(addr: Int): Tree[T] =
      if (addr > nodes) End
      else Node(value, generateTree(2 * addr), generateTree(2 * addr + 1))

    generateTree(1)
  }
}