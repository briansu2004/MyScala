
import cats.implicits._

import scala.language.reflectiveCalls

val map1 = Map(1 -> List("a"), 2 -> List("b"))
val map2 = Map(1 -> List("c"), 2 -> List("d"))
map1 |+| map2
