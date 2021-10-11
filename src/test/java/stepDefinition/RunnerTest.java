package stepDefinition;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/features",
        glue={"src/test/java/stepDefinition"},
        plugin ={"pretty" ,"html:target/Destination",
                "json:Folder_Name/cucumber.json" ,
                "junit:Folder_Name/cucumber.xml"},
        monochrome=true)

public class RunnerTest {
}
