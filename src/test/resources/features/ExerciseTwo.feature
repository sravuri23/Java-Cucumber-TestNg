Feature: Exercise-2

# In this exercise next website is used as an example.
# Product details page (pdp) is used to verify all the links in the website are returning HTTP STATUS Should be OK response
# In the same website on (PDP) page, verified size guide tables row count

  Scenario: Verify all the links in the PDP page returns OK response
    Given I navigate to Next Website
    And I search for "Curved Hem T-Shirt"
    When I click on first product displayed on PLP page
    And the results returned displays the product "Curved Hem T-Shirt"
    Then all the links in the pdp page returns OK response with no 404 error code
    And I click on size guide link
    Then a table with a list of rows displayed