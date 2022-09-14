package pages;

import com.project.ui_tests.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Log4Test;

import java.util.List;

/**
 * Created by sha256 on 7/17/2014.
 */

public class NotebooksPage extends GeneralPage {

    public int count = 0;
    protected WebElement pageNotebooks;
    List<WebElement> findManufacturers;
    private String URL = "http://rozetka.com.ua/notebooks/c80004/";

    public boolean isOpened() {

        Log4Test.info("Currently browsing: " + webDriver.getCurrentUrl());

        return webDriver.getCurrentUrl().equals(URL);
    }

    public WebElement verifyNotebooksTabIsActive() {

        Log4Test.info("Verifying that 'Notebooks, tablets and computers' tab is active");

        return pageNotebooks = elementIsLocated(getLocator("notebooksPageActive"));
    }

    public List<WebElement> listOfManufactures() {

        findManufacturers = webDriver.findElements(getLocator("manufacturersAll"));

        Log4Test.info("Manufacturers are located");

        return findManufacturers;
    }

    public int countManufacturers() {

        listOfManufactures();

        for (WebElement elem : findManufacturers) {

            count++;
        }

        Log4Test.info("There are " + count + " manufacturers on the list");

        return count;
    }

    public void clickOnApple() {

        for (int i = 1; i <= count; i++) {

            WebElement link = webDriver.findElement(By.xpath("//div[2]/div[3]//li[2]/ul/li[" + i + "]/a"));

//                    elementIsLocated(getLocator("manufacturersAll" + "[" + i + "]" + "/a"));

            if (link.getText().contains(TestData.vendor)) {

                link.click();

                Log4Test.info("Transferring to Apple page");

                break;
            }
        }
    }
}