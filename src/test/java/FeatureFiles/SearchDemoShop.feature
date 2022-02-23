Feature: Search on Demo WebShop

  Scenario Outline: Search items on Demo Shop
    Given User is main page
    When User enter "<searchItem>" on search label
    Then User should see the related results for "<resultItem>"
    Examples:
      | searchItem | resultItem |
      | computer   | computer   |
