val map1 = Map(1 -> "a", 2 -> "b")
val map2 = Map(2 -> "c", 3 -> "d")

map1 ++ map2

map2 ++ map1

map2 ++ map1.map {
  case (k, v) => map2.get(k) match {
    case None => k -> v
    case Some(x) => k -> (x + v)
  }
}

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

