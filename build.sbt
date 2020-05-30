name := "learn-fp"

version := "0.1"

scalaVersion := "2.12.10"

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-explaintypes",
  "-unchecked",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Ywarn-unused:imports",
  "-Ywarn-unused:locals",
  "-Ywarn-unused:params",
  "-Ywarn-unused:privates",
  "-encoding",
  "utf8"
)

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.4"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.2" % Test


// debug implicits helper
// scalacOptions in ThisBuild += "-Xlog-implicits"

