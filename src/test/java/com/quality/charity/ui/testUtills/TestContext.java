package com.quality.charity.ui.testUtills;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class TestContext {

    public Response response;
}
