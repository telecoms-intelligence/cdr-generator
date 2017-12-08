name := "CDR-Generator"

version := "1.0"

scalaVersion := "2.11.8"

checksums in update := Nil

libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.16.0"

libraryDependencies += "org.specs2" %% "specs2-core" % "3.9.4" % "test"

// Hadoop
//libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "2.8.1"
//libraryDependencies += "org.apache.hadoop" % "hadoop-hdfs" % "2.8.1"
//libraryDependencies += "org.apache.hadoop" % "hadoop-yarn-client" % "2.8.1"

// Spark
val sparkVersion = "2.2.0"
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-mllib" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-hive" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-graphx" % sparkVersion

libraryDependencies += "joda-time" % "joda-time" % "2.3"

libraryDependencies += "org.joda" % "joda-convert" % "1.2"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"

scalacOptions in (Compile, doc) ++= Seq("-doc-root-content", baseDirectory.value+"/NOTE.md")

scalacOptions in (Compile, doc) ++= Seq("-doc-title", "CDR Generator")

scalacOptions ++= Seq("-deprecation", "-feature")

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snaspshots"),
  "Local repository"     at "http://localhost/mavenrepo/",
  "Akka Repository" at "http://repo.akka.io/release/",
  Resolver.mavenLocal
)

javacOptions in Compile ++= Seq("-source", "1.8",  "-target", "1.8")

publishTo := Some("TI Maven Repo" at "http://localhost/mavenrepo/")

cleanKeepFiles += target.value / "test-reports"


