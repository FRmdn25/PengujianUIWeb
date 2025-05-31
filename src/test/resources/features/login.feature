Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters valid username and password
    And Clicks the login button
    Then User should be redirected to the inventory page

  Scenario: Login with invalid credentials
    Given User is on the login page
    When User enters invalid username and password
    And Clicks the login button
    Then An error message should be displayed

  Scenario: Login with empty username
    Given User is on the login page
    When User enters empty username and valid password
    And Clicks the login button
    Then An error message should be displayed