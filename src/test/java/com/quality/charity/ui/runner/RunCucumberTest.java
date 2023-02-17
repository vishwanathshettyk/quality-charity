package com.quality.charity.ui.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "com.quality.charity", features = "src/test/resources")
public class RunCucumberTest {

}