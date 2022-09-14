package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.project.ui_tests.TestData;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static WebDriver webDriver;

    protected static WebDriverWait wait;

    @BeforeSuite
    public static void setUp() throws IOException

    {

        webDriver = WebDriverFactory.getWebDriver(TestData.BROWSER_NAME);

        wait = new WebDriverWait(webDriver, 45);

        webDriver.manage().window().maximize();

        webDriver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        webDriver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);

        webDriver.manage().timeouts().setScriptTimeout(45, TimeUnit.SECONDS);

    }


    @AfterSuite
    public void tearDown()

    {

        webDriver.quit();

    }

}