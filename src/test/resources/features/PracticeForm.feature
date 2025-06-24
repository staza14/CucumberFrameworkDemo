Feature: Form Submission

  @form @smoke
  Scenario: fill out and submit practice form
    Given the user is on the practice form page
    And accepts the webpage cookies
    And enters a first name
    And enters a last name
    And selects a gender radio button
    And selects an experience radio button
    And enters a date
    And checks a profession
    And chooses automation tools
    And chooses a continent
    And uploads a file
    When the user clicks on the submit button
    Then the a line should be printed saying "button found"
