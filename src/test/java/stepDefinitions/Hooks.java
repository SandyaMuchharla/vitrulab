package stepDefinitions;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.DriverBase;

import java.io.File;
import java.io.IOException;

public class Hooks
{

    @Before(order = 0)
    public void setup()
    {
        DriverBase.Initialize(System.getProperty("browser"));
    }

    @After(order = 0)
    public void quit()
    {
        DriverBase.quit();
    }

    @Before(order = 1)
    public void beforeScenario(io.cucumber.core.api.Scenario scenario) {
        Reporter.assignAuthor("SM - Sandya Muchharla");
    }

    @After(order = 1)
    public void afterScenario(io.cucumber.core.api.Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                //This takes a screenshot from the driver at save it to the specified location
                File sourcePath = ((TakesScreenshot) DriverBase.Initialize(System.getProperty("browser"))).getScreenshotAs(OutputType.FILE);

                //Building up the destination path for the screenshot to save
                //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber/screenshots/" + screenshotName + ".png");

                //Copy taken screenshot from source location to destination location
                Files.copy(sourcePath, destinationPath);

                //This attach the specified screenshot to the test
                Reporter.addScreenCaptureFromPath(destinationPath.toString());
            } catch (IOException e) {
            }
        }
    }

}
