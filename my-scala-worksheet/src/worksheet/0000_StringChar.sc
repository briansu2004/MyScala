val s = "abbabb"
for (i <-  1 until s.length) {
  val ns = s.slice(i, s.length)
  println(ns)
}


var dna = "abcdefghijk"
dna.slice(2, 8)
dna.substring(2, 8)
dna.substring(1, dna.length)

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