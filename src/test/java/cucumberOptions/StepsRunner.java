package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\features\\Login.feature", glue = {
		"stepDefinitions" }, monochrome = true, plugin = { "pretty", "html:target/cucumber-reports.html" })
public class StepsRunner {

}


// This line added -1