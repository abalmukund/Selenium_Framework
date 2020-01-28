package com.test.manage;

import org.openqa.selenium.WebDriver;

import com.test.pageObjects.CartPage;
import com.test.pageObjects.CheckoutPage;
import com.test.pageObjects.ConfirmationPage;
import com.test.pageObjects.HomePage;
import com.test.pageObjects.ProductListingPage;
import com.test.util.TakeScreenShot;

public class PageObjectManager {

	private WebDriver driver;
	private static TakeScreenShot takeScreenShot;
	private ProductListingPage productListingPage;
	private CartPage cartPage;
	private HomePage homePage;
	private CheckoutPage checkoutPage;
	private ConfirmationPage confirmationPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	//Do not remove this method
	public TakeScreenShot getTakeScreenShot() {
		return (takeScreenShot == null) ? new TakeScreenShot(driver) : takeScreenShot;
	}

	//All methods below are related to application specific pages
	public HomePage getHomePage(){
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public ProductListingPage getProductListingPage() {
		return (productListingPage == null) ? productListingPage = new ProductListingPage(driver) : productListingPage;
	}

	public CartPage getCartPage() {
		return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;
	}

	public CheckoutPage getCheckoutPage() {
		return (checkoutPage == null) ? checkoutPage = new CheckoutPage(driver) : checkoutPage;
	}
	
	public ConfirmationPage getConfirmationPage() {
		return (confirmationPage == null) ? confirmationPage = new ConfirmationPage(driver) : confirmationPage;
	}
}