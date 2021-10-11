package pageObjects;


import dataProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * The is a base page class used to define commonly used functions across all the pages
 */
public class BasePage {
    public static WebDriver driver;
    public static ConfigFileReader configFileReader;

    @Getter
    protected WebDriverWait wait;


    public static void initializeBrowser() {
        configFileReader = new dataProviders.ConfigFileReader();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().to(configFileReader.getApplicationUrl());
    }

    public WebElement waitForExpectedElement(final By by){
        WebDriverWait wait = new WebDriverWait(driver,40);
        return wait.until(visibilityOfElementLocated(by));
    }
    public static void closeTheBrowser() {
        driver.close();
        driver.quit();
    }
}
