package org.example;

import Action.Action;
import Basepackage.WebDrivercommonlib;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;


public class Orderpage extends WebDrivercommonlib {


   /* public void testOrderPageNavigation() throws Exception {
        Loginpage // Reuse login from parent
        Thread.sleep(3000);
        driver.findElement(By.linkText("Go To My Offering")).click();
        System.out.println("Navigated to My Offering page.");
    }

*/

    @Test
    public static void main(String[] args) throws InterruptedException{
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.ALL);
        ChromeOptions options = new ChromeOptions();
        options.setCapability("goog:loggingPrefs", logs);
        WebDriver driver = new ChromeDriver();
        //  System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepak.p.V2SOLUTIONS\\Downloads\\geckodriver-v0.36.0-win32\\geckodriver.exe");
        // WebDriver driver1 = driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.get("https://realmcellars--qa.sandbox.my.site.com/realmcellars/s/login/");
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(5);
        WebElement usernameclick1 = driver.findElement(By.id("409:0"));
        usernameclick1.click();
        usernameclick1.sendKeys("deepak.p1@v2force.com");
        Thread.sleep(5);
        WebElement password = driver.findElement(By.id("423:0"));
        password.click();
        password.sendKeys("Realmtest@123");
        Thread.sleep(5);
        takeScreenshot(driver, System.getProperty("user.dir") + "C:\\Users\\deepak.p.V2SOLUTIONS\\OneDrive - V2 Tech Ventures Pvt Ltd\\Desktop\\shot.jpg");
        WebElement Login = driver.findElement(By.xpath("/html/body/html/body/div/div[2]/div/div/div/div/section/div/div/div[3]/div[2]/div[3]/button"));
        Action.performClick(driver, Login);
        Thread.sleep(5000);
        WebElement release = driver.findElement(By.linkText("Fall Release"));
        // WebElement release = driver.findElement(By.xpath("/html/body/html/body/div[4]/div[2]/div/div/div[1]/div/ul/li[2]/span/span"));
        release.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/html/body/div[4]/div[3]/div/div/div/c-rlmc-release/c-rlmc-allocation/div/div/div[1]/div[2]/div/div[1]/div/div/div/span[2]/p[2]/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"tab-1\"]/slot/table/tbody/tr[2]/td[4]/div/c-rlmc-select/div[1]/div/div/div/div[1]")).click();
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,200)");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"tab-1\"]/slot/table/tbody/tr[2]/td[4]/div/c-rlmc-select/div[1]/div/div/div/div[2]/div[2]")).click();
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,300)");
        Thread.sleep(5000);
        WebElement Next1 = driver.findElement(By.xpath("//*[@id=\"tab-1\"]/slot/div[2]/table/tbody/tr/td[4]/div/div/div/button"));
        Action.performClick(driver, Next1);
        Thread.sleep(3000);
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,300)");
        WebElement Next2 = driver.findElement(By.xpath("//*[@id=\"tab-2\"]/slot/div/table/tbody/tr/td[4]/div/div/div/button[2]"));
        Action.performClick(driver, Next2);
        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("window.scrollBy(0,300)");
        WebElement Continue = driver.findElement(By.xpath("//*[@id=\"tab-3\"]/slot/div/table/tbody/tr/td[4]/div/div/div/button[2]"));
        Action.performClick(driver, Continue);
        Thread.sleep(5000);
        JavascriptExecutor js5 = (JavascriptExecutor) driver;
        js5.executeScript("window.scrollBy(0,1200)");
        Thread.sleep(5000);
        WebElement radioButton = driver.findElement(By.xpath("/html/body/html/body/div[4]/div[3]/div/div/div/c-rlmc-checkout-order/div/section/div[1]/div/div[3]/div[3]/div/div[2]/div[1]/div/div/div[2]/div/div/div[1]/label/lightning-formatted-date-time"));
        radioButton.click();
        JavascriptExecutor js6 = (JavascriptExecutor) driver;
        js6.executeScript("window.scrollBy(0,1100)");
        Thread.sleep(5000);
        WebElement completeorder = driver.findElement(By.xpath("/html/body/html/body/div[4]/div[3]/div/div/div/c-rlmc-checkout-order/div/section/div[1]/div/div[3]/div[3]/div/div[4]/div[2]/a"));
        Action.performClick(driver, completeorder);
        driver.quit();
        //Fresh order ends



    }
}



