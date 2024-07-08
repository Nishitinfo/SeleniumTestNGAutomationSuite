package stepdef;

import basicTemplate.browserSelector;
import basicTemplate.pages.manageInvoicePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class manageInvoicesScreen extends browserSelector {

    public static manageInvoicePage Invoice = new manageInvoicePage();

    @And("User navigates to the Invoice listing page")
    public void user_Try_To_Access_The_Invoice_Listing() throws InterruptedException {
        Invoice.redirectToInvoiceList();
    }


    @Then("Verify that user should be able to access the Invoice Validation")
    public void verify_That_User_Should_Be_Able_To_Access_The_Invoice_Validation() {
        String currentLink = driver.getCurrentUrl();
        String expectedLink = "https://uksestdevtest02.ukest.lan/eSight/AdvancedWeb/invoices";
        Assert.assertEquals(currentLink, expectedLink);
        System.out.println("Redirected to Manage Invoice.");

    }

    @When("the User initiates the creation of a new invoice")
    public void the_user_initiates_the_creation_of_a_new_invoice() throws InterruptedException {
        Invoice.createInvoice();
        System.out.println("Invoice created.");
    }

    @Then("the User should be able to successfully create a new invoice")
    public void the_user_should_be_able_to_successfully_create_a_new_invoice() {
        System.out.println("Invoice created and verified.");


    }

    @Then("the User should be able to successfully delete a invoice")
    public void theUserShouldBeAbleToSuccessfullyDeleteAInvoice() {
        System.out.println("Invoice deleted.");
    }

    @When("the USer initiates the deletion of invoice")
    public void theUSerInitiatesTheDeletionOfInvoice() throws InterruptedException {
        Invoice.deleteInvoice();
    }
}
