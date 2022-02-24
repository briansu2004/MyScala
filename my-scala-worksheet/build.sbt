ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "my-scala-worksheet"
  )

libraryDependencies += "org.typelevel" %% "cats-core" % "2.3.0"

//lazy val zioVersion = "1.0.13"
//
//libraryDependencies ++= Seq(
//  "dev.zio" %% "zio-test"          % zioVersion % "test",
//  "dev.zio" %% "zio-test-sbt"      % zioVersion % "test",
//  "dev.zio" %% "zio-test-magnolia" % zioVersion % "test" // optional
//)
//testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

libraryDependencies += "dev.zio" %% "zio" % "2.0.0-M4"
libraryDependencies += "dev.zio" %% "zio-streams" % "2.0.0-M4"