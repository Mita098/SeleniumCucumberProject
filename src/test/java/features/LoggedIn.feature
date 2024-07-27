Feature: LoggedIn User View

  Scenario: Validate user is able to view after Login
    Given User navigates to the Login page
    When User successfully enters the log details
    Then User should be able to view portfolio page
