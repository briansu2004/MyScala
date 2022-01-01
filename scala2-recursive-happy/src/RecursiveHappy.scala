object RecursiveHappy {
  def happy(): Unit = {
    println("I am happy");
    happy();
  }

  def main(args:Array[String]): Unit = {
    happy();
  }
}