package com.quality.charity.factory.restassuredfactory;

import io.restassured.response.Response;

public interface RestService {
        Response getRequest(String path);
        Response postRequest(String path,String body);
}
