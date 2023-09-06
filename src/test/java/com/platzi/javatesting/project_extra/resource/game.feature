Feature: Game Rock, Paper, or Scissors

  Scenario: The user wins when chooses rock and computer chooses scisoors
    Given the user will choose "rock"
    And the computer will choose "scissors"
    When they play
    Then the user wins

  Scenario: The user wins when chooses scissors and computer chooses paper
    Given the user will choose "scissors"
    And the computer will choose "paper"
    When they play
    Then verify that computer choose "paper"
    And the user wins