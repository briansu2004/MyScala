val floatList = "10 9.8 8 7.8 7.7 7 6 5 4 2 ".strip().split(" ").toList.map(x => x.toFloat)
floatList.sum
floatList.foldLeft(0.0)(_ + _)