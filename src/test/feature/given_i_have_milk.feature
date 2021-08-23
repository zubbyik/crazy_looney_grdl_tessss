Feature: Given I have milk

  Scenario: All done
    Given I am out shopping
    And I have eggs
    And I have milk
    And I have butter
    When I check my list
    Then I don't need anything