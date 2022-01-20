Feature: Validate if users can check and do comments on news articles from BBC Website

  @Read_News_Headlines @automated
  Scenario: Validate that users can open news headlines
    Given The user opened the home page of BBC Website
    And The user agreed to cookies consent
    When The user opens news headlines
    Then The top headlines are displayed

  @Check_Comments_Availability @automated
  Scenario: Validate that users can check comments are enabled
    Given The user opened the home page of BBC Website
    And The user agreed to cookies consent
    And The user opens news headlines
    When The user opens a comment enabled news article
    Then The user can check comments are displayed

  @Check_Comments_Availability_SignedIn_Users @manual
  Scenario: Validate that signed in users can post the comment
    Given The user opened the home page of BBC Website
    And The user agreed to cookies consent
    And The user opens news headlines
    And The user opens a comment enabled news article
    And The user signs in
    When The user moves to the comment section
    Then The post comment feature is enabled
    And The user can post a comment

  @Check_Comments_Availability_NonRegistered @manual
  Scenario: Validate that non registered users can post the comment after registering
    Given The user opened the home page of BBC Website
    And The user agreed to cookies consent
    And The user opens news headlines
    And The user opens a comment enabled news article
    And The user moves to the comment section
    When The user clicks on register
    Then The user can register by providing personal information
    And The user can login immediately
    And The user can post a comment

  @Check_Comments_UnAvailability @manual @negative
  Scenario: Validate that comments are unavailable for a few articles
    Given The user opened the home page of BBC Website
    And The user agreed to cookies consent
    And The user opens news headlines
    When The user opens a comment disabled news article
    Then The user can not see or post a comment

  @Check_Comments_Replay @manual
  Scenario: Validate that user can replay on comments when they are signed in
    Given The user opened the home page of BBC Website
    And The user agreed to cookies consent
    And The user opens news headlines
    And The user opens a comment enabled news article
    And The user signs in
    And The user moves to the comment section
    When The user replies on a comment
    Then the reply will be displayed underneath the comment

  @Check_Comments_Like_Dislike @manual
  Scenario Outline: Validate that user can <action> on comments when they are signed in
    Given The user opened the home page of BBC Website
    And The user agreed to cookies consent
    And The user opens news headlines
    And The user opens a comment enabled news article
    And The user signs in
    And The user moves to the comment section
    When The user <action>s on a comment
    Then the <action> count will be increased

    Examples: 
      | action  |
      | like    |
      | dislike |

  @Check_Comments_Sorting @manual
  Scenario Outline: Validate that user can sort by <category> on comments
    Given The user opened the home page of BBC Website
    And The user agreed to cookies consent
    And The user opens news headlines
    And The user opens a comment enabled news article
    And The user moves to the comment section
    When The user sorts by <category>
    Then the sorting action by <category> is successful

    Examples: 
      | category      |
      | Highest Rated |
      | Most Replied  |
      | Oldest        |
      | Latest        |
