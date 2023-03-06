package com.quality.charity.perf.reusables;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.http.HttpProtocolBuilder;

public interface GatlingService {

    ScenarioBuilder scenarioBuilder();

    HttpProtocolBuilder httpProtocolBuilder();
}
