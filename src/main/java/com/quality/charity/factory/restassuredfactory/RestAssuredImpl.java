package com.quality.charity.factory.restassuredfactory;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

public class RestAssuredImpl implements RestService{

    @Autowired
    RestResources restResources;

    @Override
    public Response getRequest(String path) {

        return restResources.givenSecure()
                .contentType(ApiConstants.APPLICATION_JSON.getValue())
                .when()
                .get(path)
                .then().log().all().extract().response();
    }

    @Override
    public Response postRequest(String path, String body) {
        return restResources.givenSecure()
                .contentType(ApiConstants.APPLICATION_JSON.getValue())
                .when()
                .body(body)
                .post(path)
                .then().log().all().extract().response();
    }
}
