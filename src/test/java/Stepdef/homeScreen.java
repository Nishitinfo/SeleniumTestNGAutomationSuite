package Stepdef;

import basicTemplate.browserSelector;
import basicTemplate.pages.homePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class homeScreen extends browserSelector {

    static homePage Obj = new homePage();

    @Given("Enter URL")
    public void verifyURL() {
        System.out.println("Enter URL");
    }

    @When("Browser is Open")
    public void verifyBrowser() {
        Obj.verifyHomePage();
        System.out.println("Browser is open");
    }

    @Then("User is redirected to URL")
    public void verifyRedirection() {
        System.out.println("User is redirected to URL");
    }
}
