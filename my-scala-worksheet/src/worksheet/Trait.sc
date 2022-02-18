trait Equal {
  def isEqual(x: Any): Boolean
  def isNotEqual(x: Any): Boolean = !isEqual(x)
}

class Point(xc: Int, yc: Int) extends Equal {
  var x: Int = xc
  var y: Int = yc

  def isEqual(obj: Any) = obj.isInstanceOf[Point] && obj.asInstanceOf[Point].x == y
}

object Demo {
  def main(args: Array[String]) {
    val p1 = new Point(2, 3)
    val p2 = new Point(2, 4)
    val p3 = new Point(3, 3)

    println(p1.isNotEqual(p2))
    println(p1.isNotEqual(p3))
    println(p1.isNotEqual(2))
  }
}
Demo.main(Array(""))

trait Printable extends Any {
  def print(): Unit = println(this)
}
class Wrapper(val underlying: Int) extends AnyVal with Printable

object Demo1 {
  def main(args: Array[String]) {
    val w = new Wrapper(3)
    w.print() // actually requires instantiating a Wrapper instance
  }
}
Demo1.main(Array(""))



