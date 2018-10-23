package pageObjects;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Select;
import utils.BaseUtil;
import utils.CommonUtil;
import utils.Config;
import utils.ScreenshotUtils;
import utils.exceptions.CommonAssert;
import utils.exceptions.ExceptionType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

    //region Fields
    protected WebDriver driver;

    protected String containerXpath = null;

    public Logger log;
    //endregion

    public AbstractPage() {
        log = Logger.getLogger(this.getClass());
    }

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(this.getClass());
    }

    public WebDriver getDriver() {
        return driver;
    }

    public boolean isFresh(WebElement webElement) {
        try {
            webElement.isEnabled();
            return true;
        } catch (StaleElementReferenceException e) {
            return false; // element is out of date
        }
    }

    public void clearBrowserConsoleLog() {
        //CommonUtil.appendSampleInfo(log, "Clear the console logs (get remove unwanted errors.)");
        driver.manage().logs().get(LogType.BROWSER); //clear console logs after drag and drop as selenium 'approximates' this action - manual execution we dont get errors
    }

    protected void printText(WebElement textBox, String text, String message) {
        message = message.isEmpty() ? "Enter '" + text + "' into " + Thread.currentThread().getStackTrace()[2].getMethodName() : message;
        CommonUtil.appendSampleInfo(log, message);
        textBox.clear();
        textBox.sendKeys(text);
    }

    public void printText(WebElement textBox, String text) {
        String message = "Enter '" + text + "' into " + Thread.currentThread().getStackTrace()[2].getMethodName();
        printText(textBox, text, message);
    }

    protected void sendKeys(WebElement inputElement, String text, String message) {
        message = message.isEmpty() ? "Send '" + text + "' into input element " + Thread.currentThread().getStackTrace()[2].getMethodName() : message;
        CommonUtil.appendSampleInfo(log, message);
        inputElement.sendKeys(text);
    }

    public void sendKeys(WebElement inputElement, String text) {
        String message = "Send '" + text + "' into input element " + Thread.currentThread().getStackTrace()[2].getMethodName();
        sendKeys(inputElement, text, message);
    }

    protected void pressPageUpKey(WebDriver driver) {
        CommonUtil.appendSampleInfo(log, "Press the page up key");
        Actions a = new Actions(driver);
        a.sendKeys(Keys.PAGE_UP).build().perform();
    }

    protected void pressPageDownKey(WebDriver driver) {
        CommonUtil.appendSampleInfo(log, "Press the page down key");
        Actions a = new Actions(driver);
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    protected void pressDownArrowKey(WebDriver driver) {
        CommonUtil.appendSampleInfo(log, "Press the down arrow key");
        Actions a = new Actions(driver);
        a.sendKeys(Keys.ARROW_DOWN).build().perform();
    }

    protected void pressUpArrowKey(WebDriver driver) {
        CommonUtil.appendSampleInfo(log, "Press the up arrow key");
        Actions a = new Actions(driver);
        a.sendKeys(Keys.ARROW_UP).build().perform();
    }

    protected void pressTabKey(WebDriver driver) {
        CommonUtil.appendSampleInfo(log, "Press the tab key");
        Actions a = new Actions(driver);
        a.sendKeys(Keys.TAB).build().perform();
    }

    protected void click(WebElement element) {
        click(element, "Click on the " + Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    protected void click(WebElement element, String objectDescription) {
        boolean withScrollToElement = true;
        click(element, objectDescription, withScrollToElement); //was false
    }

    protected void click(WebElement element, boolean withScrollToElement) {
        click(element, "Click on the " + Thread.currentThread().getStackTrace()[2].getMethodName(), withScrollToElement);
    }

    protected void click(WebElement element, String objectDescription, boolean withScrollToElement) {
        click(element, objectDescription, withScrollToElement, true);
    }

    protected void click(WebElement element, String objectDescription, boolean withScrollToElement, boolean waitForTriage) {
        boolean javascriptErrorCheck = !Config.isSkipJavascriptErrorCheckOnClick();
        click(element, objectDescription, withScrollToElement, waitForTriage, javascriptErrorCheck);
    }

    protected void click(WebElement element, String objectDescription, boolean withScrollToElement, boolean waitForTriage, boolean javascriptErrorCheck) {
        if (log == null)
            log = Logger.getLogger(this.getClass());
        CommonUtil.appendSampleInfo(log, objectDescription);
        try {
            if (withScrollToElement) {
                scrollToElement(element);
            }
            //CommonUtil.elementHighlight(element, driver);
            //if (javascriptErrorCheck) {
            //    clearBrowserConsoleLog(); //clear the logs before doing the click so we know the error was after the click event
            //}
            element.click();

        } catch (WebDriverException e) {
            if (e.getMessage().contains("Element is not clickable at point")) {
                String screenshotLocations = ScreenshotUtils.takeElementScreenshot(driver, element, !objectDescription.isEmpty() ? objectDescription.replaceAll(" ", "") : "unknownElement");
                CommonAssert.assertTrue(objectDescription + " - not able to click as another element may have been covering it.\nScreenshot location(s):\n" + screenshotLocations, false,
                        ExceptionType.ASSERT);

            } else if (e.getMessage().contains("Other element would receive the click")) {
                String screenshotLocations = ScreenshotUtils.takeElementScreenshot(driver, element, !objectDescription.isEmpty() ? objectDescription.replaceAll(" ", "") : "unknownElement");

                if (e.getMessage().contains("Other element would receive the click: <div class=\"ifm-lock ifm-locked")) {
                    CommonAssert.assertTrue("Could not click as 'Licence Available' modal popup is displayed.\n" + objectDescription + " - not able to click as 'Other element would receive the click'.\nScreenshot location(s):\n" + screenshotLocations, false,
                            ExceptionType.ASSERT);
                } else {
                    CommonAssert.assertTrue(objectDescription + " - not able to click as 'Other element would receive the click'.\nScreenshot location(s):\n" + screenshotLocations, false,
                            ExceptionType.ASSERT);
                }
            } else {
                log.error(e, e);
            }
            throw e;
        }
        catch (Exception e) {
            throw e;
        }
    }

    public void click(WebElement element, int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        String msg = "Click on the " + Thread.currentThread().getStackTrace()[2].getMethodName() + " with offset (" + xOffset + ", " + yOffset +").";
        CommonUtil.appendSampleInfo(log, msg);
        actions.moveToElement(element, xOffset, yOffset).click().perform();
    }

    protected void clickWithJavascript(String elementXPath) {
        String objectDescription = "Click on the " + Thread.currentThread().getStackTrace()[2].getMethodName();
        if (log == null)
            log = Logger.getLogger(this.getClass());
        CommonUtil.appendSampleInfo(log, objectDescription);

        ((JavascriptExecutor) driver).executeScript("document.evaluate(\"" + elementXPath + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click()");
    }

    public void printText(String textBoxId, String text) throws Exception {
        WebElement textBox = BaseUtil.findElement(driver, By.id(textBoxId), "Unable to locate the textbox");
        textBox.clear();
        textBox.sendKeys(text);
    }

    public void toggleOn(WebElement toggleSwitchElement, String descriptionOfToggle) throws Exception {
        if (!toggleSwitchElement.getAttribute("class").equalsIgnoreCase("toggleTrack btn on")) {
            click(toggleSwitchElement, "Click on toggle switch to turn '" + descriptionOfToggle + "' on");
        }
    }

    public void toggleOff(WebElement toggleSwitchElement, String descriptionOfToggle) throws Exception {
        if (toggleSwitchElement.getAttribute("class").equalsIgnoreCase("toggleTrack btn on")) {
            click(toggleSwitchElement, "Click on toggle switch to turn '" + descriptionOfToggle + "' off");
        }
    }

    public void mouseOver(WebElement element) throws Exception {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        TimeUnit.SECONDS.sleep(1);
    }

    public String getInnerHTML(WebElement element) {
        return (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML", element);
    }

    public String getOuterHTML(WebElement element) {
        return (String)((JavascriptExecutor)driver).executeScript("return arguments[0].outerHTML", element);
    }

    public boolean isElementClassActive(WebElement element) {
        String classStr = element.getAttribute("class");
        return classStr != null && classStr.contains("active");
    }

    public void scrollToElement(WebElement element) {
        int elementPosition = element.getLocation().getY();

        String js = String.format("window.scroll(0, %s)", elementPosition);
        ((JavascriptExecutor)driver).executeScript(js);
    }

    public void scrollToView(WebElement element) {
        String js = "arguments[0].scrollIntoView(false);";
        ((JavascriptExecutor)driver).executeScript(js, element);
    }

    public Boolean isComponentDisplayed(String xpath, String notFoundMessage) {
        try {
            WebElement element = BaseUtil.findElement(driver, By.xpath(xpath), null, 2, true, false, BaseUtil.NO_EXCEPTION, notFoundMessage);
            return element != null && element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean isComponentDisplayed(WebElement parentElement, String xpath) {
        try {
            WebElement element = BaseUtil.findElement(driver, By.xpath(xpath), parentElement, 3, true, false, BaseUtil.NORMAL_EXCEPTION, "");
            return element != null;
        } catch (Exception e) {
            return false;
        }
    }


    protected void selectInDropdown(WebElement element, String itemToSelect, String selectOperationDescription) {
        Select select = new Select(element);

        List<WebElement> allOptions = select.getOptions();
        List<String> availableOptions = new ArrayList<>();
        boolean optionIsAvailable = false;
        for (WebElement singleOption : allOptions) {
            availableOptions.add(singleOption.getText().trim());
            if (singleOption.getText().trim().equals(itemToSelect)) {
                optionIsAvailable = true;
                break;
            }
        }

        CommonAssert.assertTrue("Option '" + itemToSelect + "' was not available to be selected in the dropdown. Was attempting to '" + selectOperationDescription + "'. Available options were:\n" + StringUtils.join(availableOptions),
                optionIsAvailable, ExceptionType.VERIFICATION);

        if (optionIsAvailable) {
            log.info(selectOperationDescription);
            select.selectByVisibleText(itemToSelect);
        }

    }

    protected void selectOptionInDropdown(WebElement selectElement, String optionToSelect) {
        String msg = "Select option '" + optionToSelect + "' in the dropdown";
        selectInDropdown(selectElement, optionToSelect, msg);
    }

    protected List<String> getDropdownOptions(WebElement dropdownElement) throws Exception {
        Select select = new Select(dropdownElement);
        List<String> result = new ArrayList<>();
        select.getOptions().forEach(element -> {
            if (StringUtils.isNotBlank(element.getText())) {
                result.add(element.getText().trim());
            }
        });
        return result;
    }

}
