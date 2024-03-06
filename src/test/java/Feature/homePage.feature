Feature: Verify user redirection on web application

  Scenario: Verify User is redirected to correct url
    Given Enter URL
    When Browser is Open
    Then User is redirected to URL

  Scenario: Verify User is able to access the eSight Portal
    Given User is redirected to URL
    When User enter the valid credentials of admin
    Then Verify User should be able to redirect to HomePage



