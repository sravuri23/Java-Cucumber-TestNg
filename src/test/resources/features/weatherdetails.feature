Feature: Get weather details
  Scenario Outline: Verify weather details status code
    Given I call weather details API
    When I request weather by <City>
    And the valid 200 success response code is returned
    Then the response body contains valid weather details
    Examples:
    |City|
    |Hyderabad|
    |Chennai  |
    #https://www.toolsqa.com/rest-assured/rest-api-test-using-rest-assured/