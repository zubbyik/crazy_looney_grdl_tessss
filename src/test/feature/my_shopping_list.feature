Feature: My shopping list when I am in Town
  This a description of the Items that I might likely but when in Town

  Scenario Outline: This are my Item Lists
    Given I am in "<Town>"
    When I go to the Marks and Spencer
    Then I am expected to buy "<item>"

    Examples:
      | Town          | item        |
      | London        | Avocado     |
      | Manchester    | Orange      |
      | Wolverhampton | Pomegranate |
      | Luton         | Apple       |