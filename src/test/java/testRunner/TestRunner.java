package testRunner;

import com.cucumber.listener.Reporter;
import dataProviders.FileReaderManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",
        glue="stepDefinations",tags="@SmokeTest1",monochrome=true,strict=true,
        plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber/report.html"})

public class TestRunner
{
    //plugin= {"pretty","html:target/cucumber","json:target/cucumber.json","junit:target/cukes.xml"}
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", "MAC OS" + "64 Bit");
        Reporter.setSystemInfo("Selenium", "3.14.0");
        Reporter.setSystemInfo("Maven", "3.6.2");
        Reporter.setSystemInfo("Java Version", "1.8.0_151");
    }
}
