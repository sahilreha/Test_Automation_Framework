package com.testAutomation.commonUtilities;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class for taking screenshots in both web and mobile contexts.
 */
public class GenericUtility {

    private WebDriver driver;
    private AppiumDriver appiumDriver;


    /**
     * Default constructor.
     */
    public GenericUtility(){

    }
    public GenericUtility(WebDriver driver){
        this.driver = driver;
    }

    public GenericUtility(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public String takeScreenshot(String imageName) {
        File sourceFile = null;
        if (driver != null) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        } else if (appiumDriver != null) {
            TakesScreenshot screenshot = (TakesScreenshot) appiumDriver;
            sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        }

        String addScreenshotPath = System.getProperty("user.dir")
                + "/screenshots/" + getTimestamp() + "_" + imageName;

        try {
            assert sourceFile != null;
            FileUtils.copyFile(sourceFile, new File(addScreenshotPath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot: " + addScreenshotPath, e);
        }
        return addScreenshotPath;
    }

//    public static String convertImg_Base64(String screenshotPath) throws IOException {
//        byte[] file = FileUtils.readFileToByteArray(new File(screenshotPath));
//        String base64Img = Base64.encodeBase64String(file);
//        return  base64Img;
//    }

    public static String getTimestamp() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }

    public static int getRandomNumber(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/ss/yy");
        Date date = new Date();
        String value = simpleDateFormat.format(date);
        String words= value.replace("/","");
        return Integer.parseInt(words);
    }
}
