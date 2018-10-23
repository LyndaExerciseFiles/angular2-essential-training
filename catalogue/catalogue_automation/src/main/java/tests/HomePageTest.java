package tests;

import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.PageObjectBase;

public class HomePageTest extends PageObjectBase {
    private HomePage homePage;

    public HomePageTest(WebDriver driver) {
        super(driver);
        PageObjectManager pageObjectManager = new PageObjectManager(driver);
        this.homePage = pageObjectManager.getHomePage();
    }

    @Test(description = "switch filter movies/series/all")
    public void launchSite() throws Exception {
        //1. Navigate to localhost:4200
        homePage.navigateTo_HomePage();

        //2. Click Movies icon
        homePage.clickMoviesFilter();

        //3. Verify 3 Media Item Displayed
        homePage.verifyMediaItemCount(3);

        //4.Click Series icon
        homePage.clickSeriesFilter();

        //5. Verify 2 Media Item Displayed
        homePage.verifyMediaItemCount(2);

        //6. Click All icon
        homePage.clickAllFilter();

        //7. Verify 5 Media Item Displayed
        homePage.verifyMediaItemCount(5);
    }


}
