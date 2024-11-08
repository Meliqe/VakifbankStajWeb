package utility;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    // ThreadLocal, her iş parçacığının sadece kendine özel bir WebDriver nesnesini almasını sağlar.
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public static void setDriver() {
        driver.set(BrowserManager.createBrowser(Hooks.BROWSERNAME));
    }
//driver.get() ifadesi, ThreadLocal yapısı sayesinde her iş parçacığını n kendi WebDriver nesnesine erişmesini sağlar.
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            setDriver();
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            try {
                driver.get().quit();
            } catch (Exception e) {
                System.out.println("Tarayıcı kapatma sırasında hata oluştu: " + e.getMessage());
            } finally {
                driver.remove();
            }
        }
    }
}
