@ui @us9
Feature: As a user, I should be able to access to Files module.

  Background:
    When Navigate to login page
    And Enter valid username and password
    And Click login button


  Scenario: verify users can write comments to files/folders.
    When Click action-icon from any file on the page
    And Click details
    And Write a comment inside to the input box
    And Click the submit button to post it
    Then Verify the comment is displayed in the comment section.



    #(Pre-condition: there should be at least 1 file/folder is uploaded inside files page)
