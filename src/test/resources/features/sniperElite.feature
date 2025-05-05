Feature: SniperElite Feature

  Background:
    Given I navigate to Sniperelite Website

  @smoke @regression
  Scenario: Verify homepage loads and key elements are present
    Then the title of the page contains 'title'
    And the main banner should be present
    And  the navigation menu should be present
    Then the footer component should be displayed

  @regression
  Scenario: Verify the Display of Sniper Elite logo, mega-menu, and globe icon
    When the page finishes loading
    Then the Sniper Elite logo is visible in the main navigation bar
    And the mega-menu is visible with the items:
      | NEWS          |
      | GAMES         |
      | SUPPORT       |
      | MERCHANDISE   |
      | ACCESSIBILITY |
    And a globe icon is displayed in the main navigation bar

  @regression
  Scenario: Verify if the home page Displays “BUY NOW” CTAs
    And the hero banner heading "BE THE RESISTANCE" is visible
    And the sub-heading text "Sniper Elite: Resistance - Out Now!" is visible
    When the page finishes loading
    Then the "BUY NOW" CTA button is visible on the hero banner

  @regression
  Scenario: Verify user clicking on “Buy Now” CTA and Redirected to Rebellion Shop after selecting the PC tile
    When the user clicks the “BUY NOW” button
    And the platform tiles visble “PC”, “XBOX”, and “PLAYSTATION” are visible
    And the user clicks the “PC” tile
    And the PC tile window appears
    Then a modal for PC purchase appears with “STANDARD EDITION” pre-selected
    When the user clicks the “Rebellion Shop” option in the modal
    Then the Rebellion Shop page opens in a new browser window
    And Sniper Elite Resistance Standard Edition is pre-selected
    And the free “Super Elite Camo T-Shirt” is pre-selected in size “XS”
    And the quantity is set to 1 by default
    When the user clicks the “Add to Cart” button
    And a cart drawer overlay appears showing the selected items
    Then the user clicking on 'Go To Cart' CTA navigates to the cart page




