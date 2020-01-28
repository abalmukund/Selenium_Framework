package StepDefinition;

import org.openqa.selenium.WebDriver;

import com.test.cucumber.TestContext;
import com.test.enums.Context;
import com.test.pageObjects.CheckoutPage;
import com.test.util.Wait;

import cucumber.api.java.en.When;

public class CheckoutPageSteps {
	WebDriver driver;
	TestContext testContext;
	CheckoutPage checkoutPage;

	public CheckoutPageSteps(TestContext context) {
		this.driver = context.getWebDriverManager().getDriver();
		testContext = context;
		checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
	}

	@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page(){
		String testCaseID = testContext.scenarioContext.getContextMap(Context.TEST_CASE_ID).toString();
		checkoutPage.fill_PersonalDetails(testContext.scenarioContext.getContextData(testCaseID)); 
	}

	@When("^select same delivery address$")
	public void select_same_delivery_address() throws InterruptedException{
		checkoutPage.check_ShipToDifferentAddress(false);
	}

	@When("^select payment method as \"([^\"]*)\" payment$")
	public void select_payment_method_as_payment(String arg1){
		checkoutPage.select_PaymentMethod("CheckPayment");
	}

	@When("^place the order$")
	public void place_the_order() {
		checkoutPage.check_TermsAndCondition(true);
		checkoutPage.clickOn_PlaceOrder();
		Wait.untilJqueryIsDone(driver);
		Wait.untilPageLoadComplete(driver);
	} 

}