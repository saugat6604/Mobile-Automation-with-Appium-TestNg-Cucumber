Feature: Signup

  Background:
    Given  user is in onboarding page
    And user verifies onboarding page
    And user clicks on signup button
    And user verifies signup page

    @TC014
  Scenario: "Verify user can signup in our app and check recheck status button"
    And user enter valid email
    And user enter strong password
    And user clicks Signup button
    And user clicks on recheck status button
    And user sees user not active message


  @TC019
  Scenario Outline: Verify if user can enter into homepage after certain tag selection and certain commitment
    And user enters email and password for signup and verify it using API
    And user clicks on signin button in Signup page
    And user enters  newly registered email and  strong password
    And user clicks on login button
    Then user verifies tag selection page
    And user verifies and select <tags> tags
    Then user clicks on next button
    And user verifies commitment page and select <time>
    And user clicks on finish button
    Then user select lets explore button and enter homepage

    Examples:
      | tags | time
      | 1    | 30 minutes
      | 2    | 2 hours
      | 3    | 6 hours


      #Test all tc 18  16 15
  Scenario Outline: "Verify if different email and password type user can again signup"
    And user enter <email_type> email
    And user enter <password_type> password
    And user clicks on signup button
    Then user verifies <message_type> validation messages
    Examples:
      | email_type       |  | password_type |  | message_type         |
      | already existing |  | strong        |  | already registered   |
      | valid            |  | weak          |  | weak password        |


  Scenario Outline: Verify user enter invalid email proper validation message shown
    And user enter <email_type> email
    Then user verifies <message_type> validation messages
    Examples:
      | email_type |    | message_type         |
      | invalid    |    | invalid signup email |




















