package com.quality.charity.factory.local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

@Component
public class EdgeManager {

    public static WebDriver getDriver()
    {
        return new EdgeDriver();
    }

}
