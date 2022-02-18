object Demo {
  def main(args: Array[String]) {
    val it = Iterator("a", "number", "of", "words")

    while (it.hasNext){
      println(it.next())
    }
  }
}
Demo.main(Array(""))

object Demo {
  def main(args: Array[String]) {
    val ita = Iterator(20,40,2,50,69, 90)
    val itb = Iterator(20,40,2,50,69, 90)

    println("Maximum valued element " + ita.max )
    println("Minimum valued element " + itb.min )
  }
}
Demo.main(Array(""))

object Demo {
  def main(args: Array[String]) {
    val ita = Iterator(20,40,2,50,69, 90)
    val itb = Iterator(20,40,2,50,69, 90)

    println("Value of ita.size : " + ita.size )
    println("Value of itb.length : " + itb.length )
  }
}
Demo.main(Array(""))
