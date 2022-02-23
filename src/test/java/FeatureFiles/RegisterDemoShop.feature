Feature: Register Demo Web Shop

  Scenario: Register account
    Given User is on main register page
    When User enter credentials as input
    Then User should register successfully