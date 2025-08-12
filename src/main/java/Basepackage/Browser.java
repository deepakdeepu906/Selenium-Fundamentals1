package Basepackage;

import org.example.Loginpage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;


import java.io.File;
import java.io.IOException;
import java.security.AuthProvider;
import java.time.Duration;

public class Browser implements  Constants{
   // public static Logger logger = Logger.getLogger("LoggerCreation".getClass());
    public static WebDriver driver;
    public static SoftAssert ast;
    public Loginpage login;
    public static Logger logger = Logger.getLogger("LoggerCreation".getClass());


    public static void  goTo(String url){
        driver.get(url);
    }



@BeforeTest
public void getBrowser() throws Exception {
    if ("chrome".equalsIgnoreCase("Firefox")) {
        try {
            if (browser.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "Resources/version_21/geckodriver.exe");
                logger.info("Connecting to Firefox browser");
                driver = new FirefoxDriver();
                logger.info("Opened Firefox Browser");

            } else if (browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "Resources/version_21/chromedriver.exe");
                logger.info("Connecting to Chrome browser");
                driver = new ChromeDriver();
                logger.info("Opened Chrome Browser");

            } else if (browser.equalsIgnoreCase("Ie")) {
                System.setProperty("webdriver.ie.driver", "Resources/ie/IEDriverServer.exe");
                logger.info("Connecting to Internet Explorer browser");
                driver = new InternetExplorerDriver();
                logger.info("Opened Internet Explorer Browser");

            } else {
                logger.error("Browser details not found");
                ast.assertTrue(false, "Browser details not found");
                return;
            }

            // Maximize and navigate to URL
            logger.info("Maximizing browser window");
            driver.manage().window().maximize();

            logger.info("Navigating to URL");
            driver.navigate().to("https://realmcellars--qa.sandbox.my.site.com/realmcellars/s/login/");
            logger.info("Connected to URL");

            // Initialize LoginPage and perform login
            this.login = PageFactory.initElements(driver, Loginpage.class);
            this.Login.lines();

        } catch (Exception e) {
            logger.error("Exception during browser setup or navigation: " + e.getMessage(), e);
            ast.assertTrue(false, "Exception during setup: " + e.getMessage());
        }
    }
}




    public static WebDriver newChromeDriver() {
        WebDriver driver = new ChromeDriver();
        return applyCommonSetup(newChromeDriver());


    }

    public static WebDriver newEdgeDriver() {
        WebDriver driver = new EdgeDriver();
        return applyCommonSetup(newEdgeDriver());

    }

    public static WebDriver applyCommonSetup(WebDriver driver){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        return driver;
    }

    public static void performClick(WebDriver driver, WebElement elementToClick) {
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToClick).click().perform();

    }


    public static void takeScreenshot(WebDriver driver, String filePath) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File(filePath);
            try {
                FileHandler.copy(src, dest);
                System.out.println("Screenshot saved to: " + filePath);
            } catch (IOException e) {
                System.out.println("Error while saving screenshot: " + e.getMessage());
            }
        }
}



