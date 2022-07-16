"99100".slice(0, 1).toInt
"99100".slice(0, 2).toInt

"a" == "a"
val s1 = "b"
val s2 = "b"
s1 == s2

9.toString + 10.toString

"We promptly judged antique ivory buckles for the prize".toLowerCase
"We promptly judged antique ivory buckles for the prize".toLowerCase()

for (i <- "hackerrank") {
  println(i)
}

"zhackerank".indexOf("r")
"zhackerank".indexOf("r", 6)
"zhackerank".indexOf("r", 7)

"hereiamstackerrank".indexOf("h")
"hereiamstackerrank".indexOf("h", 0)
"hereiamstackerrank".indexOf("h", -1)
"hereiamstackerrank".indexOf("a", "ahereiamstackerrank".indexOf("h"))

val arr = "ahereiamstackerrank".toCharArray.filter(x => "hackerrank".contains(x))
arr.indexOf('h')
arr.indexOf('a', arr.indexOf('h'))


"SOS" * 10

"saveChangesInTheEditor".toCharArray

'a' - 'A'

val s = "aabcd"
s.slice(0, 0) + s.slice(2, s.length)

val str = "1912"
str.slice(0, 1) + 'X' + str.slice(2, 4)


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