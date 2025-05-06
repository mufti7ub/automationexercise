package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Features", glue = {
		"StepDefinitions" }, tags = "@Positive or @tag1", plugin = { "pretty",
				"html:target/cucumber-reports.html" }, monochrome = false, dryRun = false)

public class RunnerClass extends AbstractTestNGCucumberTests {}
