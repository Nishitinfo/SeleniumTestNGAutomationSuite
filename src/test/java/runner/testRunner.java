package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/feature"},
        glue = {"stepdef"},
        plugin = {"pretty", "json:target/json-report/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",},
        publish = true)
public class testRunner extends AbstractTestNGCucumberTests {


}
