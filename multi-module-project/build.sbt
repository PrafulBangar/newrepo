name := "multi-module-project"

version := "0.1"

scalaVersion in ThisBuild := "2.13.0"

organization in ThisBuild := "com.group"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.16"


lazy val root = (project in file("."))
  .aggregate(dboperation, operations,entities)
  .dependsOn(operations, dboperation,entities)
  .settings(name := "root")
lazy val dboperation = (project in file("dboperation"))
  .aggregate(entities)
  .dependsOn(entities)
lazy val entities = (project in file("entities"))
    .settings(name := "entities")
lazy val operations = (project in file("operations"))
  .dependsOn(dboperation)
  .aggregate(dboperation)
  .settings(name := "operations")


