name := "play-clean-ddd"

idePackagePrefix := Some("dev.tchiba")

lazy val commonSettings = Seq(
  organization := "dev.tchiba",
  version := "0.1",
  scalaVersion := "2.13.4"
)

lazy val root = (project in file("."))
  .aggregate(domain, application, infrastructure, web)

lazy val domain = (project in file("domain"))

lazy val application = (project in file("application"))

lazy val infrastructure = (project in file("infrastructure"))

lazy val web = (project in file("web"))
  .enablePlugins(PlayScala)
