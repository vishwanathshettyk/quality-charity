package com.quality.charity.perf.simulation;

import com.quality.charity.perf.reusables.GatlingConstants;
import com.quality.charity.perf.reusables.GatlingService;
import io.gatling.javaapi.core.Simulation;

import static io.gatling.javaapi.core.CoreDsl.global;
import static io.gatling.javaapi.core.CoreDsl.rampUsers;

public class GetUserListPerfTest extends Simulation
{
    GatlingService gatlingBuilder = new GatlingBuilderImpl();

    public GetUserListPerfTest() {
        {
            setUp(
                    gatlingBuilder.scenarioBuilder()
                            .injectOpen(rampUsers(GatlingConstants.RAMP_USER).during(GatlingConstants.TEST_DURATION)))
                            .assertions(global().responseTime().max().lt(500))
                            .protocols(gatlingBuilder.httpProtocolBuilder());
        }

    }
}
