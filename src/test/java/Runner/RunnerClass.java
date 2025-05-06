package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
  features   = "src/test/java/features",          // adjust if you moved them
  glue       = {"StepDefinitions"},
  tags       = "@Positive or @tag1",
  monochrome = true, // clean console
  dryRun = false,
  plugin     = {
    "pretty", // console friendly
    "summary", // overall stats
    "json:target/cucumber-report/cucumber.json", // for CI or Allure
    "junit:target/cucumber-report/cucumber.xml", // Jenkins JUnit publisher
    "rerun:target/cucumber-report/rerun.txt", // failed scenarios
    "html:target/cucumber-report/html", // built‑in HTML
    // ✅ the right Cucumber‑7 Extent adapter:
    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"  // ExtentReports dashboard
  }
)
public class RunnerClass extends AbstractTestNGCucumberTests { }
