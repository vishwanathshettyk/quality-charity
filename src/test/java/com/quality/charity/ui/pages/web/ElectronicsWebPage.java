package com.quality.charity.ui.pages.web;

import com.quality.charity.factory.drivers.ApplicationSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ElectronicsWebPage {

    @Autowired
    ApplicationSetup applicationSetup;

    public static final By ELECTRONIC_MENU= By.xpath("//li[contains(@class, 'apb-browse-refinements-indent-2')]");
    public static final By SUB_MENU_LIST= By.cssSelector("#nav-xshop a[data-csa-c-content-id='nav_cs_electronics']");


    public void clickOnElectronicMenu()
    {
        applicationSetup.getDriver().findElement(ELECTRONIC_MENU).click();
    }

    public List<WebElement> getSubmenuCount()
    {
        return  applicationSetup.getDriver().findElements(SUB_MENU_LIST);
    }
}
