import AssemblyKeys._ // put this at the top of the file

assemblySettings

name := "citedown"

version := "1.2.1"

homepage := Some(new URL("http://pegdown.org"))

organization := "edu.harvard.chs.citedown"

organizationHomepage := Some(new URL("http://pegdown.org"))

description := "A Java 1.5+ library providing a clean and lightweight markdown processor"

startYear := Some(2009)

licenses := Seq("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))

javacOptions ++= Seq(
  "-g", // required for byte-code rewriting in parboiled-java!
  "-deprecation",
  "-target", "1.5",
  "-source", "1.5",
  "-encoding", "utf8",
  "-Xlint:unchecked"
)

javacOptions in doc := Seq(
  "-source", "1.5",
  "-encoding", "utf8"
)

scalaVersion := "2.9.2"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies   ++= Seq(
  "org.parboiled" % "parboiled-java" % "1.1.4",
  "net.sf.jtidy" % "jtidy" % "r938" % "test",
  "org.specs2" %% "specs2" % "1.12.2" % "test"
)

resolvers += Opts.resolver.sonatypeReleases

// publishing

crossPaths := false

autoScalaLibrary := false

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

useGpg := true

pgpSigningKey := Some(-2321133875171851978L)

publishTo <<= version { v: String =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
  else                             Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

pomExtra :=
  <scm>
    <url>git@github.com:ryanfb/pegdown.git</url>
    <connection>scm:git:git@github.com:ryanfb/pegdown.git</connection>
  </scm>
  <developers>
    <developer>
      <id>sirthias</id>
      <name>Mathias Doenitz</name>
    </developer>
  </developers>
