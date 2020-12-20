idePackagePrefix := Some("dev.tchiba")

lazy val commonSettings = Seq(
  organization := "dev.tchiba",
  version := "0.1",
  scalaVersion := "2.13.4",
  scalacOptions := Seq(
    "-deprecation",
    "-feature",
    "-Xfatal-warnings"
  )
)

lazy val root = (project in file("."))
  .aggregate(domain, application, infrastructure, web)
  .settings(
    commonSettings,
    name := "play-clean-ddd",
    publishArtifact := false
  )

lazy val domain = (project in file("domain"))
  .settings(
    commonSettings,
    name := "play-clean-ddd-domain"
  )

lazy val application = (project in file("application"))
  .settings(
    commonSettings,
    name := "play-clean-ddd-application"
  )

lazy val infrastructure = (project in file("infrastructure"))
  .settings(
    commonSettings,
    name := "play-clean-ddd-application"
  )

lazy val web = (project in file("web"))
  .enablePlugins(PlayScala)
  .settings(
    commonSettings,
    name := "play-clean-ddd-web",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
      "net.codingwell"         %% "scala-guice"        % "4.2.6"
    )
  )
