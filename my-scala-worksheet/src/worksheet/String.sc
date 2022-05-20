val s = "07:05:45PM"
s.slice(0, 2)
s.slice(0, 2).toInt
s.slice(0, s.length - 2)
s.slice(2, s.length - 2)
val ampm = s.slice(s.length - 2, s.length)
ampm


val sNone: Option[String] = None
sNone
sNone.isEmpty
sNone.nonEmpty

val sNull = null
sNull
//sNull.isEmpty   // error

val sEmpty = ""
sEmpty
sEmpty.isEmpty
sEmpty.nonEmpty

//val sNothing = Nothing
//sNothing
//sNothing.isEmpty  // error

val scala = "Scala"
scala
scala.isEmpty
scala.nonEmpty