name := "ScalaJackTest"

description := "ScalaJackTest"

version := "1.0.0"

scalaVersion := "2.11.8"

useJCenter := true

libraryDependencies ++= {
  Seq(
    "co.blocke" %% "scalajack" % "5.0.2",
    "org.json4s" % "json4s-native_2.11" % "3.5.0",
    "org.json4s" % "json4s-jackson_2.11" % "3.5.0",
    "org.scalatest" %% "scalatest" % "2.2.1" % "test"
  )
}

