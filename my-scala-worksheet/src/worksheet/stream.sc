val x = Stream(1,2,3,4)                   //> x  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
10#::x

val y = List(1,2,3,4)                     //> y  : List[Int] = List(1, 2, 3, 4)
10::y

val z = LazyList(1,2,3,4)                     //> y  : List[Int] = List(1, 2, 3, 4)
10#::z

