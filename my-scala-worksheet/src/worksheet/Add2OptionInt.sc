//val a: Option[Int] = Some(1)
//val b: Option[Int] = Some(2)
//
//a.map(_ + b.getOrElse(0)).orElse(a)
//
//a.map(_ + None.getOrElse(0)).orElse(a)

def add2OptionInt(a: Option[Int], b: Option[Int]): Option[Int] =
  for (x <- a.orElse(Some(0)); y <- b.orElse(Some(0)))
    yield x + y

add2OptionInt(None, None)
add2OptionInt(None, Some(1))
add2OptionInt(Some(3), Some(4))
add2OptionInt(Some(8), Some(9))

