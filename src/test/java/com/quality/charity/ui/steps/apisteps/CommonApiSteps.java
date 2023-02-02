package com.quality.charity.ui.steps.apisteps;

import com.quality.charity.factory.restassuredfactory.RestService;
import com.quality.charity.ui.testUtills.TestContext;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonApiSteps implements En {


    @Autowired
    private TestContext testContext;


    public CommonApiSteps() {
        Then("^response status is (\\d+)$", (Integer statusCode) -> {
            testContext.getResponse().then().statusCode(statusCode);
        });
    }
}
