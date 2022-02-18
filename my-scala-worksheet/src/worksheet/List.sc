// List of Strings
val fruit: List[String] = List("apples", "oranges", "pears")

// List of Integers
val nums: List[Int] = List(1, 2, 3, 4)

// Empty List.
val empty: List[Nothing] = List()

// Two dimensional list
val dim: List[List[Int]] =
  List(
    List(1, 0, 0),
    List(0, 1, 0),
    List(0, 0, 1)
  )

// List of Strings
val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))

// List of Integers
val nums = 1 :: (2 :: (3 :: (4 :: Nil)))

// Empty List.
val empty = Nil

// Two dimensional list
val dim = (1 :: (0 :: (0 :: Nil))) ::
  (0 :: (1 :: (0 :: Nil))) ::
  (0 :: (0 :: (1 :: Nil))) :: Nil

object Demo {
  def main(args: Array[String]) {
    val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
    val nums = Nil

    println( "Head of fruit : " + fruit.head )
    println( "Tail of fruit : " + fruit.tail )
    println( "Check if fruit is empty : " + fruit.isEmpty )
    println( "Check if nums is empty : " + nums.isEmpty )
  }
}
Demo.main(Array(""))

object Demo {
  def main(args: Array[String]) {
    val fruit1 = "apples" :: ("oranges" :: ("pears" :: Nil))
    val fruit2 = "mangoes" :: ("banana" :: Nil)

    // use two or more lists with ::: operator
    var fruit = fruit1 ::: fruit2
    println( "fruit1 ::: fruit2 : " + fruit )

    // use two lists with Set.:::() method
    fruit = fruit1.:::(fruit2)
    println( "fruit1.:::(fruit2) : " + fruit )

    // pass two or more lists as arguments
    fruit = List.concat(fruit1, fruit2)
    println( "List.concat(fruit1, fruit2) : " + fruit  )
  }
}
Demo.main(Array(""))

object Demo {
  def main(args: Array[String]) {
    val fruit = List.fill(3)("apples") // Repeats apples three times.
    println( "fruit : " + fruit  )

    val num = List.fill(10)(2)         // Repeats 2, 10 times.
    println( "num : " + num  )
  }
}
Demo.main(Array(""))

object Demo {
  def main(args: Array[String]) {
    // Creates 5 elements using the given function.
    val squares = List.tabulate(6)(n => n * n)
    println( "squares : " + squares  )

    val mul = List.tabulate( 4,5 )( _ * _ )
    println( "mul : " + mul  )
  }
}
Demo.main(Array(""))

object Demo {
  def main(args: Array[String]) {
    val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))

    println( "Before reverse fruit : " + fruit )
    println( "After reverse fruit : " + fruit.reverse )
  }
}
Demo.main(Array(""))