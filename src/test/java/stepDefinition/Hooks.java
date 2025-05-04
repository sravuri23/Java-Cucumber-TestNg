package stepDefinition;

import WebDriverUtils.DriverManager;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;


public class Hooks {
    private static WebDriver driver;

    @After
    public static void tearDown() {
        DriverManager.getInstance().quitDriver();
        System.out.println("Browser closed after all tests.");
    }
}
