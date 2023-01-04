package com.ing.thor.ui.webdriver.factory.drivers;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;

@Component
public class ApplicationSetup {

    @Autowired
    WebDriverManager webDriverManager;

    WebDriver driver;

    public void init(String scenarioName) throws MalformedURLException {
        driver  = webDriverManager.getDriver();
    }

    public WebDriver getDriver()
    {
        return  driver;
    }

}
