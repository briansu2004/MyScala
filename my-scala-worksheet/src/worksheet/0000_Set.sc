Set(3, 7, 10) + 1

// Empty set of integer type
var s1 : Set[Int] = Set()
// Set of integer type
var s2 : Set[Int] = Set(1,3,5,7)
var s3 = Set(-9,87,6,-4,0)

val fruit = Set("apples", "oranges", "pears")
val nums: Set[Int] = Set()
println( "Head of fruit : " + fruit.head )
println( "Tail of fruit : " + fruit.tail )
println( "Check if fruit is empty : " + fruit.isEmpty )
println( "Check if nums is empty : " + nums.isEmpty )

/* ++ or Set.++() */
val fruit1 = Set("apples", "oranges", "pears")
val fruit2 = Set("mangoes", "banana")
// use two or more sets with ++ as operator
var fruit = fruit1 ++ fruit2
println( "fruit1 ++ fruit2 : " + fruit )
// use two sets with ++ as method
fruit = fruit1.++(fruit2)
println( "fruit1.++(fruit2) : " + fruit )

/* def ++(elems: A): Set[A] */
/* def +(elem1: A, elem2: A, elems: A*): Set[A] */
fruit.+("strawberry")
fruit.+("watermelon", "blueberry")
fruit.-("banana")
fruit.+("mangoes", "apples")

val num = Set(5,6,9,20,30,45)
// find min and max of the elements
println( "Min element in Set(5,6,9,20,30,45) : " + num.min )
println( "Max element in Set(5,6,9,20,30,45) : " + num.max )

/* Set.& or Set.intersect */
val num1 = Set(5,6,9,20,30,45)
val num2 = Set(50,60,9,20,35,55)
// find common elements between two sets
println( "num1.&(num2) : " + num1.&(num2) ) // HashSet(20, 9)
println( "num1.intersect(num2) : " + num1.intersect(num2) )
/* def &~(that: Set[A]): Set[A]
Returns the difference of this set and another set. */
num1.&~(num2)   // HashSet(5, 6, 45, 30)
num2.&~(num1)   // HashSet(60, 35, 50, 55)

val num = Set(-6,1,0,-7,-10,5,6,9,20,30,45)
num.take(1)
num.takeRight(3)
num.drop(2)
num.dropRight(4)
num.size  // no length
num.min
num.max
num.sum
num.product
num.mkString(" ")


/* dropWhile??? */
num.dropWhile(x => {x > 0})
num.dropWhile(x => {x % 2 == 0})