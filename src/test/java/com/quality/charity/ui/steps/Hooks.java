package com.quality.charity.ui.steps;

import com.quality.charity.factory.constants.BrowserType;
import com.quality.charity.factory.drivers.ApplicationSetup;
import com.quality.charity.factory.constants.RunType;
import com.quality.charity.factory.configs.SpringConfiguration;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

@ContextConfiguration(classes = {SpringConfiguration.class})
public class Hooks {

    @Autowired
    Environment environment;

    private ApplicationSetup applicationSetup;
    private static final String WEB = "web";
    private static final String API = "api";
    @Value("${target.url}")
    private String targetUrl;

    @Value("${run_platform}")
    private String runPlatform;

    @Autowired
    public Hooks(ApplicationSetup applicationSetup) {
        this.applicationSetup = applicationSetup;
    }

    @Before
    public void init(Scenario scenario) throws IOException, InterruptedException {

        if (!runPlatform.equalsIgnoreCase(WEB)) {
            if(runPlatform.equalsIgnoreCase(API)) {
                System.out.println("API Testing started");
            }
        } else {
           initiateWebDriver(scenario);
        }
    }

    private void  initiateWebDriver(Scenario scenario) throws MalformedURLException {
        applicationSetup.init(scenario.getName());
        applicationSetup.getDriver().get(targetUrl);
        applicationSetup.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @After
    public void tearDown(Scenario scenario) throws MalformedURLException {

        try {
            if(!runPlatform.equalsIgnoreCase("API"))
            {
                applicationSetup.getDriver().quit();
                if(environment.getProperty(RunType.TARGET_BROWSER.toString().toLowerCase()).equalsIgnoreCase(BrowserType.LAMBDA.toString()))
                {
                    this.sendStatusToLambda(scenario);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Driver instance is not available to quit");
        } catch (Exception e)
        {
            System.out.println("Exception occurred while closing driver");
            throw e;
        }
    }

    private void sendStatusToLambda(Scenario scenario)
    {
        JavascriptExecutor js  = (JavascriptExecutor) applicationSetup.getDriver();

        if(scenario.isFailed())
        {
            js.executeScript("lambda-status=failed");

        }else if(scenario.getStatus().toString().equalsIgnoreCase("Passed"))
        {
            js.executeScript("lambda-status=passed");

        }else
        {
            js.executeScript("lambda-status=failed");
        }
    }
}
