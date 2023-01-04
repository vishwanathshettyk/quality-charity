package com.ing.thor.ui.pages;

import org.openqa.selenium.By;

public class SearchPageObjects {


    public By SEARCH_BOX = By.cssSelector("#nav-search-keywords");
    public By SEARCH_SUBMIT= By.cssSelector(".nav-search-submit");
    public By SEARCH_RESULT = By.xpath("//div[contains(@class, 's-search-results')]/div");

}
