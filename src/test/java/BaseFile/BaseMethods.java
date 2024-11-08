package BaseFile;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utility.DriverManager;
import java.util.List;

public class BaseMethods {

    protected WebDriver driver;
    private Actions actions;  // Actions nesnesini sınıf seviyesinde tanımlıyoruz

    public BaseMethods() {
        this.driver = DriverManager.getDriver();
        this.actions = new Actions(driver);  // Actions nesnesi yalnızca bir kez oluşturulur
    }

    public WebElement waitForElement(By locator) {
        return WaitUtils.waitUntilVisibleByLocator(driver, locator);
    }

    public void hoverElement(By locator) {
        WebElement element = waitForElement(locator);  // waitUntilVisibleByLocator kullanılıyor
        if (element != null) {
            actions.moveToElement(element).perform();
        }
    }

    public WebElement findElementHandlingStale(WebElement parent, By childLocator) {
        try {
            return parent.findElement(childLocator);  // Elementi bulmaya çalışıyoruz
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException yakalandı, elementi tekrar bulmaya çalışılıyor...");
            return waitForElement(childLocator);  // Tekrar dener
        }
    }

    public void printFirstProductInfo(By urunAdiLocator, By urunFiyatiLocator) {
        try {
            List<WebElement> urunler = driver.findElements(urunAdiLocator);
            if (!urunler.isEmpty()) {
                WebElement ilkUrun = urunler.get(0);

                WebElement urunIsmi = findElementHandlingStale(ilkUrun, urunAdiLocator);
                WebElement urunFiyati = findElementHandlingStale(ilkUrun, urunFiyatiLocator);

                if (urunIsmi != null && urunFiyati != null) {
                    System.out.println("İlk ürünün tam adı: " + urunIsmi.getText());
                    System.out.println("İlk ürünün fiyatı: " + urunFiyati.getText());
                }
            } else {
                System.out.println("Ürün bulunamadı.");
            }
        } catch (Exception e) {
            System.out.println("Bir hata oluştu: " + e.getMessage());
        }
    }
}