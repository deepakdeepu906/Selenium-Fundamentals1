package org.example;

import Action.Action;
import Basepackage.WebDrivercommonlib;

import com.azul.crs.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static Basepackage.Browser.ast;
import static Basepackage.Browser.driver;
import static Basepackage.WebDrivercommonlib.buttonClick;
import static Basepackage.WebDrivercommonlib.entervalue;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Loginpage extends  WebDrivercommonlib {

  /* WebDriver driver;

   WebDrivercommonlib wcl = new WebDrivercommonlib();


    @CacheLookup
    private WebElement username;
    @FindBy(
      how = How.ID,
      using = "name"

    )



    @CacheLookup
    private WebElement password;
    @FindBy(
      how = How.ID,
      using = "cred"
    )


    @CacheLookup
    private WebElement Login;
    @FindBy(
         how = How.ID,
        using = "LoginBtn"
    )


    private WebElement login;

    public loginpage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterUserName(String uname) {
        entervalue(uname, this.username);
    }

    public void enterPassword(String pass) { entervalue(pass,this.password);}

    public void clickLoginBtn() {
        buttonClick(this.login);
    }

    }

        public void login(String uname, String pass) {
            Logger logger;
            try {
                waitforpageload();
                Thread.sleep(500L);
                buttonClick(this.login);


                Logger.info("Login Started");
                entervalue(uname, this.username);
                entervalue(pass, this.password);
                clickLoginBtn();
            } catch (Exception e) {
                ast.assertTrue(false, "Unable to Login");
                logger.error("Login Failed " + e.getMessage());
            }

        }

        private String acceptAlert() {
            try {
                this.alt = driver.switchTo().alert();
                this.alt.getText();
                logger.info("Alert Message " + this.alt.getText());
            } catch (Exception var2) {
                ast.assertTrue(false, "Unable to Retrive Alert Message");
            }

            return this.alt.getText();
        }

        public void dismissAlert() {
            try {
                this.alt = driver.switchTo().alert();
                this.alt.dismiss();
                logger.info("Alert Dismissed");
            } catch (Exception var2) {
                ast.assertTrue(false, "Unable to dismiss Alert Message");
            }

        }
        }


        private Collection<Object> getAlertmsg() {
            try {
                this.alt = driver.switchTo().alert();
                this.alt.getText();
                logger.info("Alert Message " + this.alt.getText());
            } catch (Exception var2) {
                ast.assertTrue(false, "Unable to Retrive Alert Message");
            }

            return Collections.singleton(this.alt.getText());

        }

        private void waitforpageload() {
            try {
                logger.info("Waiting for page to load");
                driver.manage().timeouts().implicitlyWait(5000L, TimeUnit.SECONDS);
                logger.info("page to load completed");
            } catch (Exception e) {
                ast.assertTrue(false, "Message: " + e.getMessage());
            }

        }

        void main() {
        }

        private WebElement login;
        private Alert alt;
        private WebElement username;
        private WebElement password;


*/








  @BeforeClass
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
        driver.get("https://realmcellars--qa.sandbox.my.site.com/realmcellars/s/login/");
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(5000);
        WebElement usernameclick1 = driver.findElement(By.id("409:0"));
        usernameclick1.click();
        usernameclick1.sendKeys("deepak.p1@v2force.com");
        Thread.sleep(5000);
        WebElement password = driver.findElement(By.id("423:0"));
        password.click();
        password.sendKeys("Realmtest@123");
        Thread.sleep(10000);
        takeScreenshot(driver, System.getProperty("user.dir") + "C:\\Users\\deepak.p.V2SOLUTIONS\\OneDrive - V2 Tech Ventures Pvt Ltd\\Desktop\\shot.jpg");
        WebElement Login = driver.findElement(By.xpath("/html/body/html/body/div/div[2]/div/div/div/div/section/div/div/div[3]/div[2]/div[3]/button"));
        Action.performClick(driver, Login);
        Thread.sleep(5000);
        WebElement release = driver.findElement(By.linkText("Fall Release"));
        // WebElement release = driver.findElement(By.xpath("/html/body/html/body/div[4]/div[2]/div/div/div[1]/div/ul/li[2]/span/span"));
        release.click();

        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : browserLogs) {
            System.out.println("CONSOLE LOG: " + entry.getLevel() + " " + entry.getMessage());
        }


        File f = new File(System.getProperty("user.dir") + "C:\\Users\\deepak.p.V2SOLUTIONS\\OneDrive - V2 Tech Ventures Pvt Ltd\\Desktop\\shot.jpg");
        if (f.exists()) {
            System.out.println("Screenshot saved successfully.");
        } else {
            System.out.println("Screenshot not found.");
        }

        Thread.sleep(3000);
        driver.quit();


    }
}






