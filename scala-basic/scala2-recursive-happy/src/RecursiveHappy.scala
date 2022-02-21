import scala.annotation.tailrec

object RecursiveHappy {
  @tailrec def happy(): Unit = {
    println("I am happy")
    happy()
  }

  def main(args:Array[String]): Unit = {
    happy()
  }
}