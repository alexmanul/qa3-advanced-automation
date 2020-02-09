@REST @SmokeTest
Feature: QA3 - Advanced Automation. REST.

  Scenario: REST02. Creates new, creates another deck and validates that decks are unique
    When I shuffle a deck
    And I validate that deck has all parameters
    And I shuffle another deck
    Then I validate that deck is unique