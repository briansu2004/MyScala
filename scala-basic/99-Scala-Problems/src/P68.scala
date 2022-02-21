// P68 (**) Preorder and inorder sequences of binary trees.
//     We consider binary trees with nodes that are identified by single
//     lower-case letters, as in the example of problem P67.
//
//     a) Write methods preorder and inorder that construct the preorder and
//        inorder sequence of a given binary tree, respectively.  The results
//        should be lists, e.g. List('a','b','d','e','c','f','g') for the
//        preorder sequence of the example in problem P67.
//
//     scala> Tree.string2Tree("a(b(d,e),c(,f(g,)))").preorder
//     res0: List[Char] = List(a, b, d, e, c, f, g)
//
//     scala> Tree.string2Tree("a(b(d,e),c(,f(g,)))").inorder
//     res1: List[Char] = List(d, b, e, a, c, g, f)
//
//     b) If both the preorder sequence and the inorder sequence of the nodes of
//        a binary tree are given, then the tree is determined unambiguously.
//        Write a method preInTree that does the job.
//
//     scala> Tree.preInTree(List('a', 'b', 'd', 'e', 'c', 'f', 'g'), List('d', 'b', 'e', 'a', 'c', 'g', 'f'))
//     res2: Node[Char] = a(b(d,e),c(,f(g,)))
//
//     What happens if the same character appears in more than one node?  Try,
//     for instance, Tree.preInTree(List('a', 'b', 'a'), List('b', 'a', 'a')).

import binarytree68._

object P68 {
  def main(args: Array[String]): Unit = {
    var str = "1(2(4,5),3)"
    println(s"The preorder of binary tree $str is: ${Tree.string2Tree(str).preorder}")
    println(s"The inorder of binary tree $str is: ${Tree.string2Tree(str).inorder}")
    println(s"The postorder of binary tree $str is: ${Tree.string2Tree(str).postorder}")

    str = "1(2(4,5),3(6,7))"
    println(s"The preorder of binary tree $str is: ${Tree.string2Tree(str).preorder}")
    println(s"The inorder of binary tree $str is: ${Tree.string2Tree(str).inorder}")
    println(s"The postorder of binary tree $str is: ${Tree.string2Tree(str).postorder}")

    str = "a(b(d,e),c(,f(g,)))"
    println(s"The preorder of binary tree $str is: ${Tree.string2Tree(str).preorder}")
    println(s"The inorder of binary tree $str is: ${Tree.string2Tree(str).inorder}")
    println(s"The postorder of binary tree $str is: ${Tree.string2Tree(str).postorder}")

    var ls1 = List('a', 'b', 'd', 'e', 'c', 'f', 'g')
    var ls2 = List('d', 'b', 'e', 'a', 'c', 'g', 'f')
    println(s"The preInTree of list $ls1 and list $ls2 is:\n ${Tree.preInTree(ls1, ls2)}")

  }
}
