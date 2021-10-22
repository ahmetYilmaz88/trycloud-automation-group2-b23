@ui
Feature: Files Module should work as expected

  As a user, I should be able to access to Files module

  Scenario: User can add a file to favorites
    Given I login as a user
    When I click action-icon from any file on the page
    And choose Add to Favorite option
    And click Favorites sub-module on the list side
    Then verify the chosen file is listed on the table
#    #pre condition: there should be at least 1 file is uploaded

