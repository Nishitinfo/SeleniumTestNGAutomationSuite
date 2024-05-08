Feature: Validate User Redirection and Functionality in MRI Energy Web Application for Invoice Validation feature

  @Priority=2
  Scenario: Verify that user is able to access Invoice Validation
    Given User is redirected to the application's URL
    When User navigates to the Invoice listing page
    Then Verify that user should be able to access the Invoice Validation

  @Priority=3
  Scenario: Creating a new invoice
    Given User is redirected to the application's URL
    And User navigates to the Invoice listing page
    When the User initiates the creation of a new invoice
    Then the User should be able to successfully create a new invoice

  @Priority=4
  Scenario: Deleting invoice
    Given User navigates to the Invoice listing page
    When the USer initiates the deletion of invoice
    Then the User should be able to successfully delete a invoice