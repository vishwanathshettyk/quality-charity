package com.quality.charity.factory.restassuredfactory;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RestResources {

    @Value("${api.base.uri}")
    private String baseUri;

    public RequestSpecification givenSecure()
    {
        RestAssured.baseURI = baseUri;
        RequestSpecification requestSpecification = RestAssured.given();
        return  requestSpecification.relaxedHTTPSValidation();
    }
}
