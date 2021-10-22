Feature: As a user, I should be able to login to TryCloud app

  Background:
    Given user Navigate to login page

  @wip
  Scenario Outline: user login successfully with valid credentials
    When user enter valid "<username>" and "password"
    And click login button
    Then Verify user on the "Dashboard - Trycloud"

    Examples:
      | username |
      | User2    |
      | User32   |
      | User62   |
      | User92   |


  Scenario Outline: user login fails with invalid credentials
    When user enter valid "<username>" invalid "wrong password"
    And click login button
    Then message "Wrong username or password." should be displayed

    Examples:
      | username |
      | User2    |
      | User32   |
      | User62   |
      | User92   |