package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HepsiburadaPage;
import utility.DriverManager;

public class HepsiburadaStepDefinitions {
    WebDriver driver;
    public HepsiburadaStepDefinitions() {
        driver = DriverManager.getDriver();
    }

    HepsiburadaPage hepsiburadaPage = new HepsiburadaPage();

    @Given("Kullanıcı Hepsiburada sitesine gider")
    public void kullanıcı_Hepsiburada_sitesine_gider() {
        driver.get("https://www.hepsiburada.com");
    }

    @When("Kullanıcı Elektronik menüsüne gelir")
    public void kullanıcı_Elektronik_menüsüne_gelir() {
        hepsiburadaPage.goToElectronicsMenu();
    }

    @And("Kullanıcı Telefon & Telefon Aksesuarları kısmına gelir")
    public void kullanıcı_Telefon_ve_Aksesuarlarına_gelir() {
        hepsiburadaPage.goToPhoneAccessoriesMenu();
    }

    @And("Kullanıcı Samsung kategorisine tıklar")
    public void kullanıcı_Samsung_kategorisine_tıklar() {
        hepsiburadaPage.clickSamsungCategory();
    }

    @Then("Kullanıcı ilk ürünü ve fiyatını ekrana yazdırır")
    public void kullanıcı_ilk_ürünü_ve_fiyatını_yazdırır() {
        hepsiburadaPage.printFirstProductInfo();
    }
}
