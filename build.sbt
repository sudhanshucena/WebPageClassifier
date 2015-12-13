
name := "WebSiteClassifier"

version := "1.0"

scalaVersion := "2.11.7"

//scalaHome := Some(file("/usr/lib/scala-2.11.7"))

//unmanagedJars in Compile += file("/home/sudhanshu/Desktop/SparkCount/target/scala-2.11/nekohtml-1.9.22.jar")

libraryDependencies ++= Seq("org.apache.spark" % "spark-core_2.11" % "1.5.2" % "provided",
  "org.scalatest" % "scalatest_2.11" % "3.0.0-M12" % "provided",
  "org.apache.spark" % "spark-mllib_2.11" % "1.5.2" % "provided",
  "xerces" % "xercesImpl" % "2.11.0",

  "de.l3s.boilerpipe" % "boilerpipe" % "1.1.0"
)

assemblyJarName in assembly := "WebSiteClassifier.jar"

test in assembly := {}

assemblyMergeStrategy in assembly := {
  case PathList("javax", "servlet", xs @ _*)         => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
// case PathList("org.cyberneko.html.HTMLElements.Element")   => MergeStrategy.first
  case "application.conf"                            => MergeStrategy.concat
  case "unwanted.txt"                                => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

