Feature: Signin

  Background:
    Given  user is in onboarding page
    And user verifies onboarding page
    And user clicks on signin button

  #TC-001
  Scenario: Verify that user logins in to the good vibes app with valid credentials
    And user enters  correct username and  correct password
    And user clicks on login button
    And user select lets explore button and enter homepage

   #TC-002
  Scenario: Verify user login with incorrect password and correct email
    And user enters  correct username and  incorrect password
    And user clicks on login button
    Then user verifies incorrect password validation messages

     #TC-003
  Scenario: Verify user login with both incorrect password and email
    And user enters  incorrect username and  incorrect password
    And user clicks on login button
    Then user verifies unregistered user validation messages

   #TC-004
  Scenario: Verify user login with  correct email and empty password
    And user enters correct email
    And user checks if login button is unclickable


    #TC-005
  Scenario:Verify user login with correct password and empty email
    And user enters correct password
    And user checks if login button is unclickable
    Then user verifies empty email validation messages

    #TC-006
  Scenario: Verify user login with empty password and empty email
    And user checks if login button is unclickable

  #TC-007 (Need to fix this in mobile for validation message
  Scenario: Verify user cannot login with invalid email
    And user enters  invalid email and  incorrect password
    And user clicks on login button
    Then user verifies  validation messages

    #TC-008
  Scenario: Verify user forgot password button working

  #TC-007
  Scenario: Verify that user social logins through google/fb/apple(manual)














