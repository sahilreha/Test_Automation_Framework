package com.testAutomation.webUI.browsermanagement;

import org.openqa.selenium.WebDriver;

/**
 * Manages a single WebDriver instance with thread-local storage.
 * This class follows the Singleton pattern to ensure only one instance is created.
 */
public class ThreadLocalDriverManager {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static ThreadLocalDriverManager instance = null;

    private ThreadLocalDriverManager() {
    }

    public static synchronized ThreadLocalDriverManager getInstance() {
        if (instance == null) {
            instance = new ThreadLocalDriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return webDriver.get();
    }

    public void setDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    public static WebDriver getCurrentDriver() {
        return getInstance().getDriver();
    }
}