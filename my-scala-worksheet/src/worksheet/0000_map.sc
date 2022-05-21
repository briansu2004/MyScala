import scala.collection.MapView

/* create an empty map */
val emptyMap: Map[Int, String] = Map.empty[Int, String]
val emptyMap: Map[Int, String] = Map[Int, String]()

/* create a non-empty map */
val map: Map[Int, String] = Map(1 -> "first", 2 -> "second")
val map: Map[Int, String] = Map.apply(1 -> "first", 2 -> "second")
val map: Map[Int, String] = List(1 -> "first", 2 -> "second").toMap

List(1 -> "first", 2 -> "second")
  .foldLeft(Map.empty[Int, String]) {
    case (map, (key, value)) =>
      map + (key -> value)
  }


// Empty hash table whose keys are strings and values are integers:
var A:Map[Char,Int] = Map()
A += ('I' -> 1)
A += ('J' -> 5)
A += ('K' -> 10)
A += ('L' -> 100)   // ???
A
A+('Z'->89)
// A map with keys and values.
val colors = scala.collection.mutable.Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
colors + ("black" -> "#000000")

println( "Keys in colors : " + colors.keys )
println( "Values in colors : " + colors.values )
println( "Check if colors is empty : " + colors.isEmpty )
val nums: Map[Int, Int] = Map()
println( "Check if nums is empty : " + nums.isEmpty )

/* Map.contains */
colors.contains( "red" )
colors.contains( "maroon" )

/* def clear(): Unit */
colors.clear()
colors
colors.isEmpty

/*
def clone(): Map[A, B]
Creates a copy of the receiver object. */
val names1 = scala.collection.mutable.Map("Brian" -> 1, "Jessie" -> 2, "Emily" -> 3, "Effie" -> 4)
//val names2 = names1.clone()
val names2 = names1.clone()
names2.mkString(" ")
//names2.exists("Brian")
names2.contains("Brian")
names2.contains("Ethon")
names2.get("Jessie")
names2 += ("Someone" -> 9)
names2
names2.filter(x => x._2 < 9)
names2.remove("Someone")
names2
names2.remove("Soomeone")
//names2.get("Emily") = 8
//names2.find("Effie")
//names2.put("Brian" -> 10)
//names2.count((k, v) => v < 3)
val names3 = names2.empty

/* to add or update a key/value pair in the map, use + */
names2 += ("Brian" -> 8)
/* To remove multiple elements, use the - or -- methods */
names2 - "Jessie"
//val kids = names2 -- "Brian"
names2 - ("Brian", "Jessie")
names2 -- List("Brian", "Jessie")

val names3 = names1.clone()
names3 += ("Brian" -> 9)
names3
names1 // clone is by value, not by reference

/* apply */
val map: Map[Int, String] = Map(1 -> "first", 2 -> "second")
map.apply(1) // "first"

/* withDefaultValue */
val map: Map[Int, String] = Map(1 -> "first", 2 -> "second")
val mapWithDefaultValue: Map[Int, String] = map.withDefaultValue("unknown")
mapWithDefaultValue(1)
mapWithDefaultValue(3)
mapWithDefaultValue
/* withDefault */
val mapWithDefault: Map[Int, String] = map.withDefault(i => i + "th")
mapWithDefault(1)
mapWithDefault(5)
mapWithDefault

val initialMap: Map[Int, String] = Map(1 -> "first", 2 -> "second", 3 -> "third", 4 -> "forth")
val abbreviate: ((Int, String)) => (Int, String) = {
  case (key, value) =>
    val newValue = key + value.takeRight(2)
    key -> newValue
}
val abbreviatedMap = initialMap.map(abbreviate)
initialMap

val initialMap: Map[Int, String] = Map(1 -> "first", 2 -> "second")
val reverse: String => String = value => value.reverse
val reversed: MapView[Int, String] = initialMap.view.mapValues(reverse)
reversed.get(1)
reversed.get(2)

val predicate: ((Int, String)) => Boolean = {
  case (key, value) => key > 1 && value.length > 5
}
val initialMap: Map[Int, String] = Map(1 -> "first", 2 -> "second")
val filtered: Map[Int, String] = initialMap.filter(predicate)
filtered

val predicate: Int => Boolean = key => key > 1
val initialMap: Map[Int, String] = Map(1 -> "first", 2 -> "second")
val filtered: MapView[Int, String] = initialMap.view.filterKeys(predicate)
filtered.get(1)
filtered.get(2)