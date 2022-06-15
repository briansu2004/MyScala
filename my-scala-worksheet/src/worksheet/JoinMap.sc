val map1 = Map(1 -> "a", 2 -> "b")
val map2 = Map(2 -> "c", 3 -> "d")

map1 ++ map2

map2 ++ map1

// Map(2 -> cb, 3 -> d, 1 -> a)
map2 ++ map1.map {
  case (k, v) => map2.get(k) match {
    case None => k -> v
    case Some(x) => k -> (x + v)
  }
}
// Map(2 -> cb, 3 -> dd, 1 -> a) ???
(map2 ++ map1).map {
  case (k, v) => map2.get(k) match {
    case None => k -> v
    case Some(x) => k -> (x + v)
  }
}

// Map(1 -> a, 2 -> bc, 3 -> d)
map1 ++ map2.map {
  case (k, v) => map1.get(k) match {
    case None => k -> v
    case Some(x) => k -> (x + v)
  }
}

map2.map {
  case (k, v) => map1.get(k) match {
    case None => k -> v
    case Some(x) => k -> (x + v)
  }
}

val m1 = Map(1 -> "a", 2 -> "b")
val m2 = Map(2 -> "c", 3 -> "d")
