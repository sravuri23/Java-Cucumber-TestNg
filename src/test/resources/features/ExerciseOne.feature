User Story: As a user, I want to check that four points in the space are a square

Acceptance Criteria:
All the coordinates are mandatory. When the form is submitted, if any coordinates are blank, show error message to the user.
Each coordinate will be separated with commas (e.g: ##,##)
If the four coordinates do not make a square, show an error message to the user
The new page should be the same as the mockup

Feature: Exercise 1 - To write Cucumber Tests using Gherkin

  Scenario Outline: Verify if the four points in the space are a square
    Given I enter the values in "<Coordinate 1>" "<Coordinate 2>" "<Coordinate 3>" "<Coordinate 4>" fields
    And each coordinates are separated by commas
    When I click on check button
    Then should see the square if the values are correct

    Examples:
      | Coordinate 1 | Coordinate 2 | Coordinate 3 | Coordinate 4 |
      | 10,10        | 10,20        | 20,10        | 20,20        |

  Scenario Outline: Verify if I see the error message for irrelevant values
    Given the "<Coordinate 1>" "<Coordinate 2>" "<Coordinate 3>" "<Coordinate 4>" fields are empty
    And I enter values as given below
    When either of the coordinate is blank
    Then should get the error 'The field is required' message

    Examples:
      | Coordinate 1 | Coordinate 2 | Coordinate 3 | Coordinate 4 |
      | 100,10       |   10,200     | 2,1          |  3,4         |

  Scenario Outline: Verify if it shows error message when any of the coordinates are blank
    Given the user has access to the page
    When the user enter values to any three coordinate "<Coordinate 1>" "<Coordinate 2>" "<Coordinate 3>" "<Coordinate 4>" fields
    And leave any of the fields blank
    Then the user should see 'The field is required' message

    Examples:
      | Coordinate 1 | Coordinate 2 | Coordinate 3 | Coordinate 4 |
      | 10,10        |   10,20      | 20,10        |              |
      | 10,10        |   10,20      |              |   20,20      |
      | 10,10        |              | 20,10        |   20,20      |
      |              |   10,20      | 20,10        |   20,20      |
      |              |              |              |              |

  Scenario: Verify if the coordinate fields lay one by one under each as per mock ups
    Given the user access to the form page
    And see all four coordinate fields one below the other
    And Cancel button below the fourth Coordinate field on the first edge of the field
    And Check button below the fourth Coordinate field on the second edge of the field
    And Clear button below the Check button
    Then the buttons should be functional



