package stepDefinition;

import dataProviders.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;


public class WeatherDetailsSteps {
    ConfigFileReader configFileReader;
    private Response response;
    private RequestSpecification httpRequest;
    private ResponseBody body;

    @Given("I call weather details API")
    public void i_call_weather_details_api() {
        configFileReader= new ConfigFileReader();
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = configFileReader.getWeatherApiUrl();
    }

    @When("^I request weather by \"([^\"]*)\"$")
    public void i_request_weather_by(String City) {
        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, City);
        // Now let us print the body of the message to see what response
        // we have received from the server
        String body = response.getBody().asString();
        System.out.println("Response Body is =>  " + body);
    }


    @And("^the valid ([^\"]*) success response code is returned for the \"([^\"]*)\"$")
    public void the_valid_success_response_code_is_returned(int statusCode, String City) {
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, City);
        // Get the status code from the Response. In case of
        // a successfull interaction with the web service, we
        // should get a status code of 200.
        int responseStatusCode = response.getStatusCode();
        // Assert that correct status code is returned.
        System.out.println("Response Code is =>  " + responseStatusCode);
        Assert.assertEquals(responseStatusCode, statusCode);
    }

    @Then("^the response body contains valid \"([^\"]*)\" in weather details$")
    public void the_response_body_contains_valid_weather_details(String City) {
        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();
        // Then simply query the JsonPath object to get a String value of the node
        // specified by JsonPath: City (Note: You should not put $. in the Java code)
        String cityReceivedInResponse = jsonPathEvaluator.get("City");
        // Let us print the city variable to see what we got
        System.out.println("City received from Response " + cityReceivedInResponse);
       // Validate the response
        Assert.assertEquals(cityReceivedInResponse, City);
    }

}
