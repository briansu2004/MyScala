// P100
// Combine a string list and a number list with map, flatmap or combine,

import java.time.{Duration, LocalDateTime}

object P100 {
  def combine(lstStr: List[String], lstNum: List[Int]): List[String] = {
    (lstNum zip lstStr) map {
      case (x, y) => x + y
    }
  }

  def main(args: Array[String]): Unit = {
    val listStr = List("China", "US", "Canada", "Russia")
    val listNum = List(1, 2, 3, 4)

//    //List(1, 2, 3, 4, China, US, Canada, Russia)
//    println(listNum ::: listStr)
//
//    //List(1China, 2US, 3Canada, 4Russia)
//    println((listNum zip listStr) map {
//      case (x, y) => x + y
//    })

    var start = LocalDateTime.now()
    println(s"After combining the string list $listStr and the number list $listNum: \n${combine(listStr, listNum)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
  }
}
