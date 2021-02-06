package stepDefinition;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue={"src/test/stepDefinition"},
        tags = {"@GoogleSearch"}
)
public class RunCucumberTest {

}