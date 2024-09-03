package com.testAutomation.webUI.browsermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    public static void openBrowser(String browser) throws MalformedURLException {
        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions chromeOptions = (ChromeOptions) getBrowserOptions("chrome");

            if (TestConfig.executionPlatform.equalsIgnoreCase("local")) {
                driver = new ChromeDriver(chromeOptions);
            }

            else if (TestConfig.executionPlatform.equalsIgnoreCase("remote")) {
                chromeOptions.setPlatformName("linux");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
            }
        }

        else if (browser.equalsIgnoreCase("firefox")) {

            FirefoxOptions firefoxOptions = (FirefoxOptions) getBrowserOptions("firefox");

            if (TestConfig.executionPlatform.equalsIgnoreCase("local")) {
                driver = new FirefoxDriver(firefoxOptions);
            }
            else if (TestConfig.executionPlatform.equalsIgnoreCase("remote")) {
                firefoxOptions.setPlatformName("linux");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
            }
        }

        if (driver != null) {
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();
            ThreadLocalDriverManager.getInstance().setDriver(driver);
        }

        else {
            throw new IllegalArgumentException("Browser type or platform is not supported: " + browser);
        }
    }

    private static Object getBrowserOptions(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            addCommonArguments(options);
            return options;
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            addCommonArguments(options);
            return options;
        }
        throw new IllegalArgumentException("Browser type is not supported: " + browser);
    }

    private static void addCommonArguments(Object options) {
        if (options instanceof ChromeOptions) {
            ChromeOptions chromeOptions = (ChromeOptions) options;
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--no-sandbox");
        } else if (options instanceof FirefoxOptions) {
            FirefoxOptions firefoxOptions = (FirefoxOptions) options;
            firefoxOptions.addArguments("--headless");
            firefoxOptions.addArguments("--disable-gpu");
            firefoxOptions.addArguments("--no-sandbox");
        }
    }
}