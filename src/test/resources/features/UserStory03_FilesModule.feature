@ui
  Feature:As a user, I should be able to access to Files module.

    #AC1
    Scenario: Users can access to Files module
      Given user is at the dashboard page
      When  user click the files module
      Then  page title should be "Files - Trycloud"

     #AC2
    Scenario: Users can select all uploaded files from the page
      Given user is at the Trycloud page
      When user click the checkbox of the table
      Then all the files should be selected
//