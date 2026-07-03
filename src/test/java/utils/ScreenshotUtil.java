package utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Allure;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HH.mm.ss").format(new Date());

        String path = "Screenshots/" + testName + "_" + timeStamp + ".png";

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {

            FileUtils.copyFile(source, new File(path));

        } catch (IOException e) {

            e.printStackTrace();

        }

        return path;

    }

    public static void attachScreenshot(WebDriver driver) {

        byte[] screenshot =
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment(
                "Failure Screenshot",
                new ByteArrayInputStream(screenshot));

    }

}