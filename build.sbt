name := "JsonBenchmark"

description := "JsonBenchmark"

version := "1.0.0"

scalaVersion := "2.11.8"

useJCenter := true

libraryDependencies ++= {
  Seq(
    "co.blocke" %% "scalajack" % "5.0.2",
    "org.json4s" %% "json4s-native" % "3.5.0",
    "org.json4s" %% "json4s-jackson" % "3.5.0",
    "io.circe" %% "circe-core" % "0.6.1",
    "io.circe" %% "circe-generic" % "0.6.1",
    "io.circe" %% "circe-parser" % "0.6.1",
    "org.scalatest" %% "scalatest" % "2.2.1" % "test"
  )
}

