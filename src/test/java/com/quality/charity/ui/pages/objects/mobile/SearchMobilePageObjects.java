package com.quality.charity.ui.pages.objects.mobile;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class SearchMobilePageObjects {

    public static final By SEARCH_BOX = By.cssSelector("#nav-search-keywords");
    public static final By SEARCH_SUBMIT= By.cssSelector(".nav-search-submit");
    public static final By SEARCH_RESULT = By.xpath("//div[contains(@class, 's-search-results')]/div");

}
