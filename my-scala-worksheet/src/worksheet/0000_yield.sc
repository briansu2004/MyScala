val a:String = "ABC"
val x = (for (i <- 0 until a.length) yield {
  a.charAt(i)
})
x.mkString("")

