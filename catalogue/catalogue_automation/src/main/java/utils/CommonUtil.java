package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.exceptions.CommonExceptionHandler;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

    private static Logger log = Logger.getLogger(CommonUtil.class);

    /**
     * Returns a part number with all space, hyphen, and carriage return characters stripped.
     *
     * @param formattedPartNumber formatted part number with hyphens, spaces, ect.
     * @return A string part number with all space, hyphen, and carriage return characters stripped
     */
    public static String stripPartFormatting(String formattedPartNumber) {
        String strippedPartNumber = "";
        if (formattedPartNumber != null) {
            // strip all space characters
            // strip all hyphen characters
            String nonAlphaNumeric = "[^a-zA-Z0-9]*";
            //String spaceAndHyphenPattern = "\\s|\\-|\\r";
            strippedPartNumber = formattedPartNumber.replaceAll(nonAlphaNumeric, "");
        }
        return strippedPartNumber;
    }

    public static String getFileLastModifiedDate(File fileAndPath){
        String lastModified = "";

        if (fileAndPath.exists()){
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH-mm-ssa");
            Date createdDate = new Date(fileAndPath.lastModified());

            lastModified = sdf.format(createdDate);
        }
        return lastModified;
    }

    public static void setTextInClipboard(String textToSet) {
        StringSelection stringSelection = new StringSelection(textToSet);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection,null);
    }

    public static boolean doesStringHaveEnglishCharacters(String strToCheck) {
        return strToCheck.matches("[a-zA-Z]");
    }

    public static void printLocationById(String idToPrintLocation, WebDriver driver)
    {
        org.openqa.selenium.Point point = driver.findElement(By.id(idToPrintLocation)).getLocation();
        log.info("X=" + point.x + ", Y=" + point.y);
    }

    public static void appendSampleInfo(Logger log, String message) {
        CommonExceptionHandler.appendSampleInfo(message);
        log.info(message);
    }

    public static String replaceThreeLetterMonthWithNumber(String month) {

        if (month.equalsIgnoreCase("Jan")) {
            return "1";
        } else if (month.equalsIgnoreCase("Feb")) {
            return "2";
        } else if (month.equalsIgnoreCase("Mar")) {
            return "3";
        } else if (month.equalsIgnoreCase("Apr")) {
            return "4";
        } else if (month.equalsIgnoreCase("May")) {
            return "5";
        } else if (month.equalsIgnoreCase("Jun")) {
            return "6";
        } else if (month.equalsIgnoreCase("Jul")) {
            return "7";
        } else if (month.equalsIgnoreCase("Aug")) {
            return "8";
        } else if (month.equalsIgnoreCase("Sep")) {
            return "9";
        } else if (month.equalsIgnoreCase("Oct")) {
            return "10";
        } else if (month.equalsIgnoreCase("Nov")) {
            return "11";
        } else {
            return "12";
        }

    }

    public static void killChromeDriverProcesses() {
        try {
            if (new File(Config.getDialogScriptFilePath() + "\\KillProcesses.exe").exists()) {
                Runtime.getRuntime().exec(Config.getDialogScriptFilePath() + "\\KillProcesses.exe \"chromedriver\"");
            }
        } catch (Exception e) {
            log.error("Error occurred trying to cleanup the chrome driver.");
        }
    }

    public static String getHostName() {
        InetAddress addr;
        try {
            addr = InetAddress.getLocalHost();
            return addr.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static boolean isTouchScreen() {
        //return Platform.isSupported(ConditionalFeature.INPUT_TOUCH);
        return Config.getIsRunOnTouchScreen();
    }

    // Use to add visual highlighting to a page element: IfmUtils.elementHighlight(element, driver);
    public static void elementHighlight(WebElement element, WebDriver driver) {
        for (int i = 0; i < 2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "color: red; border: 3px solid red;");
            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "");
        }
    }
}
