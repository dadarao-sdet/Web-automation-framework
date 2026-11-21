
Feature: Login functionality

  @TC01
  Scenario: Open SauceDemo application
    Given user opens the SauceDemo application
    When user enters valid username and password
    Then user should be successfully logged in
    And products should be displayed
