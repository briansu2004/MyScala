package multiwaytree71

case class MTree[+T](value: T, children: List[MTree[T]]) {
  def this(value: T) = this(value, List())

  def toString1 = "M(" + value.toString + " {" + children.map(_.toString).mkString(",") + "})"

  override def toString = value.toString + children.map(_.toString + "^").mkString("")

  def nodeCount: Int = children.foldLeft(1)(_ + _.nodeCount)

  def internalPathLength: Int =
    children.foldLeft(0)((r, c) => r + c.nodeCount + c.internalPathLength)

//  def externalPathLength: Int =
//    children.foldLeft(0)((r, c) => r + c.nodeCount + c.externalPathLength)
}

object MTree {
  def apply[T](value: T) = new MTree(value, List())

  def apply[T](value: T, children: List[MTree[T]]) = new MTree(value, children)

  implicit def string2MTree(s: String): MTree[Char] = {
    def nextStrBound(pos: Int, nesting: Int): Int =
      if (nesting == 0) pos
      else nextStrBound(pos + 1, if (s(pos) == '^') nesting - 1 else nesting + 1)
    def splitChildStrings(pos: Int): List[String] =
      if (pos >= s.length) Nil
      else {
        val end = nextStrBound(pos + 1, 1)
        s.substring(pos, end - 1) :: splitChildStrings(end)
      }
    MTree(s(0), splitChildStrings(1).map(string2MTree(_)))
  }
}
