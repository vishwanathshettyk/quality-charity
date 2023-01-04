package com.quality.charity.ui.pages;

import com.quality.charity.factory.constants.RunType;
import com.quality.charity.factory.drivers.ApplicationSetup;
import com.quality.charity.ui.pages.objects.mobile.SearchMobilePageObjects;
import com.quality.charity.ui.pages.objects.web.SearchWebPageObjects;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
public class SearchPage {

    @Autowired
    ApplicationSetup applicationSetup;

    public void enterTextIntoSearchBox(String value)
    {
        if(RunType.RUN_PLATFORM_TYPE.toString().equalsIgnoreCase("MOBILE"))
        {
            applicationSetup.getDriver().findElement(SearchMobilePageObjects.SEARCH_BOX).sendKeys(value);
            applicationSetup.getDriver().findElement(SearchMobilePageObjects.SEARCH_SUBMIT).click();
        }
        {
            applicationSetup.getDriver().findElement(SearchWebPageObjects.SEARCH_BOX).sendKeys(value);
            applicationSetup.getDriver().findElement(SearchWebPageObjects.SEARCH_SUBMIT).click();
        }

    }

    public int getCountOfSearchResult()
    {
       return applicationSetup.getDriver().findElements(SearchMobilePageObjects.SEARCH_RESULT).size();
    }

}
