val weights: Array[Int] = Array[Int](1, 3, 6)
val i = 0
val j = 2
weights.slice(i, j)
weights.slice(i, j + 1)

var z:Array[String] = new Array[String](3)
var z = new Array[String](3)
z(0) = "Zara"; z(1) = "Nuha"; z(4/2) = "Ayan"
var z = Array("Zara", "Nuha", "Ayan")

var myList = Array(1.9, 2.9, 3.4, 3.5)
for ( x <- myList ) {
  println( x )
}

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

var myMatrix = Array.ofDim[Int](3,3)

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

var myList1 = Array(1.9, 2.9, 3.4, 3.5)
var myList2 = Array(8.9, 7.9, 0.4, 1.5)
var myList3 = Array.concat( myList1, myList2)
for ( x <- myList3 ) {
  println( x )
}

/* fill */
Array.fill(3)()
Array.fill(5)(1)
Array.fill(4,3)("")
val arr = Array.fill[Byte](5)(0)
