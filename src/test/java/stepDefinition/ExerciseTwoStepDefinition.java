package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ExerciseTwoPage;

public class ExerciseTwoStepDefinition {

    private ExerciseTwoPage exerciseTwoPage;


    @Given("I navigate to Next Website")
    public void i_navigate_to_next_website() {
        exerciseTwoPage = new ExerciseTwoPage();
        exerciseTwoPage.initializeBrowser();
    }

    @And("I search for {string}")
    public void i_search_for(String itemName) {
        exerciseTwoPage.clickOnSearchField();
        exerciseTwoPage.enterProductName(itemName);
        exerciseTwoPage.clickOnSearchIcon();
    }

    @When("I click on first product displayed on PLP page")
    public void i_click_on_first_product_displayed_on_plp_page() {
        exerciseTwoPage.clickOnFirstItem();
    }

    @And("the results returned displays the product {string}")
    public void theResultsReturnedDisplaysTheProduct(String itemName) {
        exerciseTwoPage.getProductTitle(itemName);

    }

    @Then("all the links in the pdp page returns OK response with no 404 error code")
    public void allTheLinksInThePdpPageReturnsOKresponseWithno404errorcode() throws Exception {
        exerciseTwoPage.getAllTheLinks();

    }


    @And("I click on size guide link")
    public void iClickOnSizeGuideLink() {
        exerciseTwoPage.clickOnSizeGuideLink();
    }


    @Then("a table with a list of rows displayed")
    public void aTableWithAListOfRowsDisplayed() {
        exerciseTwoPage.numberOfrowsInSizeGuide();
        exerciseTwoPage.closeTheBrowser();
    }


}


