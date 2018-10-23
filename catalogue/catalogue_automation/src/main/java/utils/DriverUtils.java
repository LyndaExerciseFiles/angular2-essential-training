package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.exceptions.CommonAssertException;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriverUtils {
    public Logger log = Logger.getLogger(this.getClass());

    //region findElement
    //137
//    public static WebElement findElement(WebDriver driver, By by, String msg) throws IfmAssertException {
//        try {
//            return driver.findElement(by);
//        } catch (Exception e) {
//            throw new IfmAssertException(msg);
//        }
//    }

    //8
//    public static WebElement findElementWithWaitWithoutIfmException(WebDriver driver, By by, String msg, int timeOut) {
//        (new WebDriverWait(driver, timeOut)).until(newDriver -> newDriver.findElement(by).isEnabled());
//        return driver.findElement(by);
//    }

    //122
//    public static WebElement findElementWithWaitWithoutIfmException(WebDriver driver, WebElement parentElement, By by, int timeOutInSeconds) {
//        try {
//            //(new WebDriverWait(driver, timeOutInSeconds)).until(newDriver -> !parentElement.findElements(by).isEmpty() && newDriver.findElements(by).get(0).isDisplayed());
//            (new WebDriverWait(driver, timeOutInSeconds)).until(newDriver -> !parentElement.findElements(by).isEmpty());
//            return parentElement.findElement(by);
//        } catch (Exception e) {
//            return null;
//        }
//    }

    //26
//    public static WebElement findElementWithWaitWithoutIfmException(WebDriver driver, By by, String msg) throws Exception {
//        return IfmDriverUtilNew.findElement(driver, by, msg);
//    }

    //57
//    public static WebElement findElement(WebElement parentElement, By by, String msg) throws IfmAssertException {
//        try {
//            return parentElement.findElement(by);
//        } catch (Exception e) {
//            throw new IfmAssertException(msg);
//        }
//    }

//    public static WebElement findElementWithoutIfmException(WebElement parentElement, By by) throws Exception {
//        try {
//            return parentElement.findElement(by);
//        } catch (Exception e) {
//            throw new Exception();
//        }
//    }

    //7
//    public static WebElement findElementWithWaitHasInvisible(WebDriver driver, By by, String msg) throws IfmAssertException {
//        try {
//            return driver.findElement(by);
//        } catch (Exception e) {
//            throw new IfmAssertException(msg);
//        }
//    }

    //2
//    public static WebElement findElementWithWaitHasInvisibleWithoutIfmException(WebDriver driver, By by, String msg) {
//        try {
//            return driver.findElement(by);
//        } catch (Exception e) {
//            return null;
//        }
//    }

    //44
    public static WebElement findElementWithoutException(WebElement parentElement, By by) {
        try {
            return parentElement.findElement(by);
        } catch (Exception e) {
            return null;
        }
    }

    //76
    public static WebElement findElementWithWaitWithoutIfmException(WebDriver driver, By by, int timeOut) {
        (new WebDriverWait(driver, timeOut)).until(newDriver -> newDriver.findElement(by).isDisplayed());
        return driver.findElement(by);
    }

    //107
    public static WebElement findElementWithWaitWithoutException(WebDriver driver, By by, int timeOutInSeconds) {
        try {
            (new WebDriverWait(driver, timeOutInSeconds)).until(newDriver -> newDriver.findElement(by).isEnabled());
        } catch (Exception ex) {
            return null;
        }
        return driver.findElement(by);
    }

    //82
    public static WebElement findElementWithWaitWithoutException(WebDriver driver, WebElement parentElement, By by, int timeOut) {
        try {
            (new WebDriverWait(driver, timeOut)).until(newDriver -> !parentElement.findElements(by).isEmpty() && parentElement.findElements(by).get(0).isDisplayed());
            return parentElement.findElement(by);
        } catch (Exception ex) {
            return null;
        }
    }


    //15
//    public static WebElement findElementWithoutException(WebDriver driver, By by) {
//        try {
//            return driver.findElement(by);
//        } catch (Exception e) {
//            return null;
//        }
//    }

    //24
//    public static WebElement findElementWithoutException(WebDriver driver, By by, int waitTime)  {
//        try {
//            (new WebDriverWait(driver, waitTime)).until(newDriver -> newDriver.findElement(by).isDisplayed());
//            return driver.findElement(by);
//        } catch (Exception e) {
//            return null;
//        }
//    }

    //903
    public static WebElement findElementWithWait(WebDriver driver, By by, String msg) throws CommonAssertException {
        boolean checkVisibilityOfElement = true;
        return findElementWithWait(driver, by, msg, 30, checkVisibilityOfElement);
    }

    //4
//    public static WebElement findElementWithWait(WebDriver driver, By by, String msg, boolean checkVisibilityOfElement) throws IfmAssertException {
//        return findElementWithWait(driver, by, msg, 30, checkVisibilityOfElement);
//    }

    //44
    public static WebElement findElementWithWait(WebDriver driver, By by, String msg, int waitTime) throws CommonAssertException {
        boolean checkVisibilityOfElement = true;
        return findElementWithWait(driver, by, msg, waitTime, checkVisibilityOfElement);
    }

    //4
//    public static WebElement findElementWithWait(WebDriver driver, By by, String msg, int waitTime, boolean checkVisibilityOfElement, boolean checkElementClickable) throws IfmAssertException {
//        if (driver == null) {
//            throw new IfmAssertException("Driver variable was null - problem with test code. Message for failing to get screen element was '" + msg + "'");
//        }
//
//        try {
//            //System.out.println("ExpectedConditions.presenceOfElementLocated(" + by + ")");
//            // AL 5/1/2016 - was (new WebDriverWait(driver, waitTime)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)); but this seems to be causing issues
//            WebElement elementFound = (new WebDriverWait(driver, waitTime)).until(newDriver -> isElementDisplayed(driver, by)); //wait for element to be found
//            //System.out.println("ExpectedConditions.visibilityOf(" + by + ")");
//            if (checkVisibilityOfElement) {
//                elementFound = (new WebDriverWait(driver, waitTime)).until(newDriver -> isElementDisplayed(driver, by)); //wait for found element to be visible, then return that element
//            }
//
//            if (checkElementClickable) {
//                elementFound = (new WebDriverWait(driver, waitTime)).until(newDriver -> isElementEnabled(driver, by)); //wait for found element to be clickable, then return that element
//            }
//
//            return elementFound;
//            //return driver.findElement(by);
//        } catch (Exception e) {
//            //System.out.println("Error message: " + e.getMessage());
//            throw new IfmAssertException(msg);
//        }
//    }

    //332
    public static WebElement findElementWithWait(WebDriver driver, WebElement parentElement, By by, String msg) throws CommonAssertException {
        return findElementWithWait(driver, parentElement, by, msg, 30);
    }

    //37
    public static WebElement findElementWithWait(WebDriver driver, WebElement parentElement, By by, String msg, int timeOut) throws CommonAssertException {
        try {
            //(new WebDriverWait(driver, timeOut)).until(newDriver -> !parentElement.findElements(by).isEmpty() && parentElement.findElements(by).get(0).isDisplayed());
            (new WebDriverWait(driver, timeOut)).until(newDriver -> !parentElement.findElements(by).isEmpty());
            return parentElement.findElement(by);
        } catch (Exception e) {
            throw new CommonAssertException(msg);
        }
    }

    //1
//    public static WebElement findElementWithWait(WebDriver driver, WebElement parentElement, By by, String msg, int timeOut, boolean checkVisibilityOfElement, boolean checkElementClickable) throws IfmAssertException {
//        try {
//            WebElement elementFound = (new WebDriverWait(driver, timeOut)).until(newDriver -> isNestedElementPresent(parentElement, by)); //wait for element to be found
//            if (checkVisibilityOfElement) {
//                elementFound = (new WebDriverWait(driver, timeOut)).until(newDriver -> isNestedElementDisplayed(parentElement, by)); //wait for found element to be visible, then return that element
//            }
//
//            if (checkElementClickable) {
//                elementFound = (new WebDriverWait(driver, timeOut)).until(newDriver -> isNestedElementEnabled(parentElement, by)); //wait for found element to be clickable, then return that element
//            }
//            return elementFound;
//        } catch (Exception e) {
//            throw new IfmAssertException(msg);
//        }
//    }


////////findElements
    //endregion

    //region findElements
    //129
    public static List<WebElement> findElementsWithWait(WebDriver driver, By by, String msg) throws CommonAssertException {
        return findElementsWithWait(driver, by, msg, 20);
    }


//    public static List<WebElement> findElementsWithWait(WebDriver driver, By by, String msg, int timeOut) throws IfmAssertException {
//        return findElementsWithWait(driver, by, msg, timeOut, false);
//    }

    //4
    public static List<WebElement> findElementsWithWait(WebDriver driver, By by, String msg, boolean checkVisibility) throws CommonAssertException {
        return findElementsWithWait(driver, by, msg, 20, checkVisibility);
    }

    //22
    public static List<WebElement> findElementsWithWait(WebDriver driver, WebElement parentElement, By by, String msg) throws CommonAssertException {
        return findElementsWithWait(driver, parentElement, by, msg, 20);
    }

    //7
    public static List<WebElement> findElementsWithWaitHasInvisible(WebDriver driver, By by, String msg) throws CommonAssertException {
        try {
            return driver.findElements(by);
        } catch (Exception e) {
            throw new CommonAssertException(msg);
        }
    }

    //51
    public static List<WebElement> findElements(WebDriver driver, By by, String msg) throws CommonAssertException {
        try {
            return driver.findElements(by);
        } catch (Exception e) {
            throw new CommonAssertException(msg);
        }
    }

    //8
    public static List<WebElement> findElements(WebElement parentElement, By by, String msg) throws CommonAssertException {
        try {
            return parentElement.findElements(by);
        } catch (Exception e) {
            throw new CommonAssertException(msg);
        }
    }

    //1
//    public static List<WebElement> findElementsWithWaitHasDisabled(WebDriver driver, By by, String msg) throws IfmAssertException {
//        try {
//            return driver.findElements(by);
//        } catch (Exception e) {
//            throw new IfmAssertException(msg);
//        }
//    }

    //10
    public static List<WebElement> findElementsWithWaitWithoutIfmException(WebDriver driver, By by, int timeOutInSeconds) {
        (new WebDriverWait(driver, timeOutInSeconds)).until(newDriver -> newDriver.findElement(by).isEnabled());
        return driver.findElements(by);
    }

    //12
    public static List<WebElement> findElementsWithWaitWithoutException(WebDriver driver, By by, int timeOutInSeconds) {
        try {
            (new WebDriverWait(driver, timeOutInSeconds)).until(newDriver -> newDriver.findElement(by).isEnabled());
        } catch (Exception ex) {
            return null;
        }
        return driver.findElements(by);
    }
    //endregion

    //region Others
    public static String getFirstSelectedOptionFromDropdown(WebElement selectElement) {
        Select select = new Select(selectElement);
        return select.getFirstSelectedOption().getText();
    }

    //275
    public static void waitFor(int timeInSeconds, String waitReason) {
        if (timeInSeconds > 5) {
            String waitMessage = "Wait for " + timeInSeconds + " seconds";
            if (waitReason != null) {
                waitMessage = waitMessage + ": " + waitReason;
            }
            //don't want to overload the logs with trivial waits during test execution
            CommonUtil.appendSampleInfo(Logger.getLogger(DriverUtils.class), waitMessage);
        }

        try {
            TimeUnit.SECONDS.sleep(timeInSeconds);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void waitFor(int timeInSeconds) {
        waitFor(timeInSeconds, null);
    }
    //endregion

    private static WebElement findElementWithWait(WebDriver driver, By by, String msg, int waitTime, boolean checkVisibilityOfElement) throws CommonAssertException {
        if (driver == null) {
            throw new CommonAssertException("Driver variable was null - problem with test code. Message for failing to get screen element was '" + msg + "'");
        }

        try {
            //System.out.println("ExpectedConditions.presenceOfElementLocated(" + by + ")");
            // AL 5/1/2016 - was (new WebDriverWait(driver, waitTime)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)); but this seems to be causing issues
            //WebElement elementFound = (new WebDriverWait(driver, waitTime)).until(newDriver -> isElementDisplayed(driver, by));  //wait for element to be found
            WebElement elementFound = (new WebDriverWait(driver, waitTime)).until(ExpectedConditions.presenceOfElementLocated(by));  //wait for element to be found
            //System.out.println("ExpectedConditions.visibilityOf(" + by + ")");
            if (checkVisibilityOfElement) {
                try {
                    elementFound = (new WebDriverWait(driver, waitTime)).until(newDriver -> isElementDisplayed(driver, by)); //wait for found element to be visible, then return that element
                } catch (Exception e) {
                    //System.out.println("Error message: " + e.getMessage());
                    elementFound = (new WebDriverWait(driver, waitTime)).until(newDriver -> isElementDisplayed(driver, by));
                    scrollToView(driver, elementFound);
                    try {
                        elementFound = (new WebDriverWait(driver, waitTime)).until(newDriver -> isElementDisplayed(driver, by)); //wait for found element to be visible, then return that element
                    } catch (Exception ex) {
                        throw new CommonAssertException("The screen element was found but was probably off screen. Default error message for this is: " + msg);
                    }
                }
            }

            return elementFound;
            //return driver.findElement(by);
        } catch (Exception e) {
            //System.out.println("Error message: " + e.getMessage());
            throw new CommonAssertException(msg);
        }
    }

    private static void scrollToView(WebDriver driver, WebElement element) {
        String js = "arguments[0].scrollIntoView(true);";
        ((JavascriptExecutor)driver).executeScript(js, element);
    }

//    private static WebElement isElementEnabled(WebDriver driver, By by){
//        if(driver.findElement(by).isEnabled())
//            return driver.findElement(by);
//        return null;
//    }

    private static WebElement isElementDisplayed(WebDriver driver, By by){
        if(driver.findElement(by).isDisplayed())
            return driver.findElement(by);
        return null;
    }

//    private static WebElement isNestedElementEnabled(WebElement parentElement, By by){
//        if(parentElement.findElement(by).isEnabled())
//            return parentElement.findElement(by);
//        return null;
//    }

//    private static WebElement isNestedElementDisplayed(WebElement parentElement, By by){
//        if(parentElement.findElement(by).isDisplayed())
//            return parentElement.findElement(by);
//        return null;
//    }

//    private static WebElement isNestedElementPresent(WebElement parentElement, By by){
//        if(parentElement.findElement(by) != null)
//            return parentElement.findElement(by);
//        return null;
//    }

    //1 internal
    private static List<WebElement> findElementsWithWait(WebDriver driver, WebElement parentElement, By by, String msg, int timeOut) throws CommonAssertException {
        try {
            (new WebDriverWait(driver, timeOut)).until(newDriver -> !parentElement.findElements(by).isEmpty() && parentElement.findElements(by).get(0).isDisplayed());
            return parentElement.findElements(by);
        } catch (Exception e) {
            throw new CommonAssertException(msg);
        }
    }

    //1 internal
    private static List<WebElement> findElementsWithWait(WebDriver driver, By by, String msg, int timeOut, boolean checkVisibility) throws CommonAssertException {
        try {
            if (checkVisibility) {
                new WebDriverWait(driver, timeOut).until(newDriver -> newDriver.findElement(by).isDisplayed());
            } else {
                //(new WebDriverWait(driver, timeOut)).until(ExpectedConditions.elementToBeClickable(by));
                new WebDriverWait(driver, timeOut).until(newDriver -> !newDriver.findElement(by).isDisplayed());
            }
            return driver.findElements(by);
        } catch (Exception e) {
            throw new CommonAssertException(msg);
        }
    }

    //1 internal
    private static List<WebElement> findElementsWithWait(WebDriver driver, By by, String msg, int timeOut) throws CommonAssertException {
        try {
            (new WebDriverWait(driver, timeOut)).until(newDriver -> newDriver.findElement(by).isEnabled());
            return driver.findElements(by);
        } catch (Exception e) {
            throw new CommonAssertException(msg);
        }
    }
    //endregion

}
