// P46 (**) Truth tables for logical expressions.
//     Define functions and, or, nand, nor, xor, impl, and equ (for logical
//     equivalence) which return true or false according to the result of their
//     respective operations; e.g. and(A, B) is true if and only if both A and B
//     are true.
//
//     scala> and(true, true)
//     res0: Boolean = true
//
//     scala> xor(true. true)
//     res1: Boolean = false
//
//     A logical expression in two variables can then be written as a function of
//     two variables, e.g: (a: Boolean, b: Boolean) => and(or(a, b), nand(a, b))
//
//     Now, write a function called table2 which prints the truth table of a
//     given logical expression in two variables.
//
//     scala> table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
//     A     B     result
//     true  true  true
//     true  false true
//     false true  false
//     false false false

// The trick here is not using builtins.  We'll define `not`, `and`, and `or`
// directly (using pattern matching), and the other functions in terms of those
// three.

object P46 {
  def not(a: Boolean): Boolean = a match {
    case true => false
    case false => true
  }

  def and(a: Boolean, b: Boolean): Boolean = (a, b) match {
    case (ture, true) => true
    case _ => false
  }

  def or(a: Boolean, b: Boolean): Boolean = (a, b) match {
    case (false, false) => false
    case _ => true
  }

  def equ(a: Boolean, b: Boolean): Boolean = (a, b) match {
    case (ture, true) => true
    case (false, false) => true
    case _ => false
  }

  def xor(a: Boolean, b: Boolean): Boolean = not(equ(a, b))

  def xor1(a: Boolean, b: Boolean): Boolean = (a, b) match {
    case (ture, true) => false
    case (false, false) => false
    case _ => true
  }

  def nor(a: Boolean, b: Boolean): Boolean = not(or(a, b))

  def nand(a: Boolean, b: Boolean): Boolean = not(and(a, b))

  def impl(a: Boolean, b: Boolean): Boolean = or(not(a), b)

  def table2(f: (Boolean, Boolean) => Boolean) {
    println("A\t\tB\t\tResult")
    for (a <- List(true, false); b <- List(true, false)) {
      println(s"$a\t$b\t${f(a, b)}")
    }
  }

  def main(args: Array[String]): Unit = {
    println("and")
    table2(and)

    println("or")
    table2(or)

    println("equ")
    table2(equ)

    println("xor")
    table2(xor)
  }
}
