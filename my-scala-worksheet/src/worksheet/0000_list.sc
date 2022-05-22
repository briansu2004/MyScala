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

/* :: Nil */
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

/* Head Tail isEmpty */
val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
val nums = Nil
println( "Head of fruit : " + fruit.head )
println( "Tail of fruit : " + fruit.tail )
println( "Check if fruit is empty : " + fruit.isEmpty )
println( "Check if nums is empty : " + nums.isEmpty )

/* ::: */
val fruit1 = "apples" :: ("oranges" :: ("pears" :: Nil))
val fruit2 = "mangoes" :: ("banana" :: Nil)
// use two or more lists with ::: operator
var fruit = fruit1 ::: fruit2
println( "fruit1 ::: fruit2 : " + fruit )
// use two lists with List.:::() method
fruit = fruit1.:::(fruit2)
println( "fruit1.:::(fruit2) : " + fruit )
// pass two or more lists as arguments
fruit = List.concat(fruit1, fruit2)
println( "List.concat(fruit1, fruit2) : " + fruit  )

/* fill */
val fruit = List.fill(3)("apples") // Repeats apples three times.
println( "fruit : " + fruit  )
val num = List.fill(10)(2)         // Repeats 2, 10 times.
println( "num : " + num  )
val n = List.fill(10)(0)
val units = List.fill(10)()
// val n = List.fill(10) // syntax error

/* Reverse */
val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
println( "Before reverse fruit : " + fruit )
println( "After reverse fruit : " + fruit.reverse )

/* def mkString: String
Displays all elements of the list in a string. */
fruit.mkString(",")
fruit.min
fruit.max
fruit.size
fruit.length
fruit.startsWith("o")
fruit.indexOf("oranges")

val names1 = List("Emily", "Effie", "Brian", "Peter", "Nancy")
val names2 = List("Kayle", "Brian", "Sandeep", "Effie")
names1.intersect(names2)

/* def startsWith[B](that: Seq[B], offset: Int): Boolean
Tests whether the list contains the given sequence at a given index. */
//val names = List("Emily", "Effie", "East")
//names.startsWith(Seq("Effie"), 0)

val m1 = List(4, 38, 5, -3, 0, 7, -6, -6, 4, 38)
val result = m1.sum
m1.sorted
m1.reverse
m1.take(2)
m1.takeRight(4)
m1.foreach(x => print(s"$x "))
m1.mkString(" ")
m1.contains(3)
m1.contains(-3)
m1.distinct
m1.drop(1)
m1.dropRight(2)
m1.last
/* def init: List[A]
Returns all elements except the last. */
m1.init
m1.lastIndexOf(-6)
m1.lastIndexOf(-6, 6)

/* dropWhile
it doesn't work like filter
it stops when it finds the first unsatisfied element! */
val m1 = scala.collection.immutable.List(4, 38, 5, -3, 0, 7, -6, -6, 4, 38)
m1.dropWhile(x => {x < 0})
m1.filter(x => {x >= 0})
m1.dropWhile(x=>{x % 2 != 0})
val m = List(1, 3, 5, 4, 2, 8, 9, 7, 10)
m.dropWhile(x=>{x % 2 != 0})
m.dropWhile(x=>{x < 5})
m.dropWhile(x=>{x > 0})
val myList = List(4, 38, 5, -3, 0, 7, -6, -6, 4, 38)
myList.dropWhile(x => {x < 6})
val myList1 = List(4, 38, 5, 4, 38)
myList1.dropWhile(x => {x < 6})
myList1.dropWhile(x => {x - 6 < 0})
val lst = List(4, 38, 5, 7, 9)
lst.dropWhile(x => {x < 6})
lst.dropWhile(x => {x % 2 != 0})
