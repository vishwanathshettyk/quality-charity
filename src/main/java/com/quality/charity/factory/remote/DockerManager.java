package com.quality.charity.factory.remote;

import com.quality.charity.factory.constants.BrowserType;
import com.quality.charity.factory.constants.RunType;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;


@Component
public class DockerManager {

    @Value("${selenium.grid.hub.url}")
    private String seleniumGridUrl;

    @Value("{selenium.grid.browser}")
    private String seleniumGridBrowser;

    public WebDriver getDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", seleniumGridBrowser);
        return new RemoteWebDriver(new URL(seleniumGridUrl), capabilities);
    }
}
