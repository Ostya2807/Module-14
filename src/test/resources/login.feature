Feature: Login functionality
  As a user
  I want to log in to the application
  So that I can access the dashboard

  Background:
    Given user is on login page

  Scenario Outline: Login attempts with different credentials
    When user logs in with username "<username>" and password "<password>"
    Then user should see "<expectedResult>"

    Examples:
      | username       | password       | expectedResult    |
      | standard_user  | secret_sauce  | products          |
      | standard_user  | wrong_pass    | error message     |
      | wrong_user     | secret_sauce  | error message     |
