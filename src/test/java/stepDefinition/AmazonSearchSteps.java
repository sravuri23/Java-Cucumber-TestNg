package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AmazonSearchSteps {

    public static WebDriver driver;
    String baseURL = "https://www.amazon.co.uk";
    @Given("user launches Amazon webapp")
    public void user_launches_Google_webapp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @When("user clicks on agree")
    public void user_searches_for_a() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[id='sp-cc-accept']")).click();
    }

    @And("enter button and search {string}")
    public void enterButtonAndSearch(String itemname) {
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).click();
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(itemname);
        driver.findElement(By.cssSelector("input[id='nav-search-submit-button']")).click();

    }


    @Then("results retrieved should contain the {string} used")
    public void results_retrieved_should_contain_the_used(String itemname) {
        String itemText=  driver.findElement(By.cssSelector("span.a-color-state")).getText();
        assertThat(itemText.compareToIgnoreCase(itemname));
        driver.close();
        driver.quit();
    }

}

