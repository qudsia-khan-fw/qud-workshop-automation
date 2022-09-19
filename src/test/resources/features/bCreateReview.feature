Feature: Create an item for review
  Scenario: The staff user should be able to navigate to the create review page
    Given the user logs in with email "barfi@gmail.com" and password "Fresh123"
    When the user lands on the create review page
    And fills in the required form fields
    And publishes the review
    Then the review should be published
    And the user should be navigated to the review detail page

