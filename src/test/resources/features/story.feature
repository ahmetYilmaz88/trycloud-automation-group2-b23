@ui @us10
#User story 10: As a user, I should be able to update settings.
Feature: As a user, I should be able to update settings

  Background:
    When Navigate to login page
    And Enter valid username and password
    And Click login button
    When User click file module


  #AC1: verify users can change the app Settings
    Scenario: verify users can change the app Settings

      And Click Settings on the left bottom corner
      Then Verify user can click any checkboxes




  #AC2: verify users see the app storage usage
      Scenario: verify users see the app storage usage
        When Check the current storage usage
        And Upload a file
        And Refresh the page
        Then Verify the storage usage is increased


