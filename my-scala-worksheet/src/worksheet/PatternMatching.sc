object Demo {
  def main(args: Array[String]) {
    println(matchTest(3))
  }

  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }
}
Demo.main(Array(""))

object Demo {
  def main(args: Array[String]) {
    println(matchTest("two"))
    println(matchTest("test"))
    println(matchTest(1))
  }

  def matchTest(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case y: Int => "scala.Int"
    case _ => "many"
  }
}
Demo.main(Array(""))

object Demo {
  def main(args: Array[String]) {
    val alice = new Person("Alice", 25)
    val bob = new Person("Bob", 32)
    val charlie = new Person("Charlie", 32)

    for (person <- List(alice, bob, charlie)) {
      person match {
        case Person("Alice", 25) => println("Hi Alice!")
        case Person("Bob", 32) => println("Hi Bob!")
        case Person(name, age) => println(
          "Age: " + age + " year, name: " + name + "?")
      }
    }
  }
  case class Person(name: String, age: Int)
}
Demo.main(Array(""))
