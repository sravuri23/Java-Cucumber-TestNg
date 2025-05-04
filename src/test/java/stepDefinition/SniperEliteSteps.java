package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SniperEliteSteps {


    public static class ConfigFileReader {
        public static WebDriver driver;
        dataProviders.ConfigFileReader configFileReader;


        @Given("I navigate to Sniperelite Website")
        public void i_navigate_to_Sniperelite_website() {
            configFileReader = new dataProviders.ConfigFileReader();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to(configFileReader.getApplicationUrl());

        }
        @Then("the title of the page contains {string}")
        public void the_title_of_the_page_contains(String Title) {
//         driver.get(configFileReader.getApplicationUrl());

            // Get the title of the page
            String pageTitle = driver.getTitle();
           Title="Sniper Elite: Resistance | Out Now";
            // Print the title
            System.out.println(pageTitle.contains("Page title is: " + Title));
            assertThat(driver.getTitle()).isEqualTo(Title);
            // Close the browser
            driver.quit();

        }

        @And("I search for {string}")
        public void i_search_for(String itemName) {
            driver.findElement(By.cssSelector("#sli_search_1")).click();
            driver.findElement(By.cssSelector("#sli_search_1")).sendKeys(itemName);
            driver.findElement(By.cssSelector("input[class='SearchButton']")).click();

        }

        @When("I click on first product displayed on PLP page")
        public void i_click_on_first_product_displayed_on_plp_page() {
            driver.findElement(By.cssSelector("article.Item.Fashion:nth-child(1)")).click();
        }

        @And("the results returned displays the product {string}")
        public void theResultsReturnedDisplaysTheProduct(String itemName) {
            String itemText = driver.findElement(By.cssSelector("div.Title > h1:nth-child(1)")).getText();
            assertThat(itemText.compareToIgnoreCase(itemName));

        }

        @Then("all the links in the pdp page returns OK response with no 404 error code")
        public void allTheLinksInThePdpPageReturnsOKresponseWithno404errorcode() {
            getAllTheLinks();
            driver.close();
            driver.quit();
        }

        public void getAllTheLinks() {
            List<WebElement> links = driver.findElements(By.tagName("a"));
            // This line will print the number of links and the count of links.
            System.out.println("No of links are " + links.size());
            //checking the links fetched.
            for (int i = 0; i < links.size(); i++) {
                WebElement E1 = links.get(i);
                String url = E1.getAttribute("href");
                System.out.println("All the links in the page " + url);
                verifyLinks(url);
            }

        }

        public static void verifyLinks(String linkUrl) {
            try {
                URL url = new URL(linkUrl);
                //Now we will be creating url connection and getting the response code
                HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
                httpURLConnect.setConnectTimeout(5000);
                httpURLConnect.connect();
                if (httpURLConnect.getResponseCode() >= 400) {
                    System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage() + "is a broken link");
                }
                //Fetching and Printing the response code obtained
                else {
                    System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage());
                }
            } catch (Exception e) {
            }

        }


        @And("I click on size guide link")
        public void iClickOnSizeGuideLink() {
            driver.findElement(By.cssSelector("span.SizeGuideString")).click();
        }


        @Then("a table with a list of rows displayed")
        public void aTableWithAListOfRowsDisplayed() {
            numberOfrowsInSizeGuide();
            driver.close();
            driver.quit();
        }

        public void numberOfrowsInSizeGuide() {
            //No.of rows
            List <WebElement> rows = driver.findElements(By.cssSelector("tbody >tr"));
            int count = rows.size();
            System.out.println("ROW COUNT : "+count);
            for(WebElement e : rows) {
               System.out.println(e.getText());
            }
        }
    }
}






