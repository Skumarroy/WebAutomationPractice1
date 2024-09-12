package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        // Define the screenshot file path
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String destination = System.getProperty("user.dir") + "/reports/screenshots/" + screenshotName + "_" + dateName + ".png";

        try {
            // Capture the screenshot as a file object
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Copy file to the destination
            FileHandler.copy(srcFile, new File(destination));

            // Return the screenshot path
            return destination;
        } catch (IOException e) {
            e.printStackTrace();
            return null;  // Return null if there is an error
        }
    }

}
