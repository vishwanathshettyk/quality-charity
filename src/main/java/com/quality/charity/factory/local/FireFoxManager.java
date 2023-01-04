package com.quality.charity.factory.local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

@Component
public class FireFoxManager {

    public WebDriver getDriver()
    {
        return new FirefoxDriver();
    }

}
