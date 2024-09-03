package com.testAutomation.webUI.browsermanagement;

public class TestConfig {

    // Default browser for testing
    public static String defaultBrowser = System.getProperty("browser", "chrome");

    // Test execution environment we can set for e.g. "qa","stage","prod"
    public static String environmentStage = System.getProperty("stage", "stage");

    // Platform for execution (e.g., "local", "remote")
    public static String executionPlatform = System.getProperty("platform", "local");

    // Flag to enable or disable additional browser options
    public static String enableBrowserOptions = System.getProperty("enableBrowserOptions", "true");

}
