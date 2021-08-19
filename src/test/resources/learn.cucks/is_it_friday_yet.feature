Feature: Is it Friday Yet?
  Everyone wants to know if its friday

  Scenario: Sunday isn't Friday
    Given Today is Sunday
    When I ask whether it's Friday Yet?
    Then I should be told "Nope"