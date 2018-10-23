package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static String takeElementScreenshot(WebDriver driver, WebElement element, String filename) {
        String screenshotLocations = "none";
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //entire page screenshot

        try {
            screenshotLocations = System.getProperty("java.io.tmpdir") + "Fullscreenshot" + filename + ".png";
            FileUtils.copyFile(screenshot, new File(screenshotLocations));

            BufferedImage fullImg = ImageIO.read(screenshot);

            Point point = element.getLocation();
            int elementWidth = element.getSize().getWidth();
            int elementHeight = element.getSize().getHeight();

            //crop screenshot to get only element
            BufferedImage elementScreenshot = fullImg.getSubimage(point.getX(), point.getY(), elementWidth, elementHeight);
            ImageIO.write(elementScreenshot, "png", screenshot);
            screenshotLocations = screenshotLocations + "\n" + System.getProperty("java.io.tmpdir") + filename + ".png";
            FileUtils.copyFile(screenshot, new File(System.getProperty("java.io.tmpdir") + filename + ".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotLocations;
    }

    public static String takeLocationScreenshot(WebDriver driver, int x, int y, int height, int width, String filename) {
        String screenshotLocations = "none";
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //entire page screenshot

        try {
            screenshotLocations = System.getProperty("java.io.tmpdir") + "LocationScreenshot" + filename + ".png";
            FileUtils.copyFile(screenshot, new File(screenshotLocations));

            BufferedImage fullImg = ImageIO.read(screenshot);

            //crop screenshot to get only element
            BufferedImage elementScreenshot = fullImg.getSubimage(x, y, width, height);
            ImageIO.write(elementScreenshot, "png", screenshot);
            screenshotLocations = screenshotLocations + "\n" + System.getProperty("java.io.tmpdir") + filename + ".png";
            FileUtils.copyFile(screenshot, new File(System.getProperty("java.io.tmpdir") + filename + ".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotLocations;
    }

    public static String takeScreenshot(WebDriver driver, String filename) {
        String screenshotLocations = "none";
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //entire page screenshot

        try {
            screenshotLocations = System.getProperty("java.io.tmpdir") + "Fullscreenshot" + filename + ".png";
            //screenshotLocations = "C:\\screenshots\\Fullscreenshot" + filename + ".png";

            FileUtils.copyFile(screenshot, new File(screenshotLocations));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotLocations;
    }
}
