val AIRFRAME_VERSION = "21.5.4"

lazy val commonSettings = Seq(
  organization := "dev.tchiba",
  version := "0.1",
  scalaVersion := "2.13.4",
  scalacOptions := Seq(
    "-deprecation",
    "-feature",
    "-Xfatal-warnings"
  ),
  libraryDependencies ++= Seq(
    "org.typelevel"      %% "cats-core"     % "2.3.0",
    "org.wvlet.airframe" %% "airframe-ulid" % AIRFRAME_VERSION // ULID generator
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
    // https://blog.jetbrains.com/scala/2020/11/26/enhanced-package-prefixes/
    idePackagePrefix := Some("dev.tchiba.ddd.domain"),
    libraryDependencies ++= Seq(
      "org.wvlet.airframe" %% "airframe" % "21.5.4"
    )
  )

lazy val application = (project in file("application"))
  .dependsOn(domain)
  .settings(
    commonSettings,
    idePackagePrefix := Some("dev.tchiba.ddd.application"),
    name := "play-clean-ddd-application"
  )

lazy val infrastructure = (project in file("infrastructure"))
  .dependsOn(domain, application)
  .settings(
    commonSettings,
    idePackagePrefix := Some("dev.tchiba.ddd.infrastructure"),
    name := "play-clean-ddd-infrastructure"
  )

lazy val web = (project in file("web"))
  .enablePlugins(PlayScala)
  .dependsOn(domain)
  .aggregate(domain)
  .settings(
    commonSettings,
    idePackagePrefix := Some("dev.tchiba.ddd.web"),
    name := "play-clean-ddd-web",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
      "net.codingwell"         %% "scala-guice"        % "4.2.6"
    )
  )
