package com.quality.charity.apis.apisteps;

import com.quality.charity.factory.restassuredfactory.RestService;
import com.quality.charity.ui.testUtills.TestContext;
import cucumber.api.java8.En;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

public class ReqResApiSteps implements En {

    @Autowired
    private TestContext testContext;

    @Autowired
    RestService restService;

    private final String GET_CUSTOMER_ENDPOINT = "/api/users?page=2";
    public ReqResApiSteps() {

        When("^request submitted to response api$", () -> {

           Response response = restService.getRequest(GET_CUSTOMER_ENDPOINT);
           testContext.setResponse(response);
        });

    }
}
