import scala.math._

val boy = 1.09
val girl = 1
val chance = scala.math.pow(boy / (boy + girl), 3)
println(f"$chance%.3f")
// 0.696

3.round
(1.2).round
(1.35).round
(3.5).round
(-3.5).round
(-1.7).round

3.7.ceil.toInt
ceil(1.2)
floor(3.7)

(5.4).floor

(9 / 2).floor

val md = 28235.348374342345634526345238
f"$md%1.5f"
f"$md%.2f"



val pi = scala.math.Pi
f"$pi%1.5f"
f"$pi%1.2f"
f"$pi%06.2f"


val arr: Array[Array[Int]] = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))
arr
arr.size
arr.length

math.abs(-2)

val n = 2
(1 to 10).map(println(s"$n x _ = ${n * _}"))
