package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class DriverBase
{
    public static WebDriver driver = null;

    public static WebDriver Initialize(String browserName)
    {
        if(driver == null)
        {
            if(browserName.equals("chrome"))
            {
                // As SSL certificate got expired I used below to proceed to url
                DesiredCapabilities cap=DesiredCapabilities.chrome();
                cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                ChromeOptions c= new ChromeOptions();
                c.merge(cap);
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver(c);
            }
            else if (browserName.equals("firefox"))
            {
                DesiredCapabilities cap=DesiredCapabilities.firefox();
                cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                FirefoxOptions f= new FirefoxOptions();
                f.merge(cap);
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver(f);

            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void quit()
    {
        driver.quit();
        driver=null;
    }

    public static void close()
    {
        driver.close();
        driver=null;
    }


}
