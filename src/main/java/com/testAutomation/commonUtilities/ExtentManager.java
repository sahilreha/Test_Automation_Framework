package com.testAutomation.commonUtilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports report;
    public static ExtentReports getInstance(){
        if(report == null){
            ExtentSparkReporter spark = new ExtentSparkReporter("./reports/spark.html");
            report = new ExtentReports();
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Report : Test Automation Report");
            spark.config().setEncoding("utf-8");
            spark.config().setReportName("My report");
            spark.config().setReportName("Automation Author: Sahil");
            report.attachReporter(spark);
        }
        return report;
    }

}
