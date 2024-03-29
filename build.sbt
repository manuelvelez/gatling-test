enablePlugins(GatlingPlugin)

scalaVersion := "2.11.7"

scalacOptions := Seq(
  "-encoding", "UTF-8", "-target:jvm-1.7", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.1.6" % "test"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "2.1.6" % "test"
