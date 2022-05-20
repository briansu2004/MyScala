val chars = Array.fill(6){'#'}
chars.foreach(x => println(x))


var sc: Array[Char] = Array.ofDim[Char](256)
sc.foreach(x => println(x))



var sc: Array[Char] = Array[Char]('#')
sc.foreach(x => println(x))


val chars = Array[Char](256)
chars.foreach(x => println(x))

List(3,7,5,2).sorted

List(3,7,5,2).sortWith(_ < _)

val arr: Array[Int] = new Array[Int](10)
arr

val arr = Array(1,2,3,4)
val arr2 = arr.clone()
arr2
arr(0) = 5
arr
arr2
arr2(3) = 6
arr
arr2



var myList = Array(1.9, 2.9, 3.4, 3.5)

// Print all the array elements
for ( x <- myList ) {
  println( x )
}

// Summing all elements
var total = 0.0;
for ( i <- 0 to (myList.length - 1)) {
  total += myList(i);
}
println("Total is " + total);

// Finding the largest element
var max = myList(0);
for ( i <- 1 to (myList.length - 1) ) {
  if (myList(i) > max) max = myList(i);
}
println("Max is " + max);

import Array._

var myMatrix = ofDim[Int](3,3)

// build a matrix
for (i <- 0 to 2) {
  for ( j <- 0 to 2) {
    myMatrix(i)(j) = j;
  }
}

// Print two dimensional array
for (i <- 0 to 2) {
  for ( j <- 0 to 2) {
    print(" " + myMatrix(i)(j));
  }
  println();
}