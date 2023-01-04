package com.quality.charity.factory.local;

import com.quality.charity.factory.constants.BrowserType;
import com.quality.charity.factory.constants.RunType;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;

@Component
public class LocalDriverFactory {

    @Autowired
    Environment environment;
     private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();

     static {
         MAP.put(BrowserType.CHROME.toString(),ChromeManager::getDriver);
         MAP.put(BrowserType.FIREFOX.toString(),FireFoxManager::getDriver);
         MAP.put(BrowserType.EDGE.toString(),EdgeManager::getDriver);
     }
    public WebDriver getDriver()
    {
        String browserType = environment.getProperty(RunType.TARGET_BROWSER.toString().toLowerCase());
        return MAP.get(browserType.toUpperCase()).get();
    }
}
