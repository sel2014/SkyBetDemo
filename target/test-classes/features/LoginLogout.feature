Feature: Login Function
  User Story:
  As a user of the SkyBet website,
  I want to be able to login to my account,
  So that I can access my account information and place bets.

  Background:
    Given I am on the SkyBet website


  Scenario: User Login
    When I click on the Login button
    And I enter valid credentials
    And I click on the second Log in button
    Then the page title should be "Online Sports Betting & Odds | Bet with Sky Bet"











