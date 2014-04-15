name := "LightSpeedApp-Akka"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-cluster" % "2.2.3",
  "com.typesafe.akka" %% "akka-kernel" % "2.2.1",
  "org.fusesource" % "sigar" % "1.6.4",
  jdbc,
  anorm,
  cache
)     

play.Project.playScalaSettings
