package StepDefinitions;

import Initiate.baseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends baseClass {

	@Before
	public void beforeScenarioSettings() {
		
		browserSetup();

	}

	@After
	public void afterScenarioSettings() {
		
		browserQuit();

	}

}
