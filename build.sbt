
name := "akka-learn"

organization in ThisBuild := "com.akka.learn"

scalaVersion in ThisBuild := "2.13.2"


lazy val global = project
  .in(file("."))
  .aggregate(
    service,
    common
  ).settings(
  //mainClass in assembly := Some("com.adobe.email.send.ESSMain")
)

lazy val service = project
  .settings(
    name := "service",
    //defaultSettings,
    resolvers ++= repos,
    assemblyJarName in assembly := "service.jar",
    version:="0.1-SNAPSHOT",
    libraryDependencies ++= commonDependencies ++ Seq(
        dependencies.akkHTTPCore,
        dependencies.akkaHTTP,
        dependencies.akkaStream,
        dependencies.sprayJson
    )
  )
  .dependsOn(common)

lazy val common = project
  .settings(
    name := "common",
    assemblyJarName in assembly := "common.jar",
    //defaultSettings,
    version:="0.1-SNAPSHOT",
    resolvers ++= repos,
    libraryDependencies ++= commonDependencies
  )

lazy val dependencies =
  new {
    val logbackV = "1.2.3"
    val scalaLoggingV = "3.7.2"
    val slf4jV = "1.7.25"
    val typesafeConfigV = "1.3.1"
    val pureconfigV = "0.8.0"
    val akkaV = "2.5.31"
    val scalatestV = "3.0.4"
    val scalacheckV = "1.13.5"
    val akkaHttpV    = "10.1.12"
    val akkaStreamV = "2.6.5"
    val akkaHttpSprayVersion = "10.1.12"

    //val logback        = "ch.qos.logback"             % "logback-classic"          % logbackV
    //val slf4j          = "org.slf4j"                  % "jcl-over-slf4j"           % slf4jV
    //val typesafeConfig = "com.typesafe"               % "config"                   % typesafeConfigV
    val akka             = "com.typesafe.akka"          %% "akka-actor"              % akkaV
    val akkHTTPCore      = "com.typesafe.akka"          %% "akka-http-core"          % akkaHttpV
    val akkaHTTP         = "com.typesafe.akka"          %% "akka-http"               % akkaHttpV
    val akkaStream       = "com.typesafe.akka"          %% "akka-stream"             % akkaStreamV
    val sprayJson        ="com.typesafe.akka"           %% "akka-http-spray-json"    % akkaHttpSprayVersion
    //val scalatest      = "org.scalatest"              %% "scalatest"               % scalatestV
    //val scalacheck     = "org.scalacheck"             %% "scalacheck"              % scalacheckV
  }
lazy val commonDependencies = Seq(
  /*dependencies.logback,
  dependencies.slf4j,
  dependencies.typesafeConfig,*/
  dependencies.akka,
  /*dependencies.scalatest  % "test",
  dependencies.scalacheck % "test"*/
)

lazy val defaultSettings =
    Seq(
      scalacOptions := Seq(
        "-feature",
        "-language:implicitConversions",
        "-language:postfixOps",
        "-unchecked",
        "-deprecation",
        "-encoding", "utf8",
        "-Ywarn-adapted-args"
      )
    )
val repos = List(
  "Experience Platform Release Local" at
    "https://artifactory.corp.adobe.com/artifactory/maven-experienceplatform-release",
  "Experience Platform Snapshot Local" at
    "https://artifactory.corp.adobe.com/artifactory/maven-experienceplatform-snapshot",
  "Digital Marketing Release Local" at
    "https://artifactory.corp.adobe.com/artifactory/maven-digital-marketing-release",
  "Digital Marketing Snapshot Local" at
    "https://artifactory.corp.adobe.com/artifactory/maven-digital-marketing-snapshot",
  Resolver.mavenLocal
)