package com.quality.charity.perf.reusables;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import org.springframework.stereotype.Component;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;

@Component
public class GatlingBuilder extends Simulation {

    ChainBuilder country;
    HttpProtocolBuilder httpProtocol;
    ScenarioBuilder users;
    String baseUrl = "https://reqres.in/";
    final String    USER_LIST = "api/users?page=2";

    public ScenarioBuilder scenarioBuilder()
    {
        country = exec(http("country").get(USER_LIST)).pause(1);
        return  scenario("Users").exec(country);
    }

    public HttpProtocolBuilder httpProtocolBuilder()
    {
      return  httpProtocol =
                http.baseUrl(baseUrl)
                        .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                        .acceptLanguageHeader("en-US,en;q=0.5")
                        .acceptEncodingHeader("gzip, deflate")
                        .userAgentHeader(
                                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0"
                        );
    }
}
