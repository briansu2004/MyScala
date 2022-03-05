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