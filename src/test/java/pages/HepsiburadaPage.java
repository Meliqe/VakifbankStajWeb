package pages;
import org.openqa.selenium.By;
import BaseFile.BaseMethods;
import utility.DriverManager;

public class HepsiburadaPage extends BaseMethods {

    // Sabit XPath'ler
    private static final By ELEKTRONIK_MENU = By.xpath("//span[text()='Elektronik']");
    private static final By TELEFON_AKSESUAR_MENU = By.xpath("//a[contains(text(), 'Telefon & Telefon Aksesuarları')]");
    private static final By SAMSUNG_CATEGORY = By.xpath("//a[contains(@href, '/samsung-android-telefonlar-xc-60005201')]//span[text()='Samsung']");
    private static final By URUN_ADI = By.xpath("//h3[@data-test-id='product-card-name']");
    private static final By URUN_FIYATI = By.xpath("//div[@data-test-id='price-current-price']");

    public HepsiburadaPage() {
        super();  // BaseMethods'daki driver ve metodları kullan
    }

    public void goToElectronicsMenu() {
        hoverElement(ELEKTRONIK_MENU);
    }

    public void goToPhoneAccessoriesMenu() {
        hoverElement(TELEFON_AKSESUAR_MENU);
    }

    public void clickSamsungCategory() {
        waitForElement(SAMSUNG_CATEGORY).click();
    }

    public void printFirstProductInfo() {
        super.printFirstProductInfo(URUN_ADI, URUN_FIYATI);
    }

}
