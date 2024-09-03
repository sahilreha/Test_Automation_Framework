package com.automationFramework.testSuite.dummyAppTestSuite;

import com.automationFramework.baseTestUtility.BaseTestUtility;
import com.aventstack.extentreports.ExtentTest;
import com.testAutomation.commonUtilities.ExtentManager;
import com.testAutomation.commonUtilities.ExtentReport;
import com.testAutomation.webUI.browsermanagement.WebDriverFactory;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

public class DummyBaseTest extends BaseTestUtility {

    private final String URL = "https://thinking-tester-contact-list.herokuapp.com/";

    @BeforeMethod
    public void initializeExtentTest(ITestResult result) {
        WebDriverFactory.launchUrl(URL);
        ExtentTest test = ExtentManager.getInstance().createTest(result.getMethod().getMethodName());
        ExtentReport.setTest(test);
    }
}
