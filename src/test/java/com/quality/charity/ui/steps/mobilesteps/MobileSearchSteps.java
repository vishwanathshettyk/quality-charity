package com.quality.charity.ui.steps.mobilesteps;

import com.quality.charity.factory.drivers.ApplicationSetup;
import com.quality.charity.ui.pages.SearchPage;
import cucumber.api.java8.En;
import org.junit.Assert;

public class MobileSearchSteps extends SearchPage implements En {

    private final ApplicationSetup applicationSetup;


    public MobileSearchSteps(ApplicationSetup applicationSetup) {
        this.applicationSetup = applicationSetup;

        When("^enter a text \"([^\"]*)\" in search box$", (String searchString) -> {

            this.enterTextIntoSearchBox("Mobile");
        });

        Then("^mobile phones are displayed$", () -> {

            int count = this.getCountOfSearchResult();
            Assert.assertTrue(count>0);
        });
    }

}
