package com.quality.charity.ui.webdriver.factory.remote;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

@Component
public class LambdaTestManager {
    @Value("${appium.android.device.name}")
    public String appiumAndroidDeviceName;

    @Value("${appium.android.platform.name}")
    public String appiumAndroidPlatformName;

    @Value("${appium.android.automation.name}")
    public String appiumAndroidAutomationName;

    @Value("${appium.android.browser.name}")
    public String appiumAndroidBrowserName;

    @Value("${appium.server.url}")
    public String appiumServerUrl;

    DesiredCapabilities capabilities = new DesiredCapabilities();

    public WebDriver getDriver() throws MalformedURLException {

        LocalDate localDate = LocalDate.now();
        capabilities.setCapability("build", "SmokeTest-Chrome-" + localDate);
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("version", "92.0");
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("resolution","1024x768");
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console log

        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
