name := "implicitly-yours"

version := "1.0"

scalaVersion := "2.11.4"

scalacOptions := Seq(
  "-unchecked"
  ,"-deprecation"
  ,"-encoding","utf8"
  ,"-feature"
  ,"-language:implicitConversions"
)

libraryDependencies +=
  "com.typesafe.akka" %% "akka-actor" % "2.3.8"
