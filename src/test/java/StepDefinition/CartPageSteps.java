package StepDefinition;

import org.openqa.selenium.WebDriver;

import com.test.cucumber.TestContext;
import com.test.pageObjects.CartPage;

import cucumber.api.java.en.When;

public class CartPageSteps {
	WebDriver driver;
	TestContext testContext;
	CartPage cartPage;

	public CartPageSteps(TestContext context) {
		testContext = context;
		cartPage = testContext.getPageObjectManager().getCartPage();
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart() throws InterruptedException{
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout();
	}

}
