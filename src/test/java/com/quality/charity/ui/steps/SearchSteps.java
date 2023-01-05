package com.quality.charity.ui.steps;

import com.quality.charity.factory.constants.PlatformTypes;
import com.quality.charity.factory.constants.RunType;
import com.quality.charity.ui.pages.mobile.SearchMobilePage;
import com.quality.charity.ui.pages.web.SearchWebPage;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class SearchSteps implements En {

    final Environment environment;

    @Autowired
    SearchMobilePage searchMobilePage;

    @Autowired
    SearchWebPage searchWebPage;


    public SearchSteps(Environment environment) {
        this.environment = environment;

        final String PLATFORM_TYPE = this.environment.getProperty(RunType.RUN_PLATFORM.toString().toLowerCase());

        When("^enter a text \"([^\"]*)\" in search box$", (String searchString) -> {
            if(PLATFORM_TYPE.equalsIgnoreCase(PlatformTypes.MOBILE.toString()))
            {
                searchMobilePage.enterTextIntoSearchBox(searchString);
            }else
            {
                searchWebPage.enterTextIntoSearchBox(searchString);
            }
        });

        Then("^mobile phones are displayed$", () -> {

            int count = PLATFORM_TYPE.equalsIgnoreCase(PlatformTypes.MOBILE.toString())
                    ? searchMobilePage.getCountOfSearchResult()
                    : searchWebPage.getCountOfSearchResult();
            Assert.assertTrue(count>0);
        });
    }

}
