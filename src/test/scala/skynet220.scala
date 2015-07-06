package mvelez

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class skynet220 extends Simulation {

	val httpProtocol = http
		.baseURL("http://127.0.0.1:8080")
		.inferHtmlResources()

	val headers_2 = Map("Accept" -> "image/png,image/*;q=0.8,*/*;q=0.5")

    val uri1 = "http://127.0.0.1:8080/jenkins"

	val scn = scenario("skynet220")
		.exec(http("request_0")
			.get("/jenkins/")
			.resources(http("request_1")
			.get(uri1 + "/login?from=%2Fjenkins%2F"),
            http("request_2")
			.get(uri1 + "/adjuncts/a8bb1275/lib/layout/menu_right_arrow.png")
			.headers(headers_2))
			.check(status.is(403)))

	setUp(scn.inject(constantUsersPerSec(1) during(600 seconds))).protocols(httpProtocol)
}
