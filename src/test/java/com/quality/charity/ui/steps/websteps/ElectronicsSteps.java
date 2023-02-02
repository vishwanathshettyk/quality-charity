package com.quality.charity.ui.steps.websteps;

import com.quality.charity.ui.pages.web.ElectronicsWebPage;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class ElectronicsSteps implements En {

    @Autowired
    ElectronicsWebPage electronicsWebPage;

    public ElectronicsSteps(ElectronicsWebPage electronicsWebPage) {
        this.electronicsWebPage = electronicsWebPage;

        When("^click on electronic menu$", () -> {

            electronicsWebPage.clickOnElectronicMenu();
        });

        Then("^submenu are displayed$", () -> {
            Assert.assertTrue((long) electronicsWebPage.getSubmenuCount().size() > 0);
        });
    }
}
