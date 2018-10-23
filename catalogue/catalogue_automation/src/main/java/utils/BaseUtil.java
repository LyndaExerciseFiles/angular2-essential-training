package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.exceptions.AssertException;

import java.util.List;
import java.util.function.Function;

public class BaseUtil {

    public Logger log = Logger.getLogger(this.getClass());

    public static int NO_EXCEPTION = 0;
    public static int NORMAL_EXCEPTION = 1;
    public static int ASSERTION_EXCEPTION = 2;

    public static WebElement findElement(WebDriver driver, By by, String msg) throws Exception {
        return findElement(driver, by, null, 2, true, false, ASSERTION_EXCEPTION, msg);
    }

    public static WebElement findElement(WebDriver driver, By by, WebElement parentElement, String msg) throws Exception {
        return findElement(driver, by, parentElement, 2, true, false, ASSERTION_EXCEPTION, msg);
    }

    public static WebElement findElement(WebDriver driver,
                                         By by,
                                         WebElement parentElement,
                                         int timeOut,
                                         boolean checkVisible,
                                         boolean checkEnable,
                                         int exceptionType,
                                         String msg) throws Exception {
        try {
            return findElement(driver, by, parentElement, timeOut, checkVisible, checkEnable);
        } catch (Exception e) {
            if (exceptionType == NO_EXCEPTION) {
                return null;
            } else if (exceptionType == ASSERTION_EXCEPTION) {
                throw new AssertException(msg);
            } else {
                throw e;
            }
        }
    }

    //findElements
    public static List<WebElement> findElements(WebDriver driver, By by, int timeOut,
                                                int exceptionType,
                                                String msg) throws Exception {
        return findElements(driver, by, null, timeOut, exceptionType, msg);
    }

    public static List<WebElement> findElements(WebDriver driver,
                                                By by,
                                                WebElement parentElement,
                                                int timeOut,
                                                int exceptionType,
                                                String msg) throws Exception {
        try {
            return findElements(driver, by, parentElement, timeOut);
        } catch (Exception e) {
            if (exceptionType == NO_EXCEPTION) {
                return null;
            } else if (exceptionType == ASSERTION_EXCEPTION) {
                throw new AssertException(msg);
            } else {
                throw e;
            }
        }
    }

    private static WebElement findElement(WebDriver driver,
                                          By by,
                                          WebElement parentElement,
                                          int timeOut,
                                          boolean checkVisible,
                                          boolean checkEnable) throws Exception {
        WebElement element;
        Function<WebDriver, WebElement> waitCondition;

        if (parentElement == null) {
            waitCondition = newDriver -> {
                if (checkVisible) {
                    return getElementIfDisplayed(driver, by); //wait for found element to be visible, then return that element;
                } else {
                    return driver.findElement(by);
                }
            };
        } else {
            waitCondition = newDriver -> {
                if (checkVisible) {
                    return getElementIfDisplayed(parentElement, by); //wait for found element to be visible, then return that element;
                } else {
                    return parentElement.findElement(by);
                }
            };
        }

        element = (new WebDriverWait(driver, timeOut)).until(waitCondition);

        if (checkEnable) {
            if (!element.isEnabled()) {
                throw new Exception("Not Enable!");
            }
        }

        return element;
    }

    private static WebElement getElementIfDisplayed(WebDriver driver, By by){
        if(driver.findElement(by).isDisplayed()) {
            return driver.findElement(by);
        } else {
            return null;
        }
    }

    private static WebElement getElementIfDisplayed(WebElement parentElement, By by){
        if(parentElement.findElement(by).isDisplayed()) {
            return parentElement.findElement(by);
        } else {
            return null;
        }
    }

    private static List<WebElement> findElements(WebDriver driver,
                                                 By by,
                                                 WebElement parentElement,
                                                 int timeOut) {
        List<WebElement> elements = null;

        if (parentElement == null) {
            elements = (new WebDriverWait(driver, timeOut)).until(newDriver -> driver.findElements(by));
        } else {
            elements = (new WebDriverWait(driver, timeOut)).until(newDriver -> parentElement.findElements(by));
        }

        return elements;
    }
}
