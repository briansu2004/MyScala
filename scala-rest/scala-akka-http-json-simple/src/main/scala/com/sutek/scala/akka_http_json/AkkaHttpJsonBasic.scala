package com.sutek.scala.akka_http_json

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

//case class Person(name: String, age: Int)
//
//case class UserAdded(id: String, timestamp: Long)

object AkkaHttpJsonBasic {
  implicit val system = ActorSystem(Behaviors.empty, "AkkaHttpJson")

  val route: Route = (path("api" / "user") & post) {
    complete("Yep, roger that!")
  }

  def main(args: Array[String]): Unit = {
    Http().newServerAt("localhost", 8081).bind(route)
  }
}
