package StepDefinition;

import com.test.cucumber.TestContext;
import com.test.enums.Context;
import com.test.pageObjects.ProductListingPage;
import com.test.testData.TestData;

import cucumber.api.java.en.When;

public class ProductPageSteps {
	TestContext testContext;
	ProductListingPage productListingPage;

	public ProductPageSteps(TestContext context) {
		testContext = context;
		productListingPage = testContext.getPageObjectManager().getProductListingPage();
	}

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		String productName = productListingPage.getProductName(0);
		String testCaseID = testContext.scenarioContext.getContextMap(Context.TEST_CASE_ID).toString();
		testContext.scenarioContext.setContextMap(Context.PRODUCT_NAME, productName); //Set value of product to be used in other steps
		TestData testData = testContext.scenarioContext.getContextData(testCaseID);
		productListingPage.select_Product(0);
		productListingPage.select_Color(testData.productColor);
		productListingPage.select_Size(testData.productSize);
		productListingPage.clickOn_AddToCart(); 
	}
}
