package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.DriverUtils;

public class HomePage extends AbstractPage{

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //region getters
    private WebElement getMoviesFilterIcon() throws Exception {
        return DriverUtils.findElementWithWait(getDriver(), By.xpath("//a[@routerlink='Movies']"), "can't find movies filter icon", 5);
    }
    private WebElement getSeriesFilterIcon() throws Exception {
        return DriverUtils.findElementWithWait(getDriver(), By.xpath("//a[@routerlink='Series']"), "can't find series filter icon", 5);
    }
    private WebElement getAllFilterIcon() throws Exception {
        return DriverUtils.findElementWithWait(getDriver(), By.xpath("//a[@routerlink='/']"), "can't find all filter icon", 5);
    }
    private WebElement getMediaItems() throws Exception {
        return DriverUtils.findElementWithWait(getDriver(), By.xpath("//mw-media-item]"), "can't find any media item", 5);
    }
    //enderegion

    //region interactions
    public void clickMoviesFilter() throws Exception {
        click(getMoviesFilterIcon());
    }
    public void clickSeriesFilter() throws Exception {
        click(getSeriesFilterIcon());
    }
    public void clickAllFilter() throws Exception {
        click(getAllFilterIcon());
    }
    public void navigateTo_HomePage() {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }
    //endregion

    //region verifications
    public void verifyMediaItemCount(int expectedCount) throws Exception {
        Assert.assertTrue(getMediaItems().equals(expectedCount));
    }
    //endregion

}
