Feature: Regression Test - Sniper Elite Resistance - Homepage & Shop.Rebellion page

Background:
Given the user is on the Rebellion Shop product page in a new window

Scenario: Verify if the user can add Sniper Elite: Resistance Standard Edition with free T-shirt to the cart
And Sniper Elite Resistance Standard Edition is pre-selected
And the free “Super Elite Camo T-Shirt” is pre-selected in size “XS”
And the quantity is set to “1” by default
When the user clicks the “Add to Cart” button
Then a cart drawer overlay appears showing the selected items
And the user clicking on 'Go To Cart' CTA navigates to the cart page

#Scenario: Verify if the user can add sniperelite Merchandise to basket
#When the user enter 'mug' in the search field
#And click on enter
#Then the mugs are displayed in the product listing page
#And the user clicks on first item
#And the user lands on mug PDP by the word "description"
#And  user clicks on "add to cart" button
#Then the "cartdrawer" pops up shows the product added
#
#Scenario:Verify if the user can add the sniperelite clothing to basket
#When the user enter 'sniperelite hoodie' in the search field
#And click on enter
#Then lists all the Sniper Elite Hoodie on PLP
#And  the "SearchFieldInput" field parameter matches the searched item
#Then the 'sniperelite hoodies' are displayed in the product listing page
#And the user clicks on first item
#And the user lands on sniperelite hoodie PDP by the word "description"
#And  user clicks on "add to cart" button
#Then the "cartdrawer" pops up shows the product added
#
#Scenario: Verify if the cart page displays all the 3 products added
#Given the user adds all the 3 products to the basket
#When the user clicks on "gotocart" CTA
#And the user redirected to cart page
#Then the url should end with cart
#And the cart count matches with number of items added
#And the user click on "checkout" button
#And the user navigates to checkout page
#Then the url should end with checkout