@ui @us11
Feature: As a user, I should be able to access to Talks module.

  Background:
    When Navigate to login page
    And Enter valid username and password
    And Click login button
    When user click on Talks module


  Scenario: verify users can access to Talks module

    Then Verify the page title is Talks module’s title


  Scenario: verify users can send message

    And user search a user from search box
    When user write a message
    And user click the submit button
    Then Verify the message is displayed on the conversation log

    #(Pre-condition: there should be at least 1 file/folder is uploaded inside files page)
