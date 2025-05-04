Feature: Get weather details

  @apiTest
  Scenario Outline:Verify weather details status code
    Given I call weather details API
    And the valid 200 success response code is returned for the "<City>"
    When I request weather by "<City>"
    Then the response body contains valid "<City>" in weather details
    Examples:
      | City      |
      | Hyderabad |
      | Chennai   |
      | London    |
      | Bedford   |
    #https://www.toolsqa.com/rest-assured/rest-api-test-using-rest-assured/

  Scenario: Verify all the links in the website returns 200 ok message
    Given I navigate to the site
    When I click all the links on the website
    Then all the links in the website should return '200' ok success message

  Scenario: Verify the number of rows and columns in the table



