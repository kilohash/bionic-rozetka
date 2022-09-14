package pages;

import org.openqa.selenium.By;
import utils.Log4Test;
import org.openqa.selenium.WebElement;

/**
 * Created by sha256 on 7/17/2014.
 */

public class ApplePage extends GeneralPage {

    private String URL = "http://rozetka.com.ua/notebooks/apple/c80004/v069/";
    private WebElement webElement;

    public boolean isOpened() {

        Log4Test.info("Currently browsing: " + webDriver.getCurrentUrl());

        return webDriver.getCurrentUrl().equals(URL);
    }

    public void clickSortDropdown() {

        webElement = elementIsLocated(getLocator("sortDropdown"));

        webElement.click();
    }

    public void clickSortDesc() {

        clickSortDropdown();

        webElement = elementIsLocated(getLocator("sortPriceDesc"));

        webElement.click();

        Log4Test.info("Sort by Price in Descending order");
    }

    public WebElement searchCustomMac() {

        Log4Test.info("Searching for Apple MacBook Pro Retina 15 Z0PU002JE");

        return webElement = elementIsLocated(getLocator("customMac"));
    }

    public WebElement searchRegularMac() {

        Log4Test.info("Searching for Apple MacBook Pro Retina 15 ME294UA/A");

        return webElement = elementIsLocated(getLocator("regularMac"));
    }

    public void selectCustomMacAndAddToComparison() {

        webElement = webDriver.findElement(By.xpath("//div[@class='gtile-i-title']/a[@href='http://rozetka.com.ua/apple_macbook_pro_retina_15_z0pu002je/p699984/']/../..//span[@class='lightblue xhr']"));

//        webElement = elementIsLocated(getLocator("addCustomMac"));

        if (!webElement.getText().contains("checked")) {

            javaScriptClick("//div[@class='gtile-i-title']/a[@href='http://rozetka.com.ua/apple_macbook_pro_retina_15_z0pu002je/p699984/']/../..//span[@class='lightblue xhr']");

            Log4Test.info("Apple Mac Book Pro Retina 15 Z0PU002JE was added to comparison");
        }

        else {

            Log4Test.info("Z0PU002JE has been already added to comparison");
        }

//        return webElement = webDriver.findElement(getLocator("comparisonBox"));
    }

    public WebElement verifyCustomIsInComparison() {

        webElement = elementIsLocated(getLocator("comparisonBoxCustom"));

        return webElement;
    }

    public void selectRegularMacAndAddToComparison() {

        webElement = webDriver.findElement(By.xpath("//div[@class='gtile-i-title']/a[@href='http://rozetka.com.ua/apple_macbook_pro_retina_15_me294ua_a/p338650/']/../..//span[@class='lightblue xhr']"));

//        webElement = elementIsLocated(getLocator("addRegularMac"));

        if (!webElement.getText().contains("checked")) {

//            webElement = elementIsLocated(getLocator("addRegularMac"));

            javaScriptClick("//div[@class='gtile-i-title']/a[@href='http://rozetka.com.ua/apple_macbook_pro_retina_15_me294ua_a/p338650/']/../..//span[@class='lightblue xhr']");

            Log4Test.info("Apple MacBook Pro Retina 15 ME294UA/A was added to comparison");
        }

        else {

            Log4Test.info("ME294UA/A has been already added to comparison");
        }

//        return webElement = webDriver.findElement(getLocator("comparisonBox"));
    }

    public WebElement verifyRegularIsInComparison() {

        webElement = elementIsLocated(getLocator("comparisonBoxRegular"));

        return webElement;
    }

    public void goToComparisonPage() {

        webElement = elementIsLocated(getLocator("comparisonButton"));

        webElement.click();

        Log4Test.info("Transferring to Comparison Page");
    }
}