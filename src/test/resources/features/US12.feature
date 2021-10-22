@ui
Feature: As a user, I should be able to access to Contacts module.

  Background:
    Given Login as a user

  Scenario: users can access to Talks module
    When   click "Contacts" module
    Then Verify user on the "Contacts - Trycloud"





  Scenario: verify users can add contacts
    When   click "Contacts" module
    And Click New Contact button
    Then Fill out the contact info like : Title, Phone, email, address , etc
    And Verify the contact "July November" is added to the contact list