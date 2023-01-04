package com.quality.charity.ui.webdriver.factory.local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

@Component
public class FireFoxManager {

    public WebDriver getDriver()
    {
        return new FirefoxDriver();
    }

}
