@ui @us1
Feature: As a user, I should be able to login.

  Background:
    When Navigate to login page
    And Enter valid username and password
    And Click login button


  Scenario: user should be able to login with valid credentials

    Then Verify user on the dashboard