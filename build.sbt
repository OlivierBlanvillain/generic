val dottyVersion       = "0.1-SNAPSHOT"
val dottyBridgeVersion = "0.1.1-SNAPSHOT"

lazy val generic = project
  .enablePlugins(DottyPlugin)
  .settings(
    resolvers += Resolver.sonatypeRepo("snapshots"),
    libraryDependencies ++= Seq(
      "com.novocode" % "junit-interface" % "0.11" % "test",
      "ch.epfl.lamp" % "scala-library_2.11" % dottyVersion,
      "ch.epfl.lamp" % "dotty_2.11" % dottyVersion % "scala-tool"
    )
  )

lazy val `jmh-bench` = project
  .enablePlugins(JmhPlugin)
  .settings(
    scalaVersion := "2.11.1",
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-Xlint"),
    libraryDependencies += "com.storm-enroute" %% "scalameter" % "0.8.1" % "test",
    testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework"),
    parallelExecution in Test := false,
    logBuffered := false
  )

lazy val `code-gen` = project.settings(scalaVersion := "2.11.1")
