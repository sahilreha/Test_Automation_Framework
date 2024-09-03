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
            ChromeOptions chromeOptions = new ChromeOptions();
            if (TestConfig.enableBrowserOptions.equalsIgnoreCase("true")) {
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--no-sandbox");
            }

            if (TestConfig.executionPlatform.equalsIgnoreCase("local")) {
                driver = new ChromeDriver(chromeOptions);
            } else if (TestConfig.executionPlatform.equalsIgnoreCase("remote")) {
                chromeOptions.setPlatformName("linux");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
            }
        }

        else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (TestConfig.enableBrowserOptions.equalsIgnoreCase("true")) {
                firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("--disable-gpu");
                firefoxOptions.addArguments("--no-sandbox");
            }

            if (TestConfig.executionPlatform.equalsIgnoreCase("local")) {
                driver = new FirefoxDriver(firefoxOptions);
            } else if (TestConfig.executionPlatform.equalsIgnoreCase("remote")) {
                firefoxOptions.setPlatformName("linux");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
            }
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        if (driver != null) {
            ThreadLocalDriverManager.getInstance().setDriver(driver);
        }
    }

    public static void launchUrl(String url) {
        WebDriver driver = ThreadLocalDriverManager.getCurrentDriver();
        if (driver != null) {
            driver.get(url);
            driver.manage().window().maximize();
        } else {
            throw new IllegalStateException("WebDriver instance is not initialized. Call openBrowser() first.");
        }
    }
}
