val s = "10111"
s(0)
s(0).toInt
s(0).asDigit
s(1).asDigit
s(0).asDigit | s(1).asDigit

/* slice vs substring */
var dna = "abcdefghijk"
dna.substring(0, 0)
dna.substring(0, 1)
dna.slice(0, 0)
dna.slice(0, 1)
dna.slice(2, 8)
dna.substring(2, 8)
dna.substring(1, dna.length)

val s = "abbabb"
for (i <-  1 until s.length) {
  val ns = s.slice(i, s.length)
  println(ns)
}



dna += "a"
dna

dna = dna + "z"
dna

dna.charAt(0)

val a = "ABC"
val b = "ADEF"
a < b


"c".concat("d")

var s1 = "tobe"
val s2 = "addme"
s1.concat(s2)

val s = "abcdefg"
for (i <- 0 until s.length) {
  print(s.charAt(i) - 'a')
}