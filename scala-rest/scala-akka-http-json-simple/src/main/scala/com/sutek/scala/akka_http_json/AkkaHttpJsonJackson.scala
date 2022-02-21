package com.sutek.scala.akka_http_json

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import de.heikoseeberger.akkahttpjackson.JacksonSupport

import java.util.UUID

case class Person(name: String, age: Int)

case class UserAdded(id: String, timestamp: Long)

object AkkaHttpJsonJackson extends JacksonSupport {
  implicit val system = ActorSystem(Behaviors.empty, "AkkaHttpJson")

  val route: Route = (path("api" / "user") & post) {
    entity(as[Person]) { person: Person =>
      complete(UserAdded(UUID.randomUUID().toString, System.currentTimeMillis()))
    }
  }

  def main(args: Array[String]): Unit = {
    Http().newServerAt("localhost", 8084).bind(route)
  }
}
