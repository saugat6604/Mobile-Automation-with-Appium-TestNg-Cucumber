
Feature: Session
  #for newly registeered user testcases
  Background:
    Given  user is in onboarding page
    #And user clicks on allow notifications
    And user verifies onboarding page
    And user clicks on signup button
    And user enters email and password for signup and verify it using API
    And user clicks on signin button in Signup page
    And user enters  newly registered email and  strong password
    And user clicks on login button
    Then user verifies tag selection page

    @regression
     #TC-012
  Scenario Outline: Verify that Favorite session and unfavorite session by clicking yes button
      And user verifies and select <tags> tags and <others> tags
      Then user clicks on next button
      And user verifies commitment page and select <time>
      And user clicks on finish button
      Then user select lets explore button and enter homepage
      And user selects explore button
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user clicks on favorite  session button
    Then user verifies favorite sucess message
    And user clicks on favorite  session button
    And user clicks on Yes
    Then user verifies unfavorite sucess message
    Examples:
      | session |   |description|                                                    |tags|  |others ||time|
      |med session|  |Meditation is a practice that involves training the mind|       |1   | |false  | |30|

  @regression
    #TC-013
  Scenario Outline: Verify that Favorite Button is Working and click no button and still session is in favorites
    And user verifies and select <tags> tags
    Then user clicks on next button
    And user verifies commitment page and select <time>
    And user clicks on finish button
    Then user select lets explore button and enter homepage
    And user selects explore button
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user clicks on favorite  session button
    Then user verifies favorite sucess message
    And user clicks on favorite  session button
    And user clicks on No
    And user clicks on favorite  session button
    Then user sees Yes Button to remove from favorites

    Examples:
      | session |   |description|            |tags|  |time|
      |med session|  |Meditation is a practice that involves training the mind|  |1   | |30|

  @regression
    #TC-014
  Scenario Outline: Verify that user cannot listen second tracks without completing first track(add new user api for verification/tag/commitmwnt selection)
    And user verifies and select <tags> tags
    Then user clicks on next button
    And user verifies commitment page and select <time>
    And user clicks on finish button
    Then user select lets explore button and enter homepage
    And user selects explore button
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user opens <number> track
    Then user verifies validation message shown
    Examples:
      | session |   |description|                                               |number|   |tags|  |time|
      |med session|  |Meditation is a practice that involves training the mind|  |2    |    |1   |  |30|
  #TC-015
  @regression
  Scenario Outline: Verify track completion pop up shown after finishing a track
    And user verifies and select <tags> tags
    Then user clicks on next button
    And user verifies commitment page and select <time>
    And user clicks on finish button
    Then user select lets explore button and enter homepage
    And user selects explore button
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user opens <number> track
    And user clicks on play button
    Then user views track completion popup

    Examples:
      | session |   |description|                                               |number|  |tags|  |time|
      |med session|  |Meditation is a practice that involves training the mind|  |1   |    |1   |  |30|


  @regression
     #TC-016
  Scenario Outline: Verify next chapter button is working(automate)
    And user verifies and select <tags> tags
    Then user clicks on next button
    And user verifies commitment page and select <time>
    And user clicks on finish button
    Then user select lets explore button and enter homepage
    And user selects explore button
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user opens <number> track
    And user clicks on play button
    Then user views track completion popup
    And user clicks on next chapter button
    Then user verifies title of second track in session <number>
    Examples:
      | session | description | number |                                             |tags|  |time|
      |med session|  Meditation is a practice that involves training the mind  |1   | |1   | |30|

  @regression
     #TC-017
  Scenario Outline: Verify restart chapter button is working
    And user verifies and select <tags> tags
    Then user clicks on next button
    And user verifies commitment page and select <time>
    And user clicks on finish button
    Then user select lets explore button and enter homepage
    And user selects explore button
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user opens <number> track
    And user clicks on play button
    Then user views track completion popup
    Then user clicks on restart chapter button
    Then user verifies title of first track in session

    Examples:
      | session | description | number |                                             |tags|  |time|
      |med session|  Meditation is a practice that involves training the mind  |1   | |1   |  |30|

  @regression
    #TC-018
  Scenario Outline: Verify session completion pop up is shown after finishing session
    And user verifies and select <tags> tags
    Then user clicks on next button
    And user verifies commitment page and select <time>
    And user clicks on finish button
    Then user select lets explore button and enter homepage
    And user selects explore button
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user opens <number> track
    And user clicks on play button
    Then user views track completion popup
    And user clicks on next chapter button
    And user clicks on next chapter button
    Then user verifies session completion popup
    Examples:
      | session |   |description|                                               |number|  |tags|  |time|
      |med session|  |Meditation is a practice that involves training the mind|  |1   |    |1   |  |30|

  @regression
    #TC-019
  Scenario Outline: Verify mini player shown in session page when user clicks back button in track page
    And user verifies and select <tags> tags
    Then user clicks on next button
    And user verifies commitment page and select <time>
    And user clicks on finish button
    Then user select lets explore button and enter homepage
    And user selects explore button
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user opens <number> track
    And user clicks on play button
    And user clicks navigate back button
    Then user verifies title of track in mini player
    Examples:
      | session |   |description|                                               |number|  |tags|  |time|
      |med session|  |Meditation is a practice that involves training the mind|  |1   |    |1   |  |30|


  @regression
    #TC-020
  Scenario Outline: Verify close button working in mini player in session page
    And user verifies and select <tags> tags
    Then user clicks on next button
    And user verifies commitment page and select <time>
    And user clicks on finish button
    Then user select lets explore button and enter homepage
    And user selects explore button
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user opens <number> track
    And user clicks on play button
    And user clicks navigate back button
    Then user verifies title of track in mini player
    And user clicks mini player close button
    Then user verifies resume session button
    Examples:
      | session |   |description|                                               |number|  |tags|  |time|
      |med session|  |Meditation is a practice that involves training the mind|  |1   |    |1   |  |30|

  @regression
    #TC-021
  Scenario Outline: Verify resume session button working when user pause 1st track of session and click resume button
    And user verifies and select <tags> tags
    Then user clicks on next button
    And user verifies commitment page and select <time>
    And user clicks on finish button
    Then user select lets explore button and enter homepage
    And user selects explore button
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user opens <number> track
    And user clicks on play button
    And user clicks on pause button
    And user clicks navigate back button
    Then user clicks resume session button
    And user clicks ads close button
    And user clicks on play button
    Then user verifies title of first track in session
    Examples:
      | session |   |description|                                               |number|  |tags|  |time|
      |med session|  |Meditation is a practice that involves training the mind|  |1   |    |1   | |30|


  @regression
    #TC-022
  Scenario Outline: Verify resume session button working when user close 1st track of session and click resume button
    And user verifies and select <tags> tags
    Then user clicks on next button
    And user verifies commitment page and select <time>
    And user clicks on finish button
    Then user select lets explore button and enter homepage
    And user selects explore button
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user opens <number> track
    And user clicks on play button
    And user clicks navigate back button
    Then user verifies title of track in mini player
    And user clicks mini player close button
    Then user clicks resume session button
    And user clicks ads close button
    And user clicks on play button
    Then user verifies title of first track in session
    Examples:
      | session |   |description|                                               |number|  |tags|  |time|
      |med session|  |Meditation is a practice that involves training the mind|  |1   |    |1   |  |30|

