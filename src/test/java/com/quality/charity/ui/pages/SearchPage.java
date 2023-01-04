package com.quality.charity.ui.pages;

import com.quality.charity.ui.webdriver.factory.drivers.ApplicationSetup;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchPage {


    @Autowired
    ApplicationSetup applicationSetup;

    private final By SEARCH_BOX = By.cssSelector("#nav-search-keywords");
    private final By SEARCH_SUBMIT= By.cssSelector(".nav-search-submit");
    private final By SEARCH_RESULT = By.xpath("//div[contains(@class, 's-search-results')]/div");


    public void enterTextIntoSearchBox(String value)
    {
        applicationSetup.getDriver().findElement(SEARCH_BOX).sendKeys(value);
        applicationSetup.getDriver().findElement(SEARCH_SUBMIT).click();
    }

    public int getCountOfSearchResult()
    {
       return applicationSetup.getDriver().findElements(SEARCH_RESULT).size();
    }

}
