package webdriver.factory.remote;

import webdriver.factory.constants.BrowserType;
import webdriver.factory.constants.RunType;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;

@Component
public class RemoteDriverFactory {

    @Autowired
    Environment environment;

    @Autowired
    AppiumManager appiumManager ;

    @Autowired
    LambdaTestManager lambdaTestManager;

    public WebDriver getDriver() throws MalformedURLException {

        String browserType = environment.getProperty(RunType.TARGET_BROWSER.toString().toLowerCase());

        return  browserType.equalsIgnoreCase(BrowserType.LAMBDA.toString())
                ? lambdaTestManager.getDriver()
                : appiumManager.getDriver();
    }

}


