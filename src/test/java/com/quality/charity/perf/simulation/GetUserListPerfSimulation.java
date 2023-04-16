package com.quality.charity.perf.simulation;

import com.quality.charity.perf.reusables.GatlingConstants;
import com.quality.charity.perf.reusables.GatlingFactory;
import io.gatling.javaapi.core.Simulation;
import org.testng.annotations.Test;

import static io.gatling.javaapi.core.CoreDsl.global;
import static io.gatling.javaapi.core.CoreDsl.rampUsers;

public class GetUserListPerfSimulation extends Simulation
{
    GatlingFactory gatlingFactory = new GatlingFactory();

//    public GetUserListPerfTest() {
//        {
//           GatlingBuilderImpl gatlingBuilder = (GatlingBuilderImpl) gatlingFactory.getGatling(GetUserListPerfTest.class.getSimpleName());
//            setUp(
//                    gatlingBuilder.scenarioBuilder()
//                            .injectOpen(rampUsers(GatlingConstants.RAMP_USER).during(GatlingConstants.TEST_DURATION)))
//                            .assertions(global().responseTime().max().lt(500))
//                            .protocols(gatlingBuilder.httpProtocolBuilder());
//        }
//
//    }

    @Test
    public void runTest()
    {
        GatlingBuilderImpl gatlingBuilder = (GatlingBuilderImpl) gatlingFactory.getGatling(GetUserListPerfSimulation.class.getSimpleName());

        setUp(
                gatlingBuilder.scenarioBuilder()
                        .injectOpen(rampUsers(GatlingConstants.RAMP_USER).during(GatlingConstants.TEST_DURATION)))
                .assertions(global().responseTime().max().lt(500))
                .protocols(gatlingBuilder.httpProtocolBuilder());
    }
}
