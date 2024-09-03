package com.testAutomation.utilities;

import com.aventstack.extentreports.ExtentTest;

public class ExtentReport {

    // ThreadLocal to store ExtentTest instances for each thread
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    //This method is used to retrieve the ExtentTest instance for the current thread
    public static ExtentTest getTest(){
        return extentTest.get();
    }

    //This method is used to set the ExtentTest instance for the current thread
    public static void setTest(ExtentTest extent){
        extentTest.set(extent);
    }
}
