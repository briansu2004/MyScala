package binarytree69

sealed abstract class Tree[+T] {
  def toDotstring: String

  def isMirrorOf[V](tree: Tree[V]): Boolean

  def isSymmetric: Boolean

  def addValue[U >: T <% Ordered[U]](x: U): Tree[U]

  def nodeCount: Int

  def leafCount: Int

  def leafList: List[T]

  def internalNodesCount: Int

  def internalList: List[T]

  def atLevel(level: Int): List[T]

  def preorder: List[T]

  def inorder: List[T]

  def postorder: List[T]
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  def toDotstring: String = value.toString + left.toDotstring + right.toDotstring

  def toString1: String = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"

  override def toString = (left, right) match {
    case (End, End) => value.toString
    case _ => value.toString + "(" + left + "," + right + ")"
  }

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

  def preorder: List[T] = value :: left.preorder ::: right.preorder

  def inorder: List[T] = left.inorder ::: value :: right.inorder

  def postorder: List[T] = left.postorder ::: right.postorder ::: List(value)
}

case object End extends Tree[Nothing] {
  def toDotstring: String = "."

  def toString1 = "."

  override def toString = ""

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

  def preorder = Nil

  def inorder = Nil

  def postorder = Nil
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}

object Tree {
  def fromDotstring(ds: String): Tree[Char] = {
    def fromDotstringR(pos: Int): (Tree[Char], Int) = ds(pos) match {
      case '.' => (End, pos + 1)
      case c => {
        val (lTree, lPos) = fromDotstringR(pos + 1)
        val (rTree, rPos) = fromDotstringR(lPos)
        (Node(c, lTree, rTree), rPos)
      }
    }

    fromDotstringR(0)._1
  }

  def string2Tree(s: String): Tree[Char] = {
    def extractTreeString(s: String, start: Int, end: Char): (String, Int) = {
      def updateNesting(nesting: Int, pos: Int): Int = s(pos) match {
        case '(' => nesting + 1
        case ')' => nesting - 1
        case _ => nesting
      }

      def findStringEnd(pos: Int, nesting: Int): Int =
        if (s(pos) == end && nesting == 0) pos
        else findStringEnd(pos + 1, updateNesting(nesting, pos))

      val strEnd = findStringEnd(start, 0)
      (s.substring(start, strEnd), strEnd)
    }

    s.length match {
      case 0 => End
      case 1 => Node(s(0))
      case _ => {
        val (leftStr, commaPos) = extractTreeString(s, 2, ',')
        val (rightStr, _) = extractTreeString(s, commaPos + 1, ')')
        Node(s(0), string2Tree(leftStr), string2Tree(rightStr))
      }
    }
  }

  def fromString(s: String): Tree[Char] = string2Tree(s)

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

  def preInTree[T](pre: List[T], in: List[T]): Tree[T] = pre match {
    case Nil => End
    case v :: preTail => {
      val (leftIn, rightIn) = in.span(_ != v)
      Node(v, preInTree(preTail.take(leftIn.length), leftIn),
        preInTree(preTail.drop(leftIn.length), rightIn))
    }
  }
}