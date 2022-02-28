import zio.{Console, _}

import scala.io.Source

for {
  _ <- Console.printLine("Hello! What is your name?")
  n <- Console.readLine
  _ <- Console.printLine("Hello, " + n + ", good to meet you!")
} yield ()


ZIO.acquireReleaseWith(
  ZIO.attemptBlocking(Source.fromFile("file.txt"))
)(file => ZIO.attempt(file.close()).orDie) { file =>
  ZIO.attemptBlocking(file.getLines().mkString("\n"))
}

// Service Definition
trait Logging {
  def log(line: String): UIO[Unit]
}

// Companion object containing accessor methods
object Logging {
  def log(line: String): URIO[Has[Logging], Unit] = ZIO.serviceWith[Logging](_.log(line))
}

// Live implementation of Logging service
case class LoggingLive(console: Console, clock: Clock) extends Logging {
  override def log(line: String): UIO[Unit] =
    for {
      current <- clock.currentDateTime
      _       <- console.printLine(s"$current--$line").orDie
    } yield ()
}

// Companion object of LoggingLive containing the service implementation into the ZLayer
object LoggingLive {
  val layer: URLayer[Has[Console] with Has[Clock], Has[Logging]] =
    (LoggingLive(_, _)).toLayer
}


//val app: ZIO[Has[Logging] with Has[UserService], Throwable, Unit] =
//  for {
//    userService <- ZIO.service[UserService]
//    logger      <- ZIO.service[Logging]
//    id          <- userService.addUser("Daniel", "me@daniel.site")
//    _           <- logger.log(s"New user added with $id id")
//  } yield ()
//
//val myApp: ZIO[Any, Throwable, Unit] =
//  app.inject(
//    UserServiceLive.layer,
//    LoggingLive.layer
//  )


//for {
//  fiber1 <- longRunningJob.fork
//  fiber2 <- anotherLongRunningJob.fork
//  _ <- Console.printLine("Execution of two job started")
//  result <- (fiber1 <*> fiber2).join
//} yield result

//ZIO.foreachPar(pages) { page =>
//  fetchUrl(page)
//}

//object legacy {
//  def login(
//             onSuccess: User => Unit,
//             onFailure: AuthError => Unit): Unit = ???
//}
//
//val login: ZIO[Any, AuthError, User] =
//  ZIO.async[Any, AuthError, User] { callback =>
//    legacy.login(
//      user => callback(IO.succeed(user)),
//      err  => callback(IO.fail(err))
//    )
//  }

val text = "A B A B A "

Stream
  .repeatEffectWith(ZIO.succeed(text), Schedule.recurs(1))
  .tap(putStrLn(_))
  .transduce(ZTransducer.splitOn(" "))
  .tap(putStrLn(_))
  .groupByKey(identity) { case (word, stream) =>
    stream
      .tap(x => putStrLn("aggStreamBefore " + x))
      .scan((0, word)){case (acc, _) => (acc._1 + 1, word)}
      .tap(x => putStrLn("aggStreamAfter " + x.toString))
  }
  .tap(x => putStrLn(x.toString + "\n"))
  .runCollect
  .flatMap(chunk => putStrLn(chunk.mkString(", ")))
  .exitCode
