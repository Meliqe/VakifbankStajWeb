package BaseFile;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.DriverManager;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    public BasePage() {
        driver = DriverManager.getDriver();
    }

    public static void waitUntilPageLoad(WebDriver driver,int time) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time)).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public WebElement waitForElement(By locator) {
        return WaitUtils.waitUntilVisibleByLocator(driver, locator);
    }

    public WebElement findElementHandlingStale(WebElement parent, By childLocator) {
        try {
            return parent.findElement(childLocator);
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException yakalandı, elementi tekrar bulmaya çalışılıyor...");
            return waitForElement(childLocator);
        }
    }



}