package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.DriverBase;

public class LoginStepDefs {

    @Given("I am on {string}")
    public void iAmOn(String url)
    {
        DriverBase.driver.get(url);
    }

    @When("I provide username as {string} and password as {string}")
    public void iProvideUsernameAsAndPasswordAs(String username, String password) throws InterruptedException {
        DriverBase.driver.findElement(By.name("userName")).sendKeys(username);
        DriverBase.driver.findElement(By.name("password")).sendKeys(password);
        DriverBase. driver.findElement(By.name("login")).click();

    }

    @Then("I should be able to login to tours")
    public void iShouldBeAbleToLoginToTours() {
        System.out.println("Title of the page is: " +DriverBase.driver.getTitle());
        Assert.assertEquals("Find a Flight: Mercury Tours:", DriverBase.driver.getTitle());
    }

    @And("I close the browser")
    public void iCloseTheBrowser()
    {

    }


}
