val score: BigDecimal = 100
val total: BigDecimal = 20
(score/total).setScale(1)

println(f"${score/total}%.1f")

println(f"${4.0/3.0}%.4f")