@ui @us2
Feature: As a user, I should be access all the main modules of the app.

  Background:
    When Navigate to login page
    And Enter valid username and password
    And Click login button

  Scenario:

    Then Verify the user see the following modules

      |Dashboard|
      |Files    |
      |Photos   |
      |Activity |
      |Talk     |
      |Contacts |
      |Circles  |
      |Calendar |
      |Deck     |