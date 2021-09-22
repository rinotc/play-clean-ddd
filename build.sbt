ThisBuild / organization := "dev.tchiba"
ThisBuild / version := "0.1"
ThisBuild / scalaVersion := "2.13.6"
ThisBuild / scalacOptions := Seq(
  "-deprecation",
  "-feature"
)

lazy val guiceLibraries = Seq(
  "com.google.inject" % "guice"       % "5.0.1",
  "net.codingwell"   %% "scala-guice" % "4.2.6"
)

lazy val di = (project in file("di"))
  .dependsOn(domain, application, infrastructure)
  .settings(
    libraryDependencies ++= guiceLibraries
  )

lazy val domain = (project in file("domain"))
  .settings(
    name := "play-clean-ddd-domain",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test
    )
  )

lazy val application = (project in file("application"))
  .dependsOn(domain)
  .settings(
    name := "play-clean-ddd-application",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.3.0"
    ) ++ guiceLibraries
  )

lazy val infrastructure = (project in file("infrastructure"))
  .dependsOn(domain, application)
  .settings(
    name := "play-clean-ddd-infrastructure",
    libraryDependencies ++= Seq(
      "com.typesafe.slick" %% "slick"          % "3.3.3",
      "org.slf4j"           % "slf4j-nop"      % "1.6.4",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3",
      "org.postgresql"      % "postgresql"     % "42.2.23"
    ) ++ guiceLibraries
  )

lazy val web = (project in file("web"))
  .enablePlugins(PlayScala)
  .dependsOn(di)
  .settings(
    PlayKeys.fileWatchService := play.dev.filewatch.FileWatchService.jdk7(play.sbt.run.toLoggerProxy(sLog.value)),
    name := "play-clean-ddd-web",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
    ) ++ guiceLibraries
  )
