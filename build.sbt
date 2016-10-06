val dottyVersion       = "0.1-SNAPSHOT"
val dottyBridgeVersion = "0.1.1-SNAPSHOT"

lazy val generic = project
  .settings(
    name := "generic",
    version := "0.1-SNAPSHOT",
    scalaVersion := dottyVersion,
    scalaOrganization := "ch.epfl.lamp",
    scalaBinaryVersion := "2.11",
    autoScalaLibrary := false,
    resolvers += Resolver.sonatypeRepo("snapshots"),
    libraryDependencies ++= Seq(
      "com.novocode" % "junit-interface" % "0.11" % "test",
      "ch.epfl.lamp" % "scala-library_2.11" % dottyVersion,
      "ch.epfl.lamp" % "dotty_2.11" % dottyVersion % "scala-tool"
    ),
    scalaCompilerBridgeSource := ("ch.epfl.lamp" % "dotty-bridge" % "0.1.1-SNAPSHOT" % "component").sources()
  )
