/*
Scala Lists are quite similar to arrays which means,
all the elements of a list have the same type but there are two important differences.
First, lists are immutable, which means elements of a list cannot be changed by assignment.
Second, lists represent a linked list whereas arrays are flat.

should be easy to add a new element
But mutable Queue is even better (however, queue is implemented with the linked list)
 */



List(1,2,3,2,1).indexOf(2)
List(1,2,3,2,1).indexOf(5)
List(1,2,3,2,1).lastIndexOf(2)
List(1,2,3,4,5,6).indexWhere(element => element > 3)
List(1,2,3,4,5,6).lastIndexWhere(element => element > 3)
List(1,2,3,2,1).zipWithIndex.filter(pair => pair._1 == 2).map(pair => pair._2)

import scala.collection.mutable.ListBuffer

List("1", "5", "caaab")(0) // 1
List("1", "5", "caaab")(2) // caaab
// List("1", "5", "caaab")(3) // java.lang.IndexOutOfBoundsException
List("1", "5", "caaab").tail // List(5, caaab)
List("1", "5", "caaab").tails // <iterator>
List("1", "5", "caaab").head // 1

// List of Strings
var fruit: List[String] = List("apples", "oranges", "pears")
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
var dna: List[List[Any]] = List()

/* add a new element to a list */
var fruits = new ListBuffer[String]()
fruits += "pipeapple"
fruits += "blueberry"
val fruitsList = fruits.toList

/* length and size are the same, but use length */
fruit.length
fruit.size

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

/* toArray */
fruit
fruit.toArray

val dna: List[List[String]] = List(List("1", "5", "caaab"), List("0", "4", "xyz"), List("2", "4", "bcdybc"))
dna.toArray // Array(List(1, 5, caaab), List(0, 4, xyz), List(2, 4, bcdybc))
dna.map(_.toArray).toArray // Array(Array(1, 5, caaab), Array(0, 4, xyz), Array(2, 4, bcdybc))

List("1", "5", "caaab") ::: List("0", "4", "xyz") // List(1, 5, caaab, 0, 4, xyz)
List(List("1", "5", "caaab")) ::: List(List("0", "4", "xyz")) // List(List(1, 5, caaab), List(0, 4, xyz))

/* mkString 2D array/List */
println(s"dna: ${dna.map(_.mkString(" ")).mkString("\n")}")
dna.map(_.mkString(" ")).mkString("\n")


//val floatList = "10 9.8 8 7.8 7.7 7 6 5 4 2 ".strip().split(" ").toList.map(x => x.toFloat)
//floatList.sum
//floatList.foldLeft(0.0)(_ + _)

