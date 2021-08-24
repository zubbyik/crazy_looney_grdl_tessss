Feature: Google search test
  This is a test for Google search

  Scenario: Finding Some Cheese
    Given I am on the Google search page
    When I search for "Cheese"
    Then the page title should start with cheese