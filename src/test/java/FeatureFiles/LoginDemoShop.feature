Feature: Login Demo WebShop

  Scenario: Login Demo Shop Account
    Given User is on login page
    When User enter valid email and password
    Then User should login successfully