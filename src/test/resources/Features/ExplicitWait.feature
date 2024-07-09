@Explicit
Feature: Login with explicit wait and expected conditions
  Scenario: setting visibiliy conditions to interact with the elements
    Given The user is on the Swag Labs page
    When the user interacts with any of the elements, those are already visible
    Then the user is sent to the options page

