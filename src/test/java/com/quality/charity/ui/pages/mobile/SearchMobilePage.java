package com.quality.charity.ui.pages.mobile;

import com.quality.charity.factory.drivers.ApplicationSetup;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SearchMobilePage {

    @Autowired
    ApplicationSetup applicationSetup;

    @Autowired
    Environment environment;

    public static final By SEARCH_BOX = By.cssSelector("#nav-search-keywords");
    public static final By SEARCH_SUBMIT= By.cssSelector(".nav-search-submit");
    public static final By SEARCH_RESULT = By.xpath("//div[contains(@class, 's-search-results')]/div");

    public void enterTextIntoSearchBox(String value)
    {

        {
            applicationSetup.getDriver().findElement(SEARCH_BOX).sendKeys(value);
            applicationSetup.getDriver().findElement(SEARCH_SUBMIT).click();
        }

    }

    public int getCountOfSearchResult()
    {
       return applicationSetup.getDriver().findElements(SEARCH_RESULT).size();
    }

}
