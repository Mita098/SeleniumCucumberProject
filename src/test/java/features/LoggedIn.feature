Feature: LoggedIn User View

  Scenario: Validate user is able to view after Login
    Given User navigates to the Login page
    When User enters email address
    And User clicks continue button
    And User enters password
    And User clicks continue button
    And User enters 2FA code
    And User clicks submit button
    Then User should be able to view portfolio page

  Scenario: Validate error message for invalid email
    Given User navigates to the Login page
    When User enters invalid email address
    And User clicks continue button
    Then User should see an error message for invalid email

  Scenario: Validate error message for invalid password
    Given User navigates to the Login page
    When User enters valid email address
    And User clicks continue button
    And User enters invalid password
    And User clicks continue button
    Then User should see an error message for invalid password

