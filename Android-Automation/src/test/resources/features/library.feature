Feature: Library

  Background:
    Given  user is in onboarding page
    And user verifies onboarding page
    And user clicks on signup button
    And user verifies signup page
    And user enters email and password for signup and verify it using API
    And user clicks on signin button in Signup page

  @library
  #TC-001
  Scenario Outline: Verify that user logins in to the good vibes and favorite tracks/unfavorite track
    And user enters  newly registered email and  strong password
    And user clicks on login button
    Then user verifies tag selection page
    And user verifies and select <tags> tags
    Then user clicks on next button
    And user verifies commitment page and select <time>
    And user clicks on finish button
    Then user select lets explore button and enter homepage
    And user scroll in the homepage
    And user scroll in the homepage
    And user open track from New Release
    And user open track from New Release
    And user clicks ads close button
    And user clicks on favorite button
    And user verifies track favorite success message
    And user clicks on favorite button
    And user verifies favorite popup modal displayed
    And user clicks on Yes button of favorite model
    Then user verifies track unfavorite sucess message
    Examples:
      | tags | time       |
      | 1    | 30 minutes |


  @library
    #TC-002
  Scenario Outline: Verify that user favorites track stored in favorite list
    And user enters  newly registered email and  strong password
    And user clicks on login button
    Then user verifies tag selection page
    And user verifies and select <tags> tags
    Then user clicks on next button
    And user verifies commitment page and select <time>
    And user clicks on finish button
    Then user select lets explore button and enter homepage
    And user scroll in the homepage
    And user scroll in the homepage
    And user open track from New Release
    And user open track from New Release
    And user clicks ads close button
    And user clicks on favorite button
    And user verifies track favorite success message
    And user saves track name
    And user clicks navigate back button
#    And user clicks on library
#    Then user verifies Track name in favorite list
    Examples:
      | tags | time       |
      | 1    | 30 minutes |











