Feature: ORS web login
  Scenario Outline: User should be able to log in with valid credentials
    Given the user is on the login page
    When the user enters a valid "<userEmail>" and a valid "<userPassword>"
    And clicks on submit
    Then the user should be successfully logged in to the app
    Examples:
      | userEmail           | userPassword  |
      | bab12@gmail.com     | Fresh689      |
      | barfi123@mail.com   | Fresh123      |
      | barfi@gmail.com     | fresh489      |
      | barfi@gmail.com     | Fresh123      |
