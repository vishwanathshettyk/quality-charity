package com.quality.charity.factory.remote;

import com.quality.charity.factory.constants.RunType;
import com.quality.charity.factory.constants.BrowserType;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Component
public class RemoteDriverFactory {

    @Autowired
    Environment environment;

    @Autowired
    AppiumManager appiumManager ;

    @Autowired
    LambdaTestManager lambdaTestManager;

    @Autowired
    DockerManager dockerManager;

    public WebDriver getDriver() throws MalformedURLException {

        String browserType = environment.getProperty(RunType.TARGET_BROWSER.toString().toLowerCase());

        if(browserType.equalsIgnoreCase(BrowserType.DOCKER.toString()))
        {
            return dockerManager.getDriver();
        }
        return  browserType.equalsIgnoreCase(BrowserType.LAMBDA.toString())
                ? lambdaTestManager.getDriver()
                : appiumManager.getDriver();
    }

}


