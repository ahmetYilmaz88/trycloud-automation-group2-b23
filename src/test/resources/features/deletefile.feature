@ui
Feature: As a user, I should be able to login to TryCloud app

  Background:
    Given user Navigate to login page

  @wip
  Scenario Outline: verify user can delete file/folder
    When user enter valid "<username>" and "password"
    And click login button
    When user clicks files module
    And user clicks on actions
    Then selects delete file

    Examples:
      | username |
      | User2    |
