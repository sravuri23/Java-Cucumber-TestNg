package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class BasePageObject{
    //private static final Logger LOG = (Logger) LoggerFactory.getLogger(BasePageObject.class);
    private WebDriver driver;
    private WebDriverWait wait;


    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));// Default timeout is set to 10 seconds

    }

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver(); // or any other WebDriver implementation
        BasePageObject basePage = new BasePageObject(driver);

    }

    public WebElement waitForanElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}



