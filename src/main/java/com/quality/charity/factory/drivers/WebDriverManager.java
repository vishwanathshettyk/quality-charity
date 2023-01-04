package com.quality.charity.factory.drivers;

import com.quality.charity.factory.constants.RunType;
import com.quality.charity.factory.constants.RunModeType;
import com.quality.charity.factory.local.LocalDriverFactory;
import com.quality.charity.factory.remote.RemoteDriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;

@Component
@Configuration
@PropertySource("classpath:application.properties")
@PropertySource("classpath:config.properties")
public class WebDriverManager {

    @Autowired
    Environment environment;

    @Autowired
    RemoteDriverFactory remoteDriverFactory;

    @Autowired
    LocalDriverFactory localDriverFactory;

    public WebDriver getDriver() throws MalformedURLException {

      String runMode = environment.getProperty(RunType.RUN_MODE.toString().toLowerCase());

      return runMode.equalsIgnoreCase(RunModeType.REMOTE.toString())
               ? remoteDriverFactory.getDriver()
               : localDriverFactory.getDriver();
    }
}
