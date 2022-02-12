ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "interview"
  )

// https://mvnrepository.com/artifact/org.scalatest/scalatest-core
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.11" % "test"