@tag
Feature: Customer Profile scenarios

  @customer
  Scenario Outline: As a user I want to edit customer profile
    Given user opens the app
    When user login using $<number>
    Then user clicks on Customer Profile
    And user clicks on Plus icon
    And user clicks on edit customer profile button
    And user fills customer details
    Then user clicks on save button

    Examples: 
      | number  |
      | 9478512546 |