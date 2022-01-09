// P73 (**) Lisp-like tree representation.
//     There is a particular notation for multiway trees in Lisp.  Lisp is a
//     prominent functional programming language.  In Lisp almost everything is
//     a list.
//
//     Our example tree would be represented in Lisp as (a (f g) c (b d e)).
//
//     Note that in the "lispy" notation a node with successors (children)in the
//     tree is always the first element in a list, followed by its children.
//     The "lispy" representation of a multiway tree is a sequence of atoms and
//     parentheses '(' and ')', with the atoms separated by spaces.  We can
//     represent this syntax as a Scala String.  Write a method lispyTree which
//     constructs a "lispy string" from an MTree.
//
//     scala> MTree("a", List(MTree("b", List(MTree("c"))))).lispyTree
//     res0: String = (a (b c))
//
//     As a second, even more interesting, exercise try to write a method that
//     takes a "lispy" list and turns it into a multiway tree.

import multiwaytree73._

object P73 {
  def main(args: Array[String]): Unit = {
    var str = "(a (b c))"
    println(s"The multiway tree from lispy string $str is: ${MTree.fromLispyString(str)}")

    str = " (a (f g) c (b d e))"
    println(s"The multiway tree from lispy string $str is: ${MTree.fromLispyString(str)}")

    var mt = MTree("a", List(MTree("b", List(MTree("c")))))
    println(s"The lispy string of multiway tree $mt is: ${mt.lispyTree}")
  }
}
