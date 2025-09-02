Feature: login feature
  Scenario: user can login with valid data
    Given user go to login page
    When user enters valid data
    And user click on login button
    Then user can login successfully