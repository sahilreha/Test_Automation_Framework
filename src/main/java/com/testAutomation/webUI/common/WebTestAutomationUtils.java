package com.testAutomation.webUI.common;

import com.testAutomation.webUI.browsermanagement.ThreadLocalDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class WebTestAutomationUtils {
    private static final Logger logger = LogManager.getLogger(WebTestAutomationUtils.class);
    private static final long DEFAULT_WAIT_TIME = 30;

    private WebDriverWait getWait() {
        return new WebDriverWait(ThreadLocalDriverManager.getCurrentDriver(), Duration.ofSeconds(DEFAULT_WAIT_TIME));
    }

    private WebElement waitForCondition(ExpectedCondition<WebElement> condition) {
        try {
            return getWait().until(condition);
        } catch (TimeoutException e) {
            logger.error("Wait condition failed: {}", condition.toString(), e);
            throw new RuntimeException("Wait condition failed: " + condition, e);
        }
    }

    public void click(By by) {
        try {
            WebElement element = waitForCondition(ExpectedConditions.elementToBeClickable(by));
            element.click();
        } catch (Exception e) {
            logger.error("Failed to click on the element: {}", by, e);
            throw new RuntimeException("Failed to click on the element: " + by, e);
        }
    }

    public void typeInto(By by, String value) {
        try {
            WebElement element = waitForCondition(ExpectedConditions.visibilityOfElementLocated(by));
            element.sendKeys(value);
        } catch (Exception e) {
            logger.error("Failed to type into the element: {}", by, e);
            throw new RuntimeException("Failed to type into the element: " + by, e);
        }
    }

    public String getText(By by) {
        try {
            WebElement element = waitForCondition(ExpectedConditions.visibilityOfElementLocated(by));
            return element.getText();
        } catch (Exception e) {
            logger.error("Failed to get text from the element: {}", by, e);
            throw new RuntimeException("Failed to get text from the element: " + by, e);
        }
    }


    public void switchToOtherTab(By by) {
        try {
            String parentWindow = ThreadLocalDriverManager.getCurrentDriver().getWindowHandle();
            click(by);
            Set<String> windows = ThreadLocalDriverManager.getCurrentDriver().getWindowHandles();
            for (String window : windows) {
                if (!window.equals(parentWindow)) {
                    ThreadLocalDriverManager.getCurrentDriver().switchTo().window(window);
                }
            }
        } catch (Exception e) {
            logger.error("Failed to switch to another tab: {}", by, e);
            throw new RuntimeException("Failed to switch to another tab: " + by, e);
        }
    }

    private void selectDropDownByIndex(By by, int index) {
        try {
            WebElement element = waitForCondition(ExpectedConditions.visibilityOfElementLocated(by));
            Select select = new Select(element);
            select.selectByIndex(index);
        } catch (Exception e) {
            logger.error("Failed to select dropdown by index: {}", by, e);
            throw new RuntimeException("Failed to select dropdown by index: " + by, e);
        }
    }

    private void selectDropDownByVisibleText(By by, String visibleText) {
        try {
            WebElement element = waitForCondition(ExpectedConditions.visibilityOfElementLocated(by));
            Select select = new Select(element);
            select.selectByVisibleText(visibleText);
        } catch (Exception e) {
            logger.error("Failed to select dropdown by visible text: {}", by, e);
            throw new RuntimeException("Failed to select dropdown by visible text: " + by, e);
        }
    }


    public void moveToElement(By by) {
        try {
            Actions actions = new Actions(ThreadLocalDriverManager.getCurrentDriver());
            WebElement element = waitForCondition(ExpectedConditions.visibilityOfElementLocated(by));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            logger.error("Failed to move to element: {}", by, e);
            throw new RuntimeException("Failed to move to element: " + by, e);
        }
    }


    public String getPageTitle() {
        try {
            return ThreadLocalDriverManager.getCurrentDriver().getTitle();
        } catch (Exception e) {
            logger.error("Failed to get page title", e);
            throw new RuntimeException("Failed to get page title", e);
        }
    }

    public boolean isDisplayed(By by) {
        try {
            WebElement element = waitForCondition(ExpectedConditions.visibilityOfElementLocated(by));
            return element.isDisplayed();
        } catch (Exception e) {
            logger.error("Failed to check if element is displayed: {}", by, e);
            throw new RuntimeException("Failed to check if element is displayed: " + by, e);
        }
    }

    public WebDriver getWebDriver() {
        return ThreadLocalDriverManager.getCurrentDriver();
    }


    public void scrollToWebElement(By by) {
        try {
            WebElement element = waitForCondition(ExpectedConditions.visibilityOfElementLocated(by));
            JavascriptExecutor js = (JavascriptExecutor) ThreadLocalDriverManager.getCurrentDriver();
            js.executeScript("arguments[0].scrollIntoView();", element);
        } catch (Exception e) {
            logger.error("Failed to scroll to element: {}", by, e);
            throw new RuntimeException("Failed to scroll to element: " + by, e);
        }
    }

    public void scrollDownByKey() {
        try {
            Actions actions = new Actions(ThreadLocalDriverManager.getCurrentDriver());
            actions.sendKeys(Keys.DOWN).perform();
        } catch (Exception e) {
            logger.error("Failed to scroll down by key", e);
            throw new RuntimeException("Failed to scroll down by key", e);
        }
    }

    public void scrollDownByPixels(int pixels) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) ThreadLocalDriverManager.getCurrentDriver();
            js.executeScript("window.scrollBy(0, " + pixels + ");");
        } catch (Exception e) {
            logger.error("Failed to scroll down by pixels: {}", pixels, e);
            throw new RuntimeException("Failed to scroll down by pixels: " + pixels, e);
        }
    }

    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Thread interrupted during sleep", e);
            throw new RuntimeException("Thread interrupted during sleep", e);
        }
    }

    public void navigateTo(String url) {
        try {
            ThreadLocalDriverManager.getCurrentDriver().navigate().to(url);
        } catch (Exception e) {
            logger.error("Failed to navigate to URL: {}", url, e);
            throw new RuntimeException("Failed to navigate to URL: " + url, e);
        }
    }

    public void launchUrl(String url) {
        try {
            ThreadLocalDriverManager.getCurrentDriver().get(url);
        } catch (Exception e) {
            logger.error("Failed to launch URL: {}", url, e);
            throw new RuntimeException("Failed to launch URL: " + url, e);
        }
    }
}
