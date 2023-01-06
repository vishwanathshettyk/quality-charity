package com.quality.charity.factory.remote;

import com.quality.charity.factory.constants.BrowserType;
import com.quality.charity.factory.constants.RunType;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;


@Component
public class DockerManager {

    @Autowired
    Environment environment;

    public WebDriver getDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "firefox");
        return new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
    }
}
