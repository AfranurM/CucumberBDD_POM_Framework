Feature: Search on Demo WebShop

  Background:
    Given User is on login page
    When User enter valid email and password
    Then User should login successfully

  Scenario Outline: Search items on Demo Shop
    Given User is main page
    When User enter "<searchItem>" on search label
    Then User should see the related results for "<resultItem>"
    Examples:
      | searchItem | resultItem |
      | computer   | computer   |
