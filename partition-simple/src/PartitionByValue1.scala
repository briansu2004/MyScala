

//val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
//val nums: Map[Int, Int] = Map()
//println( "Keys in colors : " + colors.keys )
//println( "Values in colors : " + colors.values )
//println( "Check if colors is empty : " + colors.isEmpty )
//println( "Check if nums is empty : " + nums.isEmpty )
/*
Keys in colors : Set(red, azure, peru)
Values in colors : Iterable(#FF0000, #F0FFFF, #CD853F)
Check if colors is empty : false
Check if nums is empty : true
 */

//val colors1 = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
//val colors2 = Map("blue" -> "#0033FF", "yellow" -> "#FFFF00", "red" -> "#FF0000")
//
//// use two or more Maps with ++ as operator
//var colors = colors1 ++ colors2
//println( "colors1 ++ colors2 : " + colors )
//
//// use two maps with ++ as method
//colors = colors1.++(colors2)
//println( "colors1.++(colors2)) : " + colors )
/*
colors1 ++ colors2 : HashMap(blue -> #0033FF, azure -> #F0FFFF, peru -> #CD853F, yellow -> #FFFF00, red -> #FF0000)
colors1.++(colors2)) : HashMap(blue -> #0033FF, azure -> #F0FFFF, peru -> #CD853F, yellow -> #FFFF00, red -> #FF0000)
 */

//class PartitionByValue {
//  def partitionByValue(p: ((K, V)) => Boolean): (HashMap[K, V], HashMap[K, V]) = {
//    // This method has been preemptively overridden in order to ensure that an optimizing implementation may be included
//    // in a minor release without breaking binary compatibility.
//    //
//    // In particular, `partition` could be optimized to traverse the trie node-by-node, splitting each node into two,
//    // based on the result of applying `p` to its elements and subnodes.
//    p
//  }
//}

//Output: Map(a -> List(1, 2, 3), b -> List(2, 3), c -> List(4))
//println(mp ++ Map("c" -> List(4)))

//import scala.collection.immutable.HashMap
//
//    override def partition(p: ((K, V)) => Boolean): (HashMap[K, V], HashMap[K, V]) = {
//      // This method has been preemptively overridden in order to ensure that an optimizing implementation may be included
//      // in a minor release without breaking binary compatibility.
//      //
//      // In particular, `partition` could be optimized to traverse the trie node-by-node, splitting each node into two,
//      // based on the result of applying `p` to its elements and subnodes.
//      super.partition(p)
//    }

//mp.keys.foreach { i =>
//  print("Key = " + i)
//  println(" Value = " + mp(i))
//}
/*
Key = a Value = List(1, 2, 3)
Key = b Value = List(2, 3)
 */

object PartitionByValue1 {

  def main(args: Array[String]): Unit = {
    // Output:
    // (Map(a -> List(1, 2, 3)),Map(b -> List(2, 3)))
    //println(mp.partition(x => x._2.length > 2))


    // Output: Map(List(1, 2) -> List(3), List(2) -> List(3))
    //println(mp map { x => x._2.span(_ <= 2) })
    // Output: Map(a -> (List(1, 2),List(3)), b -> (List(2),List(3)))
    //println(mp map { x => (x._1, x._2.span(_ <= 2)) })

    //Map(a -> (List(1, 2),List(3)))
    //Map(b -> (List(2),List(3)))
    //mp.keys.foreach { x => println(Map(x -> mp(x).span(_ <= 2))) }

    //mp.keys.foreach { x => (mp(x).span(_ <= 2)).map(x -> _2) }

    val mp: Map[String, List[Int]] = Map("a" -> List(1, 2, 3), "b" -> List(2, 3))
    // Expected output:
    // (Map("a" -> List(1, 2), "b" -> List(2)), Map("a" -> List(3), "b" -> List(3)))

//    var out = mp.map {
//      //case(k, lst) => k -> lst.span(_ <= 2)   // Map(a -> (List(1, 2),List(3)), b -> (List(2),List(3)))
//      case (k, lst) => List(k -> lst.span(_ <= 2)).toMap //List(Map(a -> (List(1, 2),List(3))), Map(b -> (List(2),List(3))))
//    }
//    out.foreach {
//      //x => (x.keys -> x.values)
//      //x => println(x.values)  //Iterable((List(1, 2),List(3)))
//    }

//        var o = out.map {
//          //x => println(x.values)
//          x => x.values.foreach {
//            v => println( v)
//          }//.toMap
//        }

    var o1: Map[String, List[Int]] = Map()
    var o2: Map[String, List[Int]] = Map()
    mp.map {
      //case(k, lst) => k -> lst.span(_ <= 2)   // Map(a -> (List(1, 2),List(3)), b -> (List(2),List(3)))
      //case (k, lst) => List(k -> lst.span(_ <= 2)).toMap //List(Map(a -> (List(1, 2),List(3))), Map(b -> (List(2), List(3))))

      case(k, lst) => {
        /*
        Map(a -> List(1, 2))
        Map(a -> List(3))
        Map(b -> List(2))
        Map(b -> List(3))
         */
        //println(Map(k -> lst.span(_ <= 2)._1))
        //println(Map(k -> lst.span(_ <= 2)._2))

        //(Map(k -> lst.span(_ <= 2)._1), Map(k -> lst.span(_ <= 2)._2)) //Map(Map(a -> List(1, 2)) -> Map(a -> List
        // (3)), Map(b -> List(2)) -> Map(b -> List(3)))
        o1 = o1 ++ Map(k -> lst.span(_ <= 2)._1)
        o2 = o2 ++ Map(k -> lst.span(_ <= 2)._2)
      }
    }

//    println(o1)
//    println(o2)
    println(List(o1, o2))
  }
}
// Expected output:
// (Map("a" -> List(1, 2), "b" -> List(2)), Map("a" -> List(3), "b" -> List(3)))
