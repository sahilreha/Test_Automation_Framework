package com.automationFramework.baseTestUtility;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.testAutomation.commonUtilities.ExtentManager;
import com.testAutomation.commonUtilities.ExtentReport;
import com.testAutomation.commonUtilities.GenericUtility;
import com.testAutomation.webUI.browsermanagement.ThreadLocalDriverManager;
import com.testAutomation.webUI.browsermanagement.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class BaseTestUtility {

    private GenericUtility genericUtility;

    @BeforeClass
    public void setUp() throws MalformedURLException {
            WebDriverFactory.openBrowser("chrome");
            WebDriver driver = ThreadLocalDriverManager.getCurrentDriver();
            // Initialize GenericUtility with the current WebDriver instance
            genericUtility = new GenericUtility(driver);
    }


    @AfterMethod
    public void logTestResult(ITestResult result) {
        if (!result.isSuccess()) {
            ExtentReport.getTest().log(Status.FAIL, "Test case failed due to: " +
                    result.getThrowable());

            String screenshotName = result.getMethod().getMethodName() + ".jpg";
            String screenshotPath = genericUtility.takeScreenshot(screenshotName);

            ExtentReport.getTest().fail(MediaEntityBuilder
                    .createScreenCaptureFromPath(screenshotPath).build());
        }
    }

    @AfterClass
    public void tearDown() {
        WebDriver driver = ThreadLocalDriverManager.getCurrentDriver();
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void flushExtentReports() {
        ExtentManager.getInstance().flush();
    }
}
