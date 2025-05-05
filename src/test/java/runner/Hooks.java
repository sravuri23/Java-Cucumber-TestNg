package runner;

import WebDriverUtils.DriverManager;
import io.cucumber.java.After;


public class Hooks {


    @After
    public static void tearDown() {
        DriverManager.getInstance().quitDriver();
        System.out.println("Browser closed after all tests.");
    }
}
