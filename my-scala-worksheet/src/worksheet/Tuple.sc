object Demo {
  def main(args: Array[String]) {
    val t = (4, 3, 2, 1)
    val sum = t._1 + t._2 + t._3 + t._4

    println("Sum of elements: " + sum)
  }
}
Demo.main(Array(""))

object Demo {
  def main(args: Array[String]) {
    val t = (4, 3, 2, 1)
    t.productIterator.foreach { i => println("Value = " + i) }
  }
}
Demo.main(Array(""))

object Demo {
  def main(args: Array[String]) {
    val t = new Tuple3(1, "hello", Console)
    println("Concatenated String: " + t.toString())
  }
}
Demo.main(Array(""))

object Demo {
  def main(args: Array[String]) {
    val t = new Tuple2("Scala", "hello")
    println("Swapped Tuple: " + t.swap)
  }
}
Demo.main(Array(""))




