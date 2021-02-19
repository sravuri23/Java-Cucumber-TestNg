package stepDefinition;


import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

//import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue={"src/test/java/stepDefinition"},
        plugin = {"pretty", "html:target/Destination"},
        //plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
       // tags = {"@Dont,@AmazonSearch,@apiTest"},
       //plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},

        monochrome=true)
public class RunCucumberTest {
//    @AfterClass
//    public static void writeExtentReport() {
//        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
//    }
}
