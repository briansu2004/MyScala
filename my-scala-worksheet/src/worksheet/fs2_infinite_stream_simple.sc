import fs2._
import cats.effect.{IO, Timer}
import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

val stream1 = Stream.constant("PING")
stream1.take(20).compile.toList

val stream2 = Stream(1,2,3).repeat
stream2.take(50).compile.toList

implicit val timer: Timer[IO] = IO.timer(ExecutionContext.global)

val stream = Stream.awakeEvery[IO](5.seconds)

stream.take(2).compile.toList