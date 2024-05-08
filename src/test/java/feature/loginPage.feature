Feature: Validate User Redirection and Functionality in MRI Energy Web Application Login feature

  @Priority=0
  Scenario: Verify User is redirected to correct URL
    Given Enter URL
    When Browser is Open
    Then User is redirected to the application's URL

  @Priority=1
  Scenario: Verify User is able to access the MRI Energy application
    Given User is redirected to the application's URL
    When User enter the valid credentials of admin
    Then Verify User should be able to redirect to HomePage

