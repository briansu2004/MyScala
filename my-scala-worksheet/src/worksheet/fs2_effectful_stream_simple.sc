import cats.effect.IO
import fs2._

def getAge(name: String): IO[Int] = IO(name.length)

// start from a pure stream
val stream = Stream("John", "Paul", "George", "Ringo")

// add some effects to it
val effectfulStream = stream.evalMap(getAge)

stream.evalFilter(name => IO(name.contains("o")))
effectfulStream.compile.toList

stream.evalTap(name => IO(println(s"Received: $name"))).compile.drain

