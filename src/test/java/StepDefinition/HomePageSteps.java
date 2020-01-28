package StepDefinition;

import com.test.cucumber.TestContext;
import com.test.enums.Context;
import com.test.pageObjects.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class HomePageSteps {
	TestContext testContext;
	HomePage homePage;

	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	@Given("^user \"([^\"]*)\" is on Home Page$")
	public void user_is_on_Home_Page(String testCaseID){
		testContext.scenarioContext.setContextMap(Context.TEST_CASE_ID, testCaseID);
		homePage.navigateTo_HomePage();
	}

	@When("^user search for \"([^\"]*)\"$")
	public void user_search_for(String product)  {
		homePage.perform_Search(product);
	}
}
