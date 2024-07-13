package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.*;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/Features", glue = { "Steps" }, monochrome = true, publish = true, plugin = {
        "pretty", "html:target/HtmlReports/report.html", "json:target/JsonReport/report.json",
        "junit:target/JunitReport/report.xml" }, tags = "@SmokeTest"

)
public class Runner {

}
