val pluginVersion = sys.props.getOrElse(
  "plugin.version",
  throw new RuntimeException(
    """|The system property 'plugin.version' is not defined.
       |Specify this property using the scriptedLaunchOpts -D.""".stripMargin))

addSbtPlugin("org.scoverage" % "sbt-scoverage" % pluginVersion)

resolvers ++= {
  if (pluginVersion.endsWith("-SNAPSHOT"))
    Seq(Resolver.sonatypeRepo("snapshots"))
  else
    Seq.empty
}

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.5.1")

addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.0.0")
