package stepDefinitions;

import BaseFile.BaseMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.DriverManager;

public class HepsiburadaStepDefinitions {
    WebDriver driver;
    public HepsiburadaStepDefinitions() {
        driver = DriverManager.getDriver();
    }

    @Given("Kullanıcı Hepsiburada sitesine gider")
    public void kullanıcı_Hepsiburada_sitesine_gider() {
        driver.get("https://www.hepsiburada.com");
    }

    @When("Kullanıcı {string} menüsüne gelir")
    public void kullanıcı_Elektronik_menüsüne_gelir(String locatorName) {
        BaseMethods baseMethods = new BaseMethods();
        baseMethods.hoverElement(locatorName);
    }

    @And("Kullanıcı {string} kısmına gelir")
    public void kullanıcı_Telefon_ve_Aksesuarlarına_gelir(String locatorName) {
        BaseMethods baseMethods = new BaseMethods();
        baseMethods.hoverElement(locatorName);
    }

    @And("Kullanıcı {string} kategorisine tıklar")
    public void kullanıcı_Samsung_kategorisine_tıklar(String locatorName) {
        BaseMethods baseMethods = new BaseMethods();
        baseMethods.click(locatorName);
    }

    @Then("Kullanıcı ilk {string} ve {string} ekrana yazdırır")
    public void kullanıcı_ilk_ürünü_ve_fiyatını_yazdırır(String urunAdiLocator, String urunFiyatiLocator) {
        BaseMethods baseMethods = new BaseMethods();
        baseMethods.printFirstProductInfo(urunAdiLocator,urunFiyatiLocator);
    }
}
