package stepdef;

import basicTemplate.browserSelector;
import basicTemplate.pages.loginPage;
import basicTemplate.utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class loginScreen extends browserSelector {

    static loginPage Obj = new loginPage();
    String title;

    @Given("Enter URL")
    public void verifyURL() {
        System.out.println("Enter URL");
        driver.get(URL);

    }

    @When("Browser is Open")
    public void verifyBrowser() {
        if (driver != null) {
            System.out.println("Browser is open");
        } else {
            System.out.println("Browser not opened");
        }


    }

    @Then("User is redirected to the application's URL")
    public void verifyRedirection() {
        System.out.println("Verify User is redirected to URL");
        title = driver.getTitle();
        Assert.assertEquals(title, "Login - MRI Energy");
    }


    @When("User enter the valid credentials of admin")
    public void userEnterTheValidCredentialsOfAdmin() {
        loginPage.login();
    }

    @Then("Verify User should be able to redirect to HomePage")
    public void verifyUserShouldBeAbleToRedirectToHomePage() {
        utils.isElementPresent(Obj.UserIcon);

    }
}
