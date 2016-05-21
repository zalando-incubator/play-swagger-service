name := "play-swagger-service"

version := "0.1.9"

lazy val root = (project in file(".")).enablePlugins(PlayScala, PlaySwagger)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "org.scalacheck" %% "scalacheck"        % "1.12.4" % Test,
  "org.specs2"     %% "specs2-scalacheck" % "3.6" % Test,
  "me.jeffmay" %% "play-json-tests" % "1.3.0" % Test
)

resolvers ++= Seq(
  "zalando-bintray"  at "https://dl.bintray.com/zalando/maven",
  "scalaz-bintray"   at "http://dl.bintray.com/scalaz/releases",
  "jeffmay" at "https://dl.bintray.com/jeffmay/maven",
  Resolver.url("sbt-plugins", url("http://dl.bintray.com/zalando/sbt-plugins"))(Resolver.ivyStylePatterns)
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
