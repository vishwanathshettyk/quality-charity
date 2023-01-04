package com.ing.thor.ui.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "com.ing.thor.ui.steps", features = "src/test/resources")
public class RunCucumberTest {

}