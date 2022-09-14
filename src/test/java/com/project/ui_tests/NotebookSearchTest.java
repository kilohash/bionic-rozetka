package com.project.ui_tests;

import pages.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NotebookSearchTest extends GeneralPage {

    HomePage homePage = new HomePage();
    NotebooksPage notebooksPage = new NotebooksPage();
    ApplePage applePage = new ApplePage();
    ComparisonPage comPage = new ComparisonPage();

    @Test
    public void setUpPreconditions() {

        homePage.open(TestData.ROZETKA_URL);

        assertTrue(homePage.isOpened(TestData.ROZETKA_URL));
    }

    @Test(dependsOnMethods = {"setUpPreconditions"})

    public void SearchAndCompareNotebooks() {

        homePage.goToNotebooks();

        notebooksPage.isOpened();

        assertTrue(notebooksPage.verifyNotebooksTabIsActive().getAttribute("class").contains("m-main-i active"));

        assertEquals(notebooksPage.countManufacturers(), TestData.expectedSize);

        notebooksPage.clickOnApple();

        applePage.isOpened();

        assertTrue(elementIsLocated(getLocator("reallyApple")).getText().contains(TestData.pageA));

        applePage.clickSortDropdown();

        waitForPageLoaded(webDriver);

        applePage.clickSortDesc();

        waitForPageLoaded(webDriver);

        applePage.searchRegularMac();

        waitForPageLoaded(webDriver);

        applePage.selectRegularMacAndAddToComparison();

        waitForPageLoaded(webDriver);

        applePage.searchCustomMac();

        waitForPageLoaded(webDriver);

        applePage.selectCustomMacAndAddToComparison();

        assertTrue(applePage.verifyCustomIsInComparison().getText().contains(TestData.Z0PU002JE));

        assertTrue(applePage.verifyRegularIsInComparison().getText().contains(TestData.ME294UAA));

        applePage.goToComparisonPage();

        comPage.isOpened();

        assertTrue(elementIsLocated(getLocator("reallyComparison")).getText().contains(TestData.pageC));

        assertTrue(comPage.verifyReallyCustom().getText().contains(TestData.Z0PU002JE));

        assertTrue(comPage.verifyReallyRegular().getText().contains(TestData.ME294UAA));
    }
}