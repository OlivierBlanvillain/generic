name := "generic"

version := "0.1-SNAPSHOT"

val dottyVersion       = "0.1-SNAPSHOT"
val dottyBridgeVersion = "0.1.1-SNAPSHOT"

// Dotty version
scalaVersion := dottyVersion
scalaOrganization := "ch.epfl.lamp"

// scalacOptions ++= Seq("")

// Dotty is compatible with Scala 2.11 as such you can use 2.11
// binaries. However when publishing - this version number should be set
// to 0.1 (the dotty version number)
scalaBinaryVersion := "2.11"

// Don't import the stdlib for "scalaBinaryVersion"
autoScalaLibrary := false

// Add resolver for Sonatype Snapshots
resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "com.novocode" % "junit-interface" % "0.11" % "test",

  // Dotty depends on stdlib 2.11.5 best use that too
  "ch.epfl.lamp" % "scala-library_2.11" % dottyVersion,

  // Compiler on tool path
  "ch.epfl.lamp" % "dotty_2.11" % dottyVersion % "scala-tool"
)

// Bridge which allows REPL and compilation via dotty
scalaCompilerBridgeSource := ("ch.epfl.lamp" % "dotty-bridge" % "0.1.1-SNAPSHOT" % "component").sources()
