Feature: Test login form template of Galen web page

  Scenario: Test home page
    Given welcome galen home page
    When click button login
    Then assert that is a login form

  Scenario: Test login function
    Given welcome galen home page
    And click button login
    When user set username and password
    Then assert My Notes title

  Scenario: The username or password are incorrect
    Given welcome galen home page
    And click button login
    When user set bad username and password
    Then assert message about incorrect information
