package StepDefinition;

import org.junit.Assert;

import com.test.cucumber.TestContext;
import com.test.enums.Context;
import com.test.pageObjects.ConfirmationPage;

import cucumber.api.java.en.Then;

public class ConfirmationPageSteps {
	TestContext testContext;
	ConfirmationPage confirmationPage;

	public ConfirmationPageSteps(TestContext context) {
		testContext = context;
		confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
	}

	@Then("^verify the order details$")
	public void verify_the_order_details(){
		String productName = (String)testContext.scenarioContext.getContextMap(Context.PRODUCT_NAME); //Get value of product from other step
		Assert.assertTrue(confirmationPage.getProductNames().stream().filter(x -> x.toLowerCase().contains(productName.toLowerCase())).findFirst().get().length()>10); 
	}

}
