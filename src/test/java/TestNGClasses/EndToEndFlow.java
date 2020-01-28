package TestNGClasses;

import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.cucumber.TestContext;
import com.test.manage.TestDataManager;
import com.test.pageObjects.CartPage;
import com.test.pageObjects.CheckoutPage;
import com.test.pageObjects.ConfirmationPage;
import com.test.pageObjects.HomePage;
import com.test.pageObjects.ProductListingPage;
import com.test.testData.TestData;
import com.test.util.Wait;

public class EndToEndFlow {
	WebDriver driver;
	TestContext testContext;
	HomePage homePage;
	ProductListingPage productListingPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	ConfirmationPage confirmationPage;

	@BeforeMethod
	public void beforeTest() {
		testContext = new TestContext();
		this.driver = testContext.getWebDriverManager().getDriver();
		TestDataManager.getInstance().setTestData();
		homePage = testContext.getPageObjectManager().getHomePage();
		productListingPage = testContext.getPageObjectManager().getProductListingPage();
		cartPage = testContext.getPageObjectManager().getCartPage();
		checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
		confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
	}
	
	@Test
	@Parameters({"testCaseID"})
	public void firstTest(String testCaseID) throws InterruptedException {
		TestData testData = testContext.scenarioContext.getContextData(testCaseID);
		homePage.navigateTo_HomePage();
		homePage.perform_Search("dress");
		String productName = productListingPage.getProductName(0);
		productListingPage.select_Product(0);
		productListingPage.select_Color(testData.productColor);
		productListingPage.select_Size(testData.productSize);
		productListingPage.clickOn_AddToCart();
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout();
		checkoutPage.fill_PersonalDetails(testData);
		checkoutPage.check_TermsAndCondition(true);
		checkoutPage.clickOn_PlaceOrder();
		Wait.untilJqueryIsDone(driver);
		Wait.untilPageLoadComplete(driver);
		Assert.assertTrue(confirmationPage.getProductNames().stream().filter(x -> x.toLowerCase().contains(productName.toLowerCase())).findFirst().get().length()>0);
	}
	
	@Test
	@Parameters({"testCaseID"})
	public void secondTest(String testCaseID) throws InterruptedException {
		TestData testData = testContext.scenarioContext.getContextData(testCaseID);
		homePage.navigateTo_HomePage();
		homePage.perform_Search("dress");
		String productName = productListingPage.getProductName(0);
		productListingPage.select_Product(0);
		productListingPage.select_Color(testData.productColor);
		productListingPage.select_Size(testData.productSize);
		productListingPage.clickOn_AddToCart();
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout();
		checkoutPage.fill_PersonalDetails(testData);
		checkoutPage.check_TermsAndCondition(true);
		checkoutPage.clickOn_PlaceOrder();
		Wait.untilJqueryIsDone(driver);
		Wait.untilPageLoadComplete(driver);
		Assert.assertTrue(confirmationPage.getProductNames().stream().filter(x -> x.toLowerCase().contains(productName.toLowerCase())).findFirst().get().length()>0);
	}
	
	@AfterMethod
	public void AfterMethod() {
		testContext.getWebDriverManager().closeDriver();
	}
}
