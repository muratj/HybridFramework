Feature: Login page

  Background:
    Given user is on login page

  Scenario: Login with a correct credentials
    When user enters "test@email.com" on the email field
    And user enters "te$t$tudent" on the password field
    And user clicks on Login button
    Then user successfully logged in
    And sign-out button is displayed

  Scenario: Login with a wrong credentials
    When user enters "test@email.com" on the email field
    And user enters "wrongPassword" on the password field
    And user clicks on Login button
    Then red frame is displayed
