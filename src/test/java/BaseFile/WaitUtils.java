package BaseFile;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class WaitUtils {

    public static WebElement waitUntilVisibleByLocator(WebDriver driver, By locator) {
        WebElement element = null;
        try {
            element = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(80))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Element bulunamadı: " + e.getMessage());
        }
        return element;
    }
}
