1 & 2


val s1 = "10101"
val s2 = "11100"
//s1 | s2
//var s = s1
// value update is not a member of String
//for (i <- 0 until s1.length) {
//  s(i) = s1(i) | s2(i)
//}
var s = s1.toCharArray
for (i <- s1.indices) {
  println(s"${s1(i)} | ${s2(i)}")
  s(i) = (s1(i) | s2(i)).toChar
}
s.mkString("")


("10".toInt | "11".toInt).toString

"10101".toInt
"11100".toInt
("10101".toInt | "11100".toInt).toString

var a = 60;           /* 60 = 0011 1100 */
var b = 13;           /* 13 = 0000 1101 */
var c = 0;

c = a & b;            /* 12 = 0000 1100 */
println("a & b = " + c );

c = a | b;            /* 61 = 0011 1101 */
println("a | b = " + c );

c = a ^ b;            /* 49 = 0011 0001 */
println("a ^ b = " + c );

c = ~a;               /* -61 = 1100 0011 */
println("~a = " + c );

c = a << 2;           /* 240 = 1111 0000 */
println("a << 2 = " + c );

c = a >> 2;           /* 215 = 1111 */
println("a >> 2  = " + c );

c = a >>> 2;          /* 215 = 0000 1111 */
