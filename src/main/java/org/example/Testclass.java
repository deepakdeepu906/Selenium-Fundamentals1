package org.example;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static Basepackage.Browser.newChromeDriver;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Testclass {
    WebDriver driver;


    @VisibleForTesting
    public void initDriver(){
        WebDriver driver = newChromeDriver();

    }

    @VisibleForTesting
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://realmcellars--qa.sandbox.my.site.com/realmcellars/s/login/");
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(5000);
        WebElement usernameclick1 =  driver.findElement(By.id("409:0"));
        usernameclick1.click();



    }
}
