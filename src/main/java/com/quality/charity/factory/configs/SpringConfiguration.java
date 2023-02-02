package com.quality.charity.factory.configs;

import com.quality.charity.factory.restassuredfactory.RestAssuredImpl;
import com.quality.charity.factory.restassuredfactory.RestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.quality.charity", "com.quality.charity.ui"})
public class SpringConfiguration {

    @Bean
    public RestService getRestService(){ return  new RestAssuredImpl();
    }
}
