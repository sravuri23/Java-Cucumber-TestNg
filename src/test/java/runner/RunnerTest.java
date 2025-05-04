package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinition", "Hooks"},
        plugin = {
                "pretty",
                "html:target/Destination",
                "json:Folder_Name/cucumber.json",
                "junit:Folder_Name/cucumber.xml",
                "org.jetbrains.plugins.cucumber.java.run.CucumberJvm5SMFormatter"
        },

        monochrome = true
)
public class RunnerTest {
}

// // tags = "@smoke and not @regression",  // Only run @smoke and exclude @regression
// --plugin org.jetbrains.plugins.cucumber.java.run.CucumberJvm5SMFormatter