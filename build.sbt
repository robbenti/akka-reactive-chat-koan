name := """akka-reactive-chat"""

version := "1.0"

scalaVersion := "2.11.1"

val akkaVersion = "2.3.6"
val sprayVersion = "1.3.2"
val logbackVersion = "1.1.1"
val scalatestVersion = "2.1.6"

libraryDependencies ++= Seq(
  "com.typesafe.akka"     %% "akka-actor"          % akkaVersion,
  "com.typesafe.akka"     %% "akka-slf4j"          % akkaVersion,
  "io.spray"              %% "spray-json"          % "1.3.1",
  "io.spray"              %% "spray-can"           % sprayVersion,
  "io.spray"              %% "spray-routing"       % sprayVersion,
  "ch.qos.logback"        %  "logback-classic"     % logbackVersion,
  "com.typesafe.akka"     %% "akka-testkit"        % akkaVersion         % "test",
  "org.scalatest"         %% "scalatest"           % scalatestVersion    % "test")
