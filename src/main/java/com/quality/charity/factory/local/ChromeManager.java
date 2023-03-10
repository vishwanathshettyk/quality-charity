package com.quality.charity.factory.local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

@Component
public class ChromeManager {


    public static WebDriver getDriver()
    {
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless","--disable-dev-shm-usage");
        return new ChromeDriver(options);
    }

}