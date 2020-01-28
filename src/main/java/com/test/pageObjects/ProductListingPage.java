package com.test.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductListingPage {
	WebDriver driver;
	public ProductListingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "button.single_add_to_cart_button") 
	private WebElement btn_AddToCart;

	@FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
	private List<WebElement> prd_List;

	@FindBy(xpath="//*[@id=\"pa_color\"]")
	private WebElement drpColor;

	@FindBy(xpath="//*[@id=\"pa_size\"]")
	private WebElement drpSize;

	public void clickOn_AddToCart() {
		btn_AddToCart.click();
	}

	public void select_Product(int productNumber) {
		prd_List.get(productNumber).click();
	}

	public void select_Size(String sSize) {
		Select sSelect = new Select(drpSize);
		sSelect.selectByVisibleText(sSize);
	}

	public void select_Color(String sColor) {
		Select sSelect = new Select(drpColor);
		sSelect.selectByVisibleText(sColor);
	}

	public String getProductName(int productNumber) {
		return prd_List.get(productNumber).findElement(By.cssSelector("h3")).getText();
	}
}
