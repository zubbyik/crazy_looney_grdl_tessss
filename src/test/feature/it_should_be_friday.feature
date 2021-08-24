Feature: It should be friday
  The day of the week should be Friday

  Scenario Outline: Today should be or not Friday
    Given Today is "<Day>"
    When I ask whether it is Friday yet
    Then I should then be told the "<Answer>"

    Examples:
      | Day           | Answer |
      | Friday        | TGIF   |
      | Sunday        | Nope   |
      | anything else | Nope   |
