object join extends App {
  val a: List[(String, Int, Int)] = List(("apple", 3, 25), ("orange", 4, 47), ("watermelon", 1, 2))
  val b: List[(String, String)] = List(("mango", "25"), ("orange", "50"), ("watermelon", "99"))

  a.flatMap { case (ka, va, vva) => b.toMap.get(ka).map(vb => (ka, va, vva, vb)) }.foreach(t => println(t))
  //(orange,4,47,50)
  //(watermelon,1,2,99)
}
