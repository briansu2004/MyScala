Array(1,2,3,2,1).indexOf(2)

Array(4, 3, 5, 1, 2).indexOf(1)
Array(4, 3, 5, 1, 2).indexOf(2)
Array(4, 3, 5, 1, 2).indexOf(3)
Array(4, 3, 5, 1, 2).indexOf(4)
Array(4, 3, 5, 1, 2).indexOf(5)

Array(1, 2, 3, 4, 5, 6).take(2)
Array(1, 2, 3, 4, 5, 6).take(6-2)
Array(1, 2, 3, 4, 5, 6).takeRight(2)

Array(1, 2, 3, 4, 5, 6).takeRight(2).concat( Array(1, 2, 3, 4, 5, 6).take(4))

//List(1,2,3).permutations

Array("a", "b", "c").permutations

val it = Array("a", "b", "c").permutations

//it.next().getClass

while (it.hasNext){
  println(it.next().mkString(" "))
}

val xs = Array("a", "b", "c", "c", "a", "b", "c", "b", "b", "a")
//xs.groupBy(identity).mapValues(_.length).mkString(" ")
xs.groupBy(identity).view.mapValues(_.length).mkString(" ")
xs.groupBy(identity).view.mapValues(_.length).size

var cnt: Array[Int] = Array.fill[Int](5)(0)

/* clone array */
var nums1: Array[Int] = Array[Int](73, 67, 40, 33)
var nums2 = nums1.clone()
nums2(0) = 75
nums2
nums1 // update cloned map doesn't affect the original map

var myArr = Array(64630, 11735, 14216, 99233, 14470, 4978, 73429, 38120, 51135, 67060)
myArr.sortBy(_.toInt)
myArr.sortBy(BigInt(_))
myArr.sorted
myArr

myArr.sum
myArr.sum / myArr.length
BigDecimal(myArr.sum / myArr.length)
BigDecimal(myArr.sum) / myArr.length

myArr.max
var modeArr: Array[BigInt] = Array.fill(myArr.max + 1)(0)
for (i <- myArr.indices) {
  modeArr(myArr(i)) = modeArr(myArr(i)) + 1
}

val genes: Array[String] = Array[String]("a", "b", "c", "aa", "d", "b")
val first: Int = 1
val last : Int = 6
val validGenes:  Array[String] = genes.slice(first, last)

val mid = (genes.length - genes.length % 2 ) / 2
val leftArr: Array[String] = genes.slice(0, mid)
val rightArr: Array[String] = genes.slice(mid, genes.length)


val weights: Array[Int] = Array[Int](1, 3, 6)
val i = 0
val j = 2
weights.slice(i, j)
weights.slice(i, j + 1)

/* length and size are the same, but use length */
weights.length
weights.size

/* init an empty array */
val dna: Array[Array[Any]] = Array()

var z:Array[String] = new Array[String](3)
var z = new Array[String](3)
z(0) = "Zara"; z(1) = "Nuha"; z(4/2) = "Ayan"
var z = Array("Zara", "Nuha", "Ayan")

var myList = Array(1.9, 2.9, 3.4, 3.5)
for ( x <- myList ) {
  println( x )
}
myList.map{println}

var total = 0.0;
for ( i <- 0 to (myList.length - 1)) {
  total += myList(i);
}
println("Total is " + total);
myList.foldLeft(0.0)(_ + _)

// Finding the largest element
var max = myList(0);
for ( i <- 1 to (myList.length - 1) ) {
  if (myList(i) > max) max = myList(i);
}
println("Max is " + max);


/* 2D */
// Multidimensional Array by using Array of Array
// Array[Array[Int]]
var myMatrix = Array.ofDim[Int](3,5)

// build a matrix
for (i <- 0 to 2) {
  for ( j <- 0 to 4) {
    myMatrix(i)(j) = j;
  }
}

// Print two dimensional array
for (i <- 0 to 2) {
  for ( j <- 0 to 4) {
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


/* -1 */
val s = "decrease"
for (i <- s.length - 1 to 0 by -1) {
  println(s(i))
}
s(0)
s(1)



