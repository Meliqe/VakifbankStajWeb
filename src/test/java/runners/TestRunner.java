// JUnitRunner.java
package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "utility"},
        plugin = {"pretty", "html:target/junit-reports"},
        monochrome = true,
        tags = "@hepsiburada"

)
public class TestRunner {
}
