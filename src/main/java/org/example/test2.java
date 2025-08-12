package org.example;

import Basepackage.WebDrivercommonlib;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;



    public class test2 extends WebDrivercommonlib {


        @Test
        public static void main(String[] args) throws InterruptedException {
            LoggingPreferences logs = new LoggingPreferences();
            logs.enable(LogType.BROWSER, Level.ALL);
            ChromeOptions options = new ChromeOptions();
            options.setCapability("goog:loggingPrefs", logs);
            WebDriver driver = new ChromeDriver();
            //  System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepak.p.V2SOLUTIONS\\Downloads\\geckodriver-v0.36.0-win32\\geckodriver.exe");
            // WebDriver driver1 = driver;
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
            driver.get("https://developer.salesforce.com/developer-legacy/signup");
            Thread.sleep(5000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,200)");
            Thread.sleep(5000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement outerHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("dw-de-signup-form")));
            SearchContext shadowRoot1 = outerHost.getShadowRoot();
            WebElement innerHost = shadowRoot1.findElement(By.cssSelector("dx-input[name='first_name']"));
            SearchContext shadowRoot2 = innerHost.getShadowRoot();
            WebElement input = shadowRoot2.findElement(By.cssSelector("#input"));
            input.sendKeys("John");
        }
    }

