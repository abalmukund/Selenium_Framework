package com.test.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.manage.FileReaderManager;
import com.test.util.ConfigFileReader;

public class HomePage {
	WebDriver driver;
	ConfigFileReader configFileReader;

	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		configFileReader= new ConfigFileReader();
	}
	
	@FindBy(xpath = "//a[@class=\"noo-search\"]")
	private WebElement btn_Search;
	
	@FindBy(xpath = "//input[@type=\"search\"]")
	private WebElement txt_Search;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement btn_SearchSubmit;

	public void perform_Search(String search) {
		btn_Search.click();
		txt_Search.sendKeys(search);
		btn_SearchSubmit.submit();
	}

	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

}
