package BaseFile;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utility.DriverManager;
import utility.LocatorUtils;

import java.util.List;


public class BaseMethods {

    protected WebDriver driver;
    private Actions actions;
    private BasePage basePage;

    public BaseMethods() {
        this.driver = DriverManager.getDriver();
        this.actions = new Actions(driver);
        this.basePage = new BasePage();
    }

    public void click(String locatorKey) {
        try{
            By locator = LocatorUtils.getLocator(locatorKey);
            WebElement element =basePage.waitForElement(locator);
            element.click();
        }
        catch(Exception e){
            e.printStackTrace();
            throw new AssertionError("Hata oluştu (click): " + e.getMessage());
        }
    }

    public void hoverElement(String locatorKey) {
        try{
            By locator = LocatorUtils.getLocator(locatorKey);
            WebElement element =basePage.waitForElement(locator);
            actions.moveToElement(element).perform();
        }
        catch(Exception e){
            e.printStackTrace();
            throw new AssertionError("Hata oluştu (hover): " + e.getMessage());
        }
    }

    public void printFirstProductInfo(String urunAdiLocatorKey, String urunFiyatiLocatorKey) {
        try {
            By urunAdiLocator = LocatorUtils.getLocator(urunAdiLocatorKey);
            By urunFiyatiLocator = LocatorUtils.getLocator(urunFiyatiLocatorKey);

            List<WebElement> urunler = driver.findElements(urunAdiLocator);
            if (!urunler.isEmpty()) {
                WebElement ilkUrun = urunler.get(0);

                WebElement urunIsmi = basePage.findElementHandlingStale(ilkUrun, urunAdiLocator);
                WebElement urunFiyati =basePage.findElementHandlingStale(ilkUrun, urunFiyatiLocator);

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