package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String fileName) {

        if (driver == null) return null;

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            // 🔥 ensure folder exists
            File folder = new File("screenshots");
            if (!folder.exists()) {
                folder.mkdir();
            }

            File dest = new File(folder, fileName + ".png");

            FileUtils.copyFile(src, dest);

            return dest.getAbsolutePath();   // ✅ full path

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}