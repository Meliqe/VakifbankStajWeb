package utility;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver() {
        System.out.println("setDriver - Thread ID: " + Thread.currentThread().getId());

        driver.set(BrowserManager.createBrowser(Hooks.BROWSERNAME));
    }
    public static WebDriver getDriver() {
        System.out.println("getDriver - Thread ID: " + Thread.currentThread().getId());
        /*if (driver.get() == null) {
            setDriver();
        }*/
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
