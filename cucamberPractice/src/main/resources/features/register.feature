Feature: register feature.
  Scenario: user can register with valid data successfully
    Given user go to register page
    When user enter valid email and password
    And user click on submit button
    Then user can register successfully