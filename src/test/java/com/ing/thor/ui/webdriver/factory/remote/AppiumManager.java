package com.ing.thor.ui.webdriver.factory.remote;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class AppiumManager {

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

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,appiumAndroidPlatformName);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, appiumAndroidDeviceName);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,appiumAndroidAutomationName);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,appiumAndroidBrowserName);
        return new AndroidDriver(new URL(appiumServerUrl), capabilities);
    }
}
