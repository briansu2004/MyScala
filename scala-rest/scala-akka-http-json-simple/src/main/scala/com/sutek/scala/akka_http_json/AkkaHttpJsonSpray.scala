package com.sutek.scala.akka_http_json

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

import java.util.UUID

//case class Person(name: String, age: Int)
//
//case class UserAdded(id: String, timestamp: Long)

import spray.json._

trait PersonJsonProtocol extends DefaultJsonProtocol {
  implicit val personFormat = jsonFormat2(Person)
  implicit val UserAddedFormat = jsonFormat2(UserAdded)
}

object AkkaHttpJsonSpray extends PersonJsonProtocol with SprayJsonSupport {
  implicit val system = ActorSystem(Behaviors.empty, "AkkaHttpJson")

  val route: Route = (path("api" / "user") & post) {
    entity(as[Person]) { person: Person =>
      complete(UserAdded(UUID.randomUUID().toString, System.currentTimeMillis()))
    }
  }

  def main(args: Array[String]): Unit = {
    Http().newServerAt("localhost", 8082).bind(route)
  }
}
