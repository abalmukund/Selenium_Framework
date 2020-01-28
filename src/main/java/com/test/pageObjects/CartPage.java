package com.test.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.test.common.CommonTestMethods;

public class CartPage {
	WebDriver driver;
	WebElement element;
	CommonTestMethods commonTestMethods;

	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		commonTestMethods = new CommonTestMethods(driver);
	}

	@FindBy(how = How.CSS, using = ".cart-button") 
	private WebElement btn_Cart;

	@FindBy(how = How.CSS, using = ".checkout-button.alt") 
	private WebElement btn_ContinueToCheckout;


	public void clickOn_Cart() {
		btn_Cart.click();
//		commonTestMethods.leftClickObject(btn_Cart);
	}

	public void clickOn_ContinueToCheckout() throws InterruptedException{
		btn_ContinueToCheckout.click();
//		commonTestMethods.leftClickObject(btn_ContinueToCheckout);
	}

}
