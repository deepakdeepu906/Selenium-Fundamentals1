package Basepackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static Basepackage.Browser.ast;
import static Basepackage.Browser.driver;

public class WebDrivercommonlib extends  Browser {
    public Alert alt;
    public static String parentWindow = null;
    public static String value;
    static Random random = new Random();
    public static String output;


    public void waitforpageload() {
        try {
            logger.info("Waiting for page to load");
            driver.manage().timeouts().implicitlyWait(5000L, TimeUnit.SECONDS);
            logger.info("page to load completed");
        } catch (Exception e) {
            ast.assertTrue(false, "Message: " + e.getMessage());
        }

    }

    public void acceptAlert() {
        try {
            this.alt = driver.switchTo().alert();
            this.alt.accept();
            logger.info("Alert Accepted");
        } catch (Exception var2) {
            ast.assertTrue(false, "Unable to accept Alert Message");
        }

    }



    public static void entervalue(String value, WebElement element) {
        if (IsElementPresent(element)) {
            highLightElement(driver, element);
            element.clear();
            element.sendKeys(new CharSequence[]{value});
            logger.info("Entered value is " + value);
        } else {
            ast.assertTrue(false, "Unable to enter value on element ");
            logger.error("Unable to enter value on element ");
        }


    }

    public static void enterNumvalue(String value, WebElement element, WebDriver driver) {
        if (IsElementPresent(element)) {
            highLightElement(driver, element);
            element.clear();
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].value=" + value + ";", new Object[]{element});
            logger.info("Entered value is " + value);
        } else {
            ast.assertTrue(false, "Unable to enter value on element ");
            logger.error("Unable to enter value on element ");
        }

    }

    private static boolean IsElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            ast.assertTrue(false, "Element not found" + e.getMessage());
            return false;
        }
    }

    private static void highLightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;

        try {
            js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid black;');", new Object[]{element});
            js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", new Object[]{element});
        } catch (Exception e) {
            ast.assertTrue(false, "Message: " + e.getMessage());
        }

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



    public static String AutoNumericvalue(int range) {
        if (range > 0) {
            StringBuilder sb1 = new StringBuilder();
            char[] chars = "123456789".toCharArray();

            for(int i = 0; i < range; ++i) {
                char c = chars[random.nextInt(chars.length)];
                sb1.append(c);
            }

            output = sb1.toString();
        } else {
            ast.assertTrue(false, "Input Range should be >0");
        }

        return output;
    }




    public static void buttonClick(WebElement element) {
        if (element.isEnabled()) {
            highLightElement(driver, element);
            element.click();
        } else {
            ast.assertTrue(false, "Unable to Click on element");
            logger.error("Unable to Click on element");
        }

    }


}






