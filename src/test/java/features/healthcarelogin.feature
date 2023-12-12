Feature: Working on RLL Project

@RLL
  Scenario: Healthcare Page Login Test Using Cucumber
    Given User opens the Healthcare page in chrome
    Then User enters Following Username and Password
      | Username | password |
      | admin    | Admin123 |
    Then User choose the Location
    And User clicks On login
