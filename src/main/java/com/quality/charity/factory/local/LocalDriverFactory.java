package com.quality.charity.factory.local;

import com.quality.charity.factory.constants.BrowserType;
import com.quality.charity.factory.constants.RunType;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class LocalDriverFactory {

   @Autowired
    Environment environment;

    @Autowired
    FireFoxManager fireFoxManager;

    @Autowired
    ChromeManager chromeManager;

    public WebDriver getDriver()
    {
        String browserType = environment.getProperty(RunType.TARGET_BROWSER.toString().toLowerCase());

        return browserType.equalsIgnoreCase(BrowserType.FIREFOX.toString())
                ? fireFoxManager.getDriver()
                : chromeManager.getDriver();
    }
}
