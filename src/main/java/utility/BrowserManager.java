package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserManager {

    public static WebDriver createBrowser(String browserType) {
        WebDriver driver;

        String chromeDriverPath = ConfigReader.getProperty("chrome.driver.path");
        String firefoxDriverPath = ConfigReader.getProperty("firefox.driver.path");

        switch (browserType.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new IllegalArgumentException("Geçersiz tarayıcı türü: " + browserType);
        }
        return driver;
    }
}
