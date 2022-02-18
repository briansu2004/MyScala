var x = Seq("Geeks", "For", "Geeks")
var y = x.map(_.toUpperCase)
var z = x.flatMap(_.toUpperCase)

val list1 = List(1, 2, 3, 4)
val list2 = List(5, 6, 7, 8)

list1 map { q =>
  list2 map {
    r => q + r
  }
}
list1 flatMap { q =>
  list2 map {
    r => q + r
  }
}

val x = (1 to 3).toList
val y = (1 to 7 by 2).toList

x map { s =>
  y map {
    t => s * t
  }
}
x flatMap { s =>
  y map {
    t => s * t
  }
}

