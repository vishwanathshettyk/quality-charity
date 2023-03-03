package com.quality.charity.perf.simulation;

import com.quality.charity.factory.configs.SpringConfiguration;
import com.quality.charity.perf.reusables.GatlingBuilder;
import com.quality.charity.perf.reusables.GatlingConstants;
import io.gatling.javaapi.core.Simulation;
import org.springframework.test.context.ContextConfiguration;

import static io.gatling.javaapi.core.CoreDsl.rampUsers;

@ContextConfiguration(classes = {SpringConfiguration.class})
public class PersonalLoanSimulation extends Simulation
{
    GatlingBuilder gatlingBuilder = new GatlingBuilder();
    public PersonalLoanSimulation() {
        {
            setUp(
                    gatlingBuilder.scenarioBuilder().injectOpen(rampUsers(GatlingConstants.RAMP_USER)
                            .during(GatlingConstants.TEST_DURATION))
            ).protocols(gatlingBuilder.httpProtocolBuilder());
        }

    }
}
