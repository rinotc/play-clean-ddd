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
    name := "play-clean-ddd-domain",
    idePackagePrefix := Some(
      "dev.tchiba.domain"
    ) // https://blog.jetbrains.com/scala/2020/11/26/enhanced-package-prefixes/
  )

lazy val application = (project in file("application"))
  .dependsOn(domain)
  .settings(
    commonSettings,
    name := "play-clean-ddd-application",
    idePackagePrefix := Some("dev.tchiba.application")
  )

lazy val infrastructure = (project in file("infrastructure"))
  .dependsOn(domain, application)
  .settings(
    commonSettings,
    name := "play-clean-ddd-application",
    idePackagePrefix := Some("dev.tchiba.infrastructure")
  )

lazy val web = (project in file("web"))
  .enablePlugins(PlayScala)
  .dependsOn(domain, application, infrastructure)
  .settings(
    commonSettings,
    name := "play-clean-ddd-web",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
      "net.codingwell"         %% "scala-guice"        % "4.2.6"
    )
  )
