import java.io._

object Demo {
  def main(args: Array[String]) {
    val writer = new PrintWriter(new File("c:\\tmp\\test.txt" ))

    writer.write("Hello Scala")
    writer.close()
  }
}
Demo.main(Array(""))

//object Demo {
//  def main(args: Array[String]) {
//    print("Please enter your input : " )
//    val line = Console.readLine
//
//    println("Thanks, you just typed: " + line)
//  }
//}
//Demo.main(Array(""))

import scala.io.Source

object Demo {
  def main(args: Array[String]) {
    println("Following is the content read:" )

    Source.fromFile("C:\\tmp\\test\\input.csv" ).foreach {
      print
    }
  }
}
Demo.main(Array(""))