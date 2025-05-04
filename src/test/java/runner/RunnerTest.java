package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/features",tags="@Dont,@AmazonSearch,@apiTest",
        glue={"src/test/java/stepDefinition"},
        plugin ={"pretty" ,"html:target/Destination",
                "json:Folder_Name/cucumber.json" ,
                "junit:Folder_Name/cucumber.xml"},
       // tags = {"@Dont,@AmazonSearch,@apiTest"},
        monochrome=true)

public class RunnerTest {
}
