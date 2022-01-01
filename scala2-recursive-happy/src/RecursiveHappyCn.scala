import scala.annotation.tailrec

object RecursiveHappyCn {
  @tailrec def 我高兴(): Unit = {
    println("我高兴")
    我高兴()
  }

  def main(args:Array[String]): Unit = {
    我高兴()
  }
}