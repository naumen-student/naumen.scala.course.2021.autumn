name := "homework_3"

version := "0.1"

scalaVersion := "2.12.10"

libraryDependencies += "com.lihaoyi" %% "utest" % "0.5.3" % "test" % "org.scala-lang" % "scala-reflect" % "2.12.10"

testFrameworks += new TestFramework("utest.runner.Framework")