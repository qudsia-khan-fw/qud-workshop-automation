package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//CO need 2 mandatory options, feature and glue
@CucumberOptions(
        features = "src/test/resources/login.feature",
        glue = {"StepDefinitions"}
)

public class Run extends AbstractTestNGCucumberTests {
}
