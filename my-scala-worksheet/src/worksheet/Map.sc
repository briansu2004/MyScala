object Demo {
  def main(args: Array[String]) {
    val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")

    val nums: Map[Int, Int] = Map()

    println( "Keys in colors : " + colors.keys )
    println( "Values in colors : " + colors.values )
    println( "Check if colors is empty : " + colors.isEmpty )
    println( "Check if nums is empty : " + nums.isEmpty )
  }
}
Demo.main(Array(""))

object Demo {
  def main(args: Array[String]) {
    val colors1 = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
    val colors2 = Map("blue" -> "#0033FF", "yellow" -> "#FFFF00", "red" -> "#FF0000")

    // use two or more Maps with ++ as operator
    var colors = colors1 ++ colors2
    println( "colors1 ++ colors2 : " + colors )

    // use two maps with ++ as method
    colors = colors1.++(colors2)
    println( "colors1.++(colors2)) : " + colors )
  }
}
Demo.main(Array(""))

object Demo {
  def main(args: Array[String]) {
    val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF","peru" -> "#CD853F")

    colors.keys.foreach{ i =>
      print( "Key = " + i )
      println(" Value = " + colors(i) )}
  }
}
Demo.main(Array(""))

object Demo {
  def main(args: Array[String]) {
    val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")

    if( colors.contains( "red" )) {
      println("Red key exists with value :"  + colors("red"))
    } else {
      println("Red key does not exist")
    }

    if( colors.contains( "maroon" )) {
      println("Maroon key exists with value :"  + colors("maroon"))
    } else {
      println("Maroon key does not exist")
    }
  }
}
Demo.main(Array(""))


