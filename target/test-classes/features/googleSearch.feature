Feature: Searching Google should return the name of query
@GoogleSearch
  Scenario: Amazon search with scenario
    Given user launches Amazon webapp
    When user clicks on agree
    And enter button and search "sony wall mount bracket"
    Then results retrieved should contain the "sony wall mount bracket" used