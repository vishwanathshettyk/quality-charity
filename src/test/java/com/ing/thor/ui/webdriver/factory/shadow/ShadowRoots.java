package com.ing.thor.ui.webdriver.factory.shadow;

import com.ing.thor.ui.webdriver.factory.drivers.ApplicationSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShadowRoots implements ShadowService{

    @Autowired
    ApplicationSetup applicationSetup;

    private final By MAIN_BODY_MEAN_TESTER = By.cssSelector("body ing-app-tpa-means-tester");
    private final By TPA_MEANS_PAGE = By.cssSelector("[data-tag-name='ing-app-tpa-identification-means-page']");
    private final By ING_FEAT_AUTH = By.cssSelector("[data-tag-name='ing-feat-authentication']");
    private final By ORANGE_IT_IDENTIFICATION = By.cssSelector("ing-orange-it-identification");
    private final By PIN_PAD = By.cssSelector("ing-app-tpa-pinpad-means-page");

    @Override
    public WebElement getIdentificationShadowRoot() {
        return applicationSetup.getDriver().findElement(MAIN_BODY_MEAN_TESTER)
                .getShadowRoot().findElement(TPA_MEANS_PAGE)
                .getShadowRoot().findElement(ING_FEAT_AUTH)
                .getShadowRoot().findElement(ORANGE_IT_IDENTIFICATION);
    }

    @Override
    public WebElement getPinPadShadowRoot() {
        return applicationSetup.getDriver().findElement(MAIN_BODY_MEAN_TESTER)
                .getShadowRoot().findElement(TPA_MEANS_PAGE)
                .getShadowRoot().findElement(ING_FEAT_AUTH)
                .getShadowRoot().findElement(PIN_PAD);    }

    /**
     *
     */
    public void click(By by)
    {
        WebElement webElement = applicationSetup.getDriver().findElement(by);
        getJSExecutor().executeScript("arguments[0].click();", webElement);
    }

    public void sendKeys(By element, String textToFill)
    {

    }

    private JavascriptExecutor getJSExecutor()
    {
        JavascriptExecutor js  = (JavascriptExecutor) applicationSetup.getDriver();
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
        return js;
    }
}
