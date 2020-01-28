package StepDefinition;

import com.cucumber.listener.Reporter;
import com.test.cucumber.TestContext;
import com.test.manage.TestDataManager;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	TestContext testContext;
	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before
	public void BeforeScenario(Scenario scenario) {
		Reporter.assignAuthor("Bal Mukund Agrawal");
		System.out.println("------------------------------");
	    System.out.println("Starting - " + scenario.getName());
	    System.out.println("------------------------------");
	    TestDataManager.getInstance().setTestData();
	}

	@After
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			testContext.getPageObjectManager().getTakeScreenShot().getScreenShot("Failed Scenario", true);
		}
		testContext.getWebDriverManager().closeDriver();
		System.out.println("------------------------------");
	    System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
	    System.out.println("------------------------------");
	}
}
