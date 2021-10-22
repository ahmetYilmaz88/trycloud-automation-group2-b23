@us14
Feature:
  As a user,
  I should be able to access search any item/ users from the homepage.
  Background:
    When Navigate to login page
    And Enter valid username and password
    And Click login button


  Scenario: Verify users can search any files/folder/users from the search box.
    //Given Login as a user
    When  Click magnifier icon on the right top
    And   Search any existing file/folder/user name
    Then  Verify the app displays the expected result option