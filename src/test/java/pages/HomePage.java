package pages;


import utils.Log4Test;

public class HomePage extends GeneralPage {

    public void open(String URL) {

        webDriver.get(URL);

        Log4Test.info("Open WebUrl " + URL);

    }

    public boolean isOpened(String URL) {
        return webDriver.getCurrentUrl().equals(URL);
    }

    public void goToNotebooks() {
        Log4Test.info("Going to Notebooks");
        waitForPageLoaded(webDriver);
        elementIsLocated(getLocator("notebooksButton")).click();
    }
}