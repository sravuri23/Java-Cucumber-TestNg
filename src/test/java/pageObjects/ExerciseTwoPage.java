package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Inheriting basepage objects in to this class
 */
public class ExerciseTwoPage extends BasePage {

    /**
     * Encapsulating all the elements by declaring private to avoid conflicts for new page elements
     */
    private By searchField = By.cssSelector("#sli_search_1");
    private By searchIcon = By.cssSelector("input[class='SearchButton']");
    private By firstItem = By.cssSelector("article.Item.Fashion:nth-child(1)");
    private By productTitle = By.cssSelector("div.Title > h1:nth-child(1)");
    private By sizeGuideLink = By.cssSelector("span.SizeGuideString");


    /**
     * Above declared elements called and given access as public
     */
    public void clickOnSearchField() {
        waitForExpectedElement(searchField).click();
    }

    public void enterProductName(String itemName) {
        waitForExpectedElement(searchField).sendKeys(itemName);
    }

    public void clickOnSearchIcon() {
        waitForExpectedElement(searchIcon).click();
    }

    public void clickOnFirstItem() {
        waitForExpectedElement(firstItem).click();
    }
    /**
     * Validated the product search in homepage is same as the product returned in Product displayed in PDP page
     */
    public void getProductTitle(String itemName) {
        String text = waitForExpectedElement(productTitle).getText();
        assertThat(text.compareToIgnoreCase(itemName));
    }

    public void clickOnSizeGuideLink() {
        waitForExpectedElement(sizeGuideLink).click();
    }

    /**
     * This method will fetch all the links in the Product Details Page
     */
    public void getAllTheLinks() throws Exception {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (int i = 0; i < links.size(); i++) {
            WebElement E1 = links.get(i);
            String url = E1.getAttribute("href");
            verifyLinks(url);
        }
    }

    /**
     * This method is to verify the if all of them are ok (no 404 code)
     */
    public static void verifyLinks(String linkUrl) throws Exception {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            assertThat(httpURLConnect.getResponseCode()).as("HTTP STATUS Should be ok/200", linkUrl);
        } catch (Exception e) {

        }
    }

    /**
     * This method is to verify the number of row count in the 2 tables equals 24
     */
    public void numberOfrowsInSizeGuide(){
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody  tr"));
        Assert.assertEquals(24, rows.size());
    }
}
