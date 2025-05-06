package StepDefinitions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Initiate.baseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends baseClass {

	@Before
	public void beforeScenarioSettings() {
		
		browserSetup();

	}
	
	@After
	public void tearDown(Scenario scenario) throws IOException {
	    if (scenario.isFailed()) {
	        String screenshotPath = captureScreenshot(driver, scenario.getName());

	        // Attach to ExtentReports (Cucumber 7+ adapter auto-detects it)
	        scenario.attach(Files.readAllBytes(Paths.get(screenshotPath)), "image/png", "Failure Screenshot");
	    }

	    browserQuit(); // or driver.quit()
	}

}
