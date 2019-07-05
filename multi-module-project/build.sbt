name := "multi-module-project"

version := "0.1"

scalaVersion := "2.13.0"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.16"


lazy val root = (project in file(".")).aggregate(dboperation, operations,entities)
lazy val dboperation = (project in file("dboperation")).dependsOn(entities)
lazy val entities = project in file("entities")
lazy val operations = (project in file("operations")).dependsOn(dboperation)


