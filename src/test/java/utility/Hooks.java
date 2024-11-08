// Hooks.java
package utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;
    public static String BROWSERNAME="";

    public void initialise(){
        BROWSERNAME = ConfigReader.getProperty("browserName");
    }

    @Before
    public void setUp() {
        initialise();
        DriverManager.setDriver();
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        System.out.println("Test sonrasında driver kapanacak...");
        DriverManager.quitDriver();
    }
}
