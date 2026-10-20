Feature: Cart functionality

  Scenario: Add product to cart and verify product
    Given user opens the SauceDemo application
    When user enters valid username and password
    And user adds a product to the cart
    Then product should be added to the cart
    When user opens the cart
    Then product should be visible in the cart