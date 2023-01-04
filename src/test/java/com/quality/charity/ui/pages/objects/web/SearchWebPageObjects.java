package com.quality.charity.ui.pages.objects.web;

import org.openqa.selenium.By;

public class SearchWebPageObjects {

    public static final By SEARCH_BOX = By.cssSelector("#nav-search-keywords");
    public static final By SEARCH_SUBMIT= By.cssSelector(".nav-search-submit");
    public static final By SEARCH_RESULT = By.xpath("//div[contains(@class, 's-search-results')]/div");

}
