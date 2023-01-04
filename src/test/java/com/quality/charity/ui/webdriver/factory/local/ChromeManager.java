package com.quality.charity.ui.webdriver.factory.local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

@Component
public class ChromeManager {

    public WebDriver getDriver()
    {
        return new ChromeDriver();
    }

}
