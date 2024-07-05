Feature: Login using implicit wait
  Scenario: Setting an implicit wait for 10 seconds
    Given the user is on the SwagLabs page
    When the user logs in on the page
    Then the user is redirected to the page products