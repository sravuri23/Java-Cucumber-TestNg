package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.BasePageObject;

public class NextSearchPage extends BasePageObject {

    public static WebDriver driver;
    private BasePageObject basePage;

    public NextSearchPage(BasePageObject basePage) {
        this.basePage = basePage;

    }


    private  WebElement searchField = driver.findElement(By.cssSelector("input[id='sp-cc-accept']"));
    private  WebElement cookieAccept = driver.findElement(By.cssSelector("button#L2AGLb.tHlp8d"));

    public  void openTheWebsite () {
        basePage.getApplicationUrl();
    }
    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public void clickOnSearchField(){
        waitForanElement(searchField).click();

    }
    public void acceptCookie(){
        waitForanElement(cookieAccept).isDisplayed();
        driver.switchTo( ).alert( ).accept();
        waitForanElement(cookieAccept).click();
    }
}
