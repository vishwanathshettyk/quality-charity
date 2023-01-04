package com.quality.charity.factory.local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

@Component
public class ChromeManager {

    public static WebDriver getDriver()
    {
        return new ChromeDriver();
    }

}
