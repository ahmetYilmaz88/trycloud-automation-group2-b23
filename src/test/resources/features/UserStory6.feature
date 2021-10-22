Feature: create and upload file

  As a user, I should be able to access to Files module.
  @fener
  Scenario: verify users can create a folder
    Given User is at the home page
    When login as a user
    And click the “+” icon on top
    And click “New Folder”
    Then write a folder name click and verify the folder is displayed on the page
@bahce
  Scenario: verify users can upload a file inside a folder
    Given User is at the home page
    When login as a user
    And click the “+” icon on top
    And click upload file
    Then upload and verify file