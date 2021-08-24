@foo
Feature: The List of Animals

  Scenario: The First test case
    Given A List of animals:
      | Cow   |
      | Dog   |
      | Sheep |
      | Goat  |
    When I count the Animals
    Then The animals should be 4