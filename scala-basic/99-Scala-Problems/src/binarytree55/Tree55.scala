package binarytree55

sealed abstract class Tree[+T]

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  // i.e. T(x . T(x . .))
  override def toString: String = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"

  // i.e.
  // ==>
  //    x
  // .__|_____x
  //    |__.__|__.
  //override def toString = "T(" + value.toString + " " + left.toString + "__|__" + right.toString + ")"

  //     x
  //    /\
  //   .  x
  //     /\
  //    .  .
}

case object End extends Tree[Nothing] {
  override def toString = "."
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)

  //    // Function to print binary tree in 2D// Function to print binary tree in 2D
  //    // It does reverse inorder traversal
  //    def print2DUtil[T](root: Node[T], s: Int): Unit = {
  //      val COUNT = 10
  //
  //      // Base case
  //      if (root == null) {
  //        return
  //      }
  //
  //      // Increase distance between levels
  //      var space = s + COUNT
  //
  //      // Process right child first
  //      print2DUtil(root.right, space)
  //
  //      // Print current node after space count
  //      println("\n")
  //
  //      for (i <- COUNT until space) {
  //        println(" ")
  //      }
  //
  //      println(root.value + "\n")
  //      // Process left child
  //      print2DUtil(root.left, space)
  //    }
  //
  //    // Wrapper over print2DUtil()
  //    def print2D[T](root: Node[T]): Unit = {
  //      // Pass initial space count as 0
  //      print2DUtil(root, 0)
  //    }
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
}
