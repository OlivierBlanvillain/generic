val dottyVersion       = "0.1-SNAPSHOT"
val dottyBridgeVersion = "0.1.1-SNAPSHOT"

lazy val generic = project
  .enablePlugins(DottyPlugin)
  .settings(
    resolvers += Resolver.sonatypeRepo("snapshots"),
    libraryDependencies ++= Seq(
      "com.novocode" % "junit-interface" % "0.11" % "test"
    )
  )

lazy val `jmh-bench` = project
  .enablePlugins(JmhPlugin)
  .settings(
    scalaVersion := "2.11.1",
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-Xlint"),
    parallelExecution in Test := false,
    logBuffered := false
  )

lazy val `code-gen` = project.settings(scalaVersion := "2.11.1")

addCommandAlias("validate", ";clean ;code-gen/run ;generic/test:run ;jmh-bench/jmh:run -i 1 -wi 1 -f 0 -foe true -bm SingleShotTime")
