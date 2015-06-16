name := "address-book-java"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "joda-time" % "joda-time" % "2.8.1"
)     

play.Project.playJavaSettings
