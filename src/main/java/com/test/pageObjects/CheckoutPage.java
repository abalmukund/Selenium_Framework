package com.test.pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.testData.TestData;
import com.test.util.Wait;

public class CheckoutPage {
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "#billing_first_name") 
	private WebElement txtbx_FirstName;

	@FindBy(how = How.CSS, using = "#billing_last_name") 
	private WebElement txtbx_LastName;

	@FindBy(how = How.CSS, using = "#billing_email") 
	private WebElement txtbx_Email;

	@FindBy(how = How.CSS, using = "#billing_phone") 
	private WebElement txtbx_Phone;

	@FindBy(xpath="//*[@id=\"billing_country\"]") 
	private WebElement drpdwn_CountryDropDown;

	@FindBy(xpath="//*[@id=\"billing_state\"]") 
	private WebElement drpdwn_CountyDropDown;

	@FindAll(@FindBy(how = How.CSS, using = "#select2-drop ul li"))
	private List<WebElement> country_List; 

	@FindBy(how = How.CSS, using = "#billing_city") 
	private WebElement txtbx_City;

	@FindBy(how = How.CSS, using = "#billing_address_1") 
	private WebElement txtbx_Address;

	@FindBy(how = How.CSS, using = "#billing_postcode") 
	private WebElement txtbx_PostCode;

	@FindBy(how = How.CSS, using = "#ship-to-different-address-checkbox") 
	private WebElement chkbx_ShipToDifferetAddress;

	@FindAll(@FindBy(how = How.CSS, using = "ul.wc_payment_methods li"))
	private List<WebElement> paymentMethod_List; 

	@FindBy(xpath="//*[@id=\"terms\"]")
	private WebElement chkbx_AcceptTermsAndCondition;

	@FindBy(how = How.CSS, using = "#place_order") 
	private WebElement btn_PlaceOrder;


	public void enter_Name(String name) {
		txtbx_FirstName.sendKeys(name);
	}

	public void enter_LastName(String lastName) {
		txtbx_LastName.sendKeys(lastName);
	}

	public void enter_Email(String email) {
		txtbx_Email.sendKeys(email);
	}

	public void enter_Phone(String phone) {
		txtbx_Phone.sendKeys(phone);
	}

	public void enter_City(String city) {
		txtbx_City.sendKeys(city);
	}

	public void enter_Address(String address) {
		txtbx_Address.sendKeys(address);
	}

	public void enter_PostCode(String postCode) {
		txtbx_PostCode.sendKeys(postCode);
	}

	public void check_ShipToDifferentAddress(boolean value) throws InterruptedException {
		if(!value) chkbx_ShipToDifferetAddress.click();
		Wait.untilJqueryIsDone(driver);
	}

	public void select_Country(String countryName) {
		Select sSelect = new Select(drpdwn_CountryDropDown);
		sSelect.selectByVisibleText(countryName);
	}

	public void select_County(String countyName) {
		Select sSelect = new Select(drpdwn_CountyDropDown);
		sSelect.selectByVisibleText(countyName);
	}

	public void select_PaymentMethod(String paymentMethod) {
		if(paymentMethod.equals("CheckPayment")) {
			paymentMethod_List.get(0).click();
		}else if(paymentMethod.equals("Cash")) {
			paymentMethod_List.get(1).click();
		}else {
			new Exception("Payment Method not recognised : " + paymentMethod);
		}
		Wait.untilJqueryIsDone(driver);

	}

	public void check_TermsAndCondition(boolean value) {
		if(value) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", chkbx_AcceptTermsAndCondition);
		}
	}

	public void clickOn_PlaceOrder() {
		btn_PlaceOrder.submit();
	}

	public void fill_PersonalDetails(TestData testData) {
		enter_Name(testData.firstName);
		enter_LastName(testData.lastName);
		enter_Phone(testData.mob);
		enter_Email(testData.emailAddress);
		enter_City(testData.city);
		enter_Address(testData.streetAddress);
		enter_PostCode(testData.postCode);
		select_Country(testData.country);
		select_County(testData.county); 
	}
}
