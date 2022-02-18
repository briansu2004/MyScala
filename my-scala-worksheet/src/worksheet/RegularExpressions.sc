import scala.util.matching.Regex

object Demo {
  def main(args: Array[String]) {
    val pattern = "Scala".r
    val str = "Scala is Scalable and cool"

    println(pattern findFirstIn str)
  }
}
Demo.main(Array(""))

object Demo {
  def main(args: Array[String]) {
    val pattern = new Regex("(S|s)cala")
    val str = "Scala is scalable and cool"

    println((pattern findAllIn str).mkString(","))
  }
}
Demo.main(Array(""))

object Demo {
  def main(args: Array[String]) {
    val pattern = "(S|s)cala".r
    val str = "Scala is scalable and cool"

    println(pattern replaceFirstIn(str, "Java"))
  }
}
Demo.main(Array(""))

object Demo {
  def main(args: Array[String]) {
    val pattern = new Regex("abl[ae]\\d+")
    val str = "ablaw is able1 and cool"

    println((pattern findAllIn str).mkString(","))
  }
}
Demo.main(Array(""))




