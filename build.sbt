name := "becnhmark"

organization := "com.cornfluence"

description := "Benchmarking tool"

version := "0.1.0"

scalaVersion := "2.11.2"

resolvers ++= Seq(
  "OSS"  at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= {
  Seq(
    "org.scalatest" %% "scalatest" % "2.2.1" % "test",
    "co.blocke"	  %% "scalajack" % "2.0.5",
    "org.json4s" %% "json4s-native" % "3.2.11",
    "org.json4s" %% "json4s-jackson" % "3.2.11"
  )
}

