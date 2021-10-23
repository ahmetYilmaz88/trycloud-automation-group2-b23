@ui
#User story 5: As a user, I should be able to able to access to Files module.
Feature: As a user, I should be able to able to access to Files module.

  Background:
    Given user at the homepage


  @wip2
 #AC1: verify users can remove a file from favorites.
   Scenario: verify user can remove a file from favorites

    When user click "Files" module
    And user click action-icon from any file on the page
    When user click “Remove from Favorites” option
    Then verify that the file is removed from Favorites sub-module’s table

@wip2
#AC2: verify users can upload a file directly to the homepage (File-Uploading)
  Scenario: verify user can upload a file directly to the homepage (File-Uploading)

    When user click "Files" module
    And user click "+" icon on the top
    When user upload a file
    Then verify the file is displayed on the page


