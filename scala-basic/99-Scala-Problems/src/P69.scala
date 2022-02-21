// P69 (**) Dotstring representation of binary trees.
//     We consider again binary trees with nodes that are identified by single
//     lower-case letters, as in the example of problem P67.  Such a tree can be
//     represented by the preorder sequence of its nodes in which dots (.) are
//     inserted where an empty subtree (End) is encountered during the tree
//     traversal.  For example, the tree shown in problem P67 is represented as
//     "abd..e..c.fg...".  First, try to establish a syntax (BNF or syntax
//     diagrams) and then write two methods, toDotstring and fromDotstring,
//     which do the conversion in both directions.
//
//     scala> Tree.string2Tree("a(b(d,e),c(,f(g,)))").toDotstring
//     res0: String = abd..e..c.fg...
//
//     scala> Tree.fromDotstring("abd..e..c.fg...")
//     res1: Node[Char] = a(b(d,e),c(,f(g,)))

import binarytree69._

object P69 {
  def main(args: Array[String]): Unit = {
    var str = "a(b(d,e),c(,f(g,)))"
    println(s"toDotstring for the binary tree $str is: ${Tree.string2Tree(str).toDotstring}")

    var dotString = "abd..e..c.fg..."
    println(s"The binary tree generated from dotString $dotString is: ${Tree.fromDotstring(dotString)}")
  }
}
