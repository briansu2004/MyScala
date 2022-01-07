
// P47 (*) Truth tables for logical expressions (2).
//     Continue problem P46 by redefining and, or, etc as operators.  (i.e. make
//     them methods of a new class with an implicit conversion from Boolean.)
//     not will have to be left as a object method.
//
//     scala> table2((a: Boolean, b: Boolean) => a and (a or not(b)))
//     A     B     result
//     true  true  true
//     true  false true
//     false true  false
//     false false false

// For simplicity, we remove `and`, `or`, `equ`, `xor`, `nor`, `nand`, and
// `impl` from the S99Logic object before putting them into a new class.

import P46._

class P47(a: Boolean) {
  import P47._

  def and(b: Boolean): Boolean = (a, b) match {
    case (true, true) => true
    case _            => false
  }
  def or(b: Boolean): Boolean = (a, b) match {
    case (true, _) => true
    case (_, true) => true
    case _         => false
  }
  def equ(b: Boolean): Boolean = (a and b) or (not(a) and not(b))
  def xor(b: Boolean): Boolean = not(a equ b)
  def nor(b: Boolean): Boolean = not(a or b)
  def nand(b: Boolean): Boolean = not(a and b)
  def impl(b: Boolean): Boolean = not(a) or b
}

object P47 {
  implicit def boolean2P47(a: Boolean): P47 = new P47(a)

  def table2(f: (Boolean, Boolean) => Boolean) {
    println("A\t\tB\t\tResult")
    for (a <- List(true, false); b <- List(true, false)) {
      println(s"$a\t$b\t${f(a, b)}")
    }
  }

  def main(args: Array[String]): Unit = {
    println("and")
    table2(and)

    println("(a: Boolean, b: Boolean) => a and (a or not(b))")
    table2((a: Boolean, b: Boolean) => a and (a or not(b)))

    //    println("or")
    //    table2(or)
    //
    //    println("equ")
    //    table2(equ)
    //
    //    println("xor")
    //    table2(xor)
    //  }
  }
}