package stepDefinition;

import dataProviders.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.containsInAnyOrder;


public class BooksApiSteps {
    ConfigFileReader configFileReader;
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    private String ENDPOINT_GET_BOOK_BY_ISBN = "https://www.googleapis.com/books/v1/volumes";


    @Given("^a book exists with an isbn of ([^\"]*)$")
    public void aBookExistsWithAnIsbnOf(String isbn) {
            request = given().param("q", "isbn:" + isbn);
    }

    @When("a user retrieves the book by isbn")
    public void a_user_retrieves_the_book_by_isbn() {
        configFileReader=new ConfigFileReader();
        configFileReader.getBoooksApiUrl();
        response = request.when().get(configFileReader.getBoooksApiUrl());
        System.out.println("response: " + response.prettyPrint());

    }

    @Then("^the status code is ([^\"]*)$")
    public void theStatusCodeIs(int statusCode) {
        json = response.then().statusCode(statusCode);
       int responseStatusCode = response.getStatusCode();
       Assert.assertEquals(responseStatusCode, 200 );
       System.out.println("correct response code displayed"  + responseStatusCode );
    }

    @Then("response includes the following")
    public void response_includes_the_following(Map<String,String> responseFields) {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if(StringUtils.isNumeric(field.getValue())){
                json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            }
            else{
                json.body(field.getKey(), equalTo(field.getValue()));
            }
        }
    }

    @Then("response includes the following in any order")
    public void response_includes_the_following_in_any_order(Map<String,String> responseFields) {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if(StringUtils.isNumeric(field.getValue())){
                json.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
            }
            else{
                json.body(field.getKey(), containsInAnyOrder(field.getValue()));
            }
        }
    }
    }
