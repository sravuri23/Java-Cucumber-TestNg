package WebDriverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static DriverManager instance;  // Singleton instance
    private WebDriver driver;

    // Private constructor to prevent direct instantiation
    public DriverManager() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    // Static method to return the singleton instance
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    // Get the WebDriver instance
    public WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    // Quit the driver and reset the instance
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            instance = null; // Reset for reuse if needed
        }
    }
}
