resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"
resolvers += "cubyte-snapshot" at "https://maven.cubyte.org/repository/snapshots/"

// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.8")

// web plugins
addSbtPlugin("com.typesafe.sbt" % "sbt-less"   % "1.1.2")
addSbtPlugin("com.typesafe.sbt" % "sbt-gzip" % "1.0.2")
addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.3")

// build
addSbtPlugin("de.gccc.sbt" % "sbt-jib" % "0.9.2-credentials-fix1")
