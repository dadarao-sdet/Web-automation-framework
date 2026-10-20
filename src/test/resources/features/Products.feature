Feature: Products functionality

  Scenario: Verify products are displayed
    Given user opens the SauceDemo application
    When user enters valid username and password
    Then products should be displayed


  Scenario: Verify product details are displayed
    Given user opens the SauceDemo application
    When user enters valid username and password
    And user selects a product
    Then product details should be displayed