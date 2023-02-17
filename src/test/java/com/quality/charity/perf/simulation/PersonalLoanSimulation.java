package com.quality.charity.perf.simulation;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.core.CoreDsl.rampUsers;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class PersonalLoanSimulation extends Simulation
{

    String baseUrl = "https://172-32-74-94.lendapi-tst.pod.dcr.non-prod.ichp.ing.net:8443";
    final String GET_COUNTRY_LIST = "/v1/personal-loan/solution-selling/lookup/countries";

    ChainBuilder country =
            exec(http("country").get(GET_COUNTRY_LIST))
                    .pause(1);

    HttpProtocolBuilder httpProtocol =
            http.baseUrl(baseUrl)
                    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                    .acceptLanguageHeader("en-US,en;q=0.5")
                    .acceptEncodingHeader("gzip, deflate")
                    .userAgentHeader(
                            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0"
                    );

    ScenarioBuilder users = scenario("Users").exec(country);

    {
        setUp(
                users.injectOpen(rampUsers(10).during(10))
        ).protocols(httpProtocol);
    }


}
