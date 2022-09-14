package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Log4Test;

/**
 * Created by y.starynets on 7/17/2014.
 */

public class ComparisonPage extends GeneralPage {

String URL = "http://rozetka.com.ua/computers-notebooks/notebooks/comparison/ids=338650%2C699984/";
private WebElement webElement;

    public boolean isOpened() {

    Log4Test.info("Currently browsing: " + webDriver.getCurrentUrl());

    return webDriver.getCurrentUrl().equals(URL);
    }

    public WebElement verifyReallyCustom() {

    webElement = elementIsLocated(getLocator("reallyCustom"));

    return webElement;
    }

    public WebElement verifyReallyRegular() {

        webElement = elementIsLocated(getLocator("reallyRegular"));

        return webElement;
    }
}