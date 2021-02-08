package stepDefinition;


import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue={"src/test/java/stepDefinition"}
        //,tags = "@AmazonSearch,@apiTest"
)
public class RunCucumberTest {

}