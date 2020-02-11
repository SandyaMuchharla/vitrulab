package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utilities.DriverBase;

public class Hooks
{

    @Before
    public void setup()
    {
        DriverBase.Initialize(System.getProperty("browser"));
    }

    @After
    public void quit()
    {
        DriverBase.quit();
    }

}
