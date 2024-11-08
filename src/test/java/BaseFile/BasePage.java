package BaseFile;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public static void waitUntilPageLoad(WebDriver driver,int time) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time)).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }




}