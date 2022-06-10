val s = "abbabb"
for (i <-  1 to s.length - 1) {
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