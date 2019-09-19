name := "demoProject"
version := "1.0"
scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream" % "2.5.25",
  "com.typesafe.akka" %% "akka-actor" % "2.5.25",
  "com.typesafe.akka" %% "akka-remote" % "2.5.25"
)
