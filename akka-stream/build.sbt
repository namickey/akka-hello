name := "demoProject"
version := "1.0"
scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.6",
  "com.typesafe.akka" %% "akka-remote" % "2.4.6",
  "com.typesafe.akka" %% "akka-stream" % "2.4.6"
)

