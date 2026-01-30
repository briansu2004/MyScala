name := "StockDemo"

version := "0.1"

// Your installed version
scalaVersion := "3.5.1"
// scalaVersion := "3.8.1"

// scalaVersion := "2.13.12"   // latest 2.13.x

val sparkVersion = "3.5.0"

// libraryDependencies ++= Seq(
//   "org.apache.spark" %% "spark-core" % sparkVersion,
//   "org.apache.spark" %% "spark-sql" % sparkVersion
// )

libraryDependencies ++= Seq(
  // The 'cross CrossVersion.for3Use2_13' tells SBT:
  // "I am using Scala 3, but please download the library meant for Scala 2.13"
  ("org.apache.spark" %% "spark-core" % sparkVersion).cross(CrossVersion.for3Use2_13),
  ("org.apache.spark" %% "spark-sql" % sparkVersion).cross(CrossVersion.for3Use2_13)
)

fork := true

javaOptions ++= Seq(
  "--add-exports=java.base/sun.nio.ch=ALL-UNNAMED",
  "--add-opens=java.base/sun.nio.ch=ALL-UNNAMED"
)

// libraryDependencies ++= Seq(
//   // The 'cross CrossVersion.for3Use2_13' tells SBT:
//   // "I am using Scala 3, but please download the library meant for Scala 2.13"
//   ("org.apache.spark" %% "spark-core" % sparkVersion).cross(CrossVersion.for3Use2_13),
//   ("org.apache.spark" %% "spark-sql" % sparkVersion).cross(CrossVersion.for3Use2_13)
// )

// // --- FIX FOR JAVA 17 ---
// // 1. Run in a separate process (fork) so we can pass specific JVM args
// fork := true

// // 2. Pass these flags to allow Spark to access internal Java memory APIs
// //  "--add-opens=java.base/java.lang=ALL-UNNAMED",
// //  "--add-opens=java.base/java.lang.invoke=ALL-UNNAMED",
// //  "--add-opens=java.base/java.lang.reflect=ALL-UNNAMED",
// //  "--add-opens=java.base/java.io=ALL-UNNAMED",
//   // "--add-opens=java.base/java.net=ALL-UNNAMED",
//   // "--add-opens=java.base/java.nio=ALL-UNNAMED",
//   // "--add-opens=java.base/java.util=ALL-UNNAMED",
//   // "--add-opens=java.base/java.util.concurrent=ALL-UNNAMED",
//   // "--add-opens=java.base/java.util.concurrent.atomic=ALL-UNNAMED",
//   // "--add-opens=java.base/sun.nio.ch=ALL-UNNAMED",
//   // "--add-opens=java.base/sun.nio.cs=ALL-UNNAMED",
//   // "--add-opens=java.base/sun.security.action=ALL-UNNAMED",
//   // "--add-opens=java.base/sun.util.calendar=ALL-UNNAMED",
//   // "--add-opens=java.security.jgss/sun.security.krb5=ALL-UNNAMED"
// javaOptions ++= Seq(
// )
