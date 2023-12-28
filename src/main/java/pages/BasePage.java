package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected PageWaits waits;
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.waits = new PageWaits(webDriver);
    }
}
