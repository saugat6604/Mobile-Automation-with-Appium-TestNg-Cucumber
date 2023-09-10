
Feature: Session

  Background:
    Given  user is in onboarding page
    #And user clicks on allow notifications
    And user verifies onboarding page
    And user clicks on signin button
    And user enters  correct username and  correct password
    And user clicks on login button
    And user select lets explore button and enter homepage
    And user selects explore button
  @regression
  #TC-001
  Scenario Outline: Verify that user search,open and verifies session page (title/description/image/fav button/music/back button) displayed
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    Examples:
      | session |   |description|
      |med session|  |Meditation is a practice that involves training the mind to focus and redirect thoughts|

  @regression
    #TC-002
  Scenario Outline: Verify that Back Button is Working in Session Page
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user clicks on back button
    Then user is redirected to search page

    Examples:
      | session |   |description|
      |med session|  |Meditation is a practice that involves training the mind|




  @regression
    #TC-003
  Scenario Outline: Verify that User redirected to background Page when clicks on music button
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user clicks on music button
    Then user verifies Background music Page

    Examples:
      | session |   |description|
      |med session|  |Meditation is a practice that involves training the mind|

  @regression
     #TC-004
  Scenario Outline: Verify that back button working in background music page
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user clicks on music button
    Then user verifies Background music Page
    And user clicks on back button
    And  user verifies <session> title
    And user verifies <description> of session
    Examples:
      | session |   |description|
      |med session|  |Meditation is a practice that involves training the mind|


  @regression
    #TC-05
  Scenario Outline: Verify that user can select background music and active music is visible in background music page
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user clicks on music button
    Then user verifies Background music Page
    And user gets background-music names from backend <number>
    Then user verifies active menu is visible <number>

    Examples:
      | session |   |description|                                               |number|
      |med session|  |Meditation is a practice that involves training the mind|  |1    |
      |med session|  |Meditation is a practice that involves training the mind|  |2    |


  @regression
    #TC-06
  Scenario Outline: Verify that user can unselect background music
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user clicks on music button
    Then user verifies Background music Page
    And user gets background-music names from backend <number>
    Then user verifies active menu is visible <number>
    And user gets background-music names from backend <number>
    Then user verifies active menu is not visible <number>


    Examples:
      | session |   |description|                                               |number|
      |med session|  |Meditation is a practice that involves training the mind|  |1    |
      |med session|  |Meditation is a practice that involves training the mind|  |2    |

  @regression
     #TC-07
  Scenario Outline: Verify that user can unselect background music using clear all button
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user clicks on music button
    Then user verifies Background music Page
    And user gets background-music names from backend <number>
    Then user verifies active menu is visible <number>
    And user clicks on active menu dropdown
    And user clicks on clear all button
    Then user verifies active menu is not visible <number>
    Examples:
      | session |   |description|                                               |number|
      |med session|  |Meditation is a practice that involves training the mind|  |2    |

  @regression
     #TC-08
  Scenario Outline: Verify that user can select background music from different category(continue)
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user clicks on music button
    Then user verifies Background music Page
    And user gets background-music names from backend <number>
    Then user verifies active menu is visible <number>
    And user selects background music from second subcategory <number> and verifies total counts
    Examples:
      | session |   |description|                                               |number|
      |med session|  |Meditation is a practice that involves training the mind|  |2   |
      |med session|  |Meditation is a practice that involves training the mind|  |2   |

  @regression
     #TC-09
  Scenario Outline: Verify user sees session page when user clicks back button in trackspage
    And user search for <session> Name
    And user click on <session>
    And user clicks on skip button
    And user verifies session page
    And  user verifies <session> title
    And user verifies <description> of session
    And user opens <number> track
    And user clicks back button
    And user verifies <description> of session
    Examples:
      | session | description | number |
      |med session|  Meditation is a practice that involves training the mind  |1   |


     #TC-010
  #Scenario: Verify resume session button is working(Manual)

  @regression
     #TC-011
  Scenario Outline: Verify that user redirected to Background music page when clicked Try button
    And user search for <session> Name
    And user click on <session>
    And user clicks on try button
    Then user verifies Background music Page
    Examples:
      | session |
      |med session|



















