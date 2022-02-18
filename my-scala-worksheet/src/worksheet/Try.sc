def toInt(s: String): Option[Int] = {
  try {
    Some(Integer.parseInt(s.trim))
  } catch {
    case e: Exception => None
  }
}

val strings = Seq("1", "2", "foo", "3", "bar")

strings.map(toInt)

strings.flatMap(toInt)

strings.flatMap(toInt).toList

List(Some(1), Some(2), None, Some(4), None).flatten.foreach(t => println(t))

List(List("ban", "and", "ban"), List("and", "star"), List("ban", "the")).flatten.foreach(t =>
  println(t))
