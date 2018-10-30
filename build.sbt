name := "learn-fp"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies += Seq(
  "org.scalactic" %% "scalactic"   % "3.0.4",
  "org.scalatest" %% "scalatest"   % "3.0.4" % "test",
  "com.geirsson"  % "sbt-scalafmt" % "1.5.1"
)

scalacOptions ++= Seq("-language:implicitConversions", "-language:reflectiveCalls", "-language:higherKinds")

// debug implicits helper
// scalacOptions in ThisBuild += "-Xlog-implicits"
