package com.ing.thor.ui.steps.mobilesteps;

import com.ing.thor.ui.pages.SearchPage;
import com.ing.thor.ui.utilities.Context;
import com.ing.thor.ui.utilities.DataLoader;
import com.ing.thor.ui.webdriver.factory.drivers.ApplicationSetup;
import cucumber.api.java8.En;
import org.junit.Assert;

public class MobileSearchSteps extends SearchPage implements En {

    private final ApplicationSetup applicationSetup;
    private  final DataLoader dataLoader;
    private final Context context;


    public MobileSearchSteps(ApplicationSetup applicationSetup, DataLoader dataLoader, Context context) {
        this.applicationSetup = applicationSetup;
        this.dataLoader = dataLoader;
        this.context = context;

        When("^enter a text \"([^\"]*)\" in search box$", (String searchString) -> {

            this.enterTextIntoSearchBox("Mobile");
        });

        Then("^mobile phones are displayed$", () -> {

            int count = this.getCountOfSearchResult();
            Assert.assertTrue(count>0);
        });
    }

}
