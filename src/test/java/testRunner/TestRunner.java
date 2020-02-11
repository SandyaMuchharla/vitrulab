package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(monochrome = true,
        plugin = {"progress", "html:target/cucumber"},
        features = "src/test/java/features/",
        glue = {"stepDefinitions"},
        tags = "@login")

public class TestRunner {
}
