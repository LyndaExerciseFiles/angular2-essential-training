package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageObjectBase {

    //region Fields
    protected WebDriver driver;

    protected String containerXpath = null;
    //endregion

    public PageObjectBase() {}

    public PageObjectBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public boolean waitForUrl(String url) {
        // Wait for the page to load timeout after ten seconds
        try {
            new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.getCurrentUrl().equalsIgnoreCase(url);
                }
            });
            return true;
        } catch (Throwable t) {
            return false;
        }
    }

}
