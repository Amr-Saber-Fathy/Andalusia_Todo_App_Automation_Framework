package testLinsteners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // Saves to a 'screenshots' folder with a timestamp
            FileUtils.copyFile(srcFile, new File("./screenshots/" + screenshotName + "_" + timestamp + ".png"));
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }
}