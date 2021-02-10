Feature: Get weather details
  Scenario Outline:Verify weather details status code
    Given I call weather details API
    And the valid 200 success response code is returned for the "<City>"
    When I request weather by "<City>"
    Then the response body contains valid "<City>" in weather details
    Examples:
      |City|
      |Hyderabad  |
      |Chennai  |
      |London   |
      |Bedford  |
    #https://www.toolsqa.com/rest-assured/rest-api-test-using-rest-assured/