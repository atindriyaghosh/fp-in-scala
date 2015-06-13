name := """fp-in-scala"""

version := "1.0"

scalaVersion := "2.11.6"

autoScalaLibrary := false

crossPaths := false

EclipseKeys.withSource := true

EclipseKeys.withJavadoc := true

libraryDependencies ++= Seq(
                        "org.scala-lang" % "scala-compiler" % "2.11.6" withSources() withJavadoc(), 
                        "org.scala-lang" % "scala-library" % "2.11.6" withSources() withJavadoc(),
                        "org.scala-lang" % "scala-reflect" % "2.11.6" withSources() withJavadoc(),
                        "org.scalatest" %% "scalatest" % "2.2.4" % "test" withSources() withJavadoc()
                        )

fork in run := true