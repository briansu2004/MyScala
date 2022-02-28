import fs2._

val pureStream: Stream[Pure, Int] = Stream(1,2,3,4)

pureStream.compile.toList

val a = Stream("John", "Ringo")
val b = Stream("George", "Paul")

(a ++ b).compile.toVector
(a ++ b).compile.toList
(a ++ b).compile.count
