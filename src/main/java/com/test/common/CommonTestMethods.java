package com.test.common;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.cucumber.listener.Reporter;
import com.test.util.Wait;

public class CommonTestMethods {
	WebDriver driver;

	public CommonTestMethods(WebDriver driver) {
		this.driver = driver;
	}

	public void leftClickObject(WebElement element) {
		try{
			element.click();
			Wait.untilJqueryIsDone(driver);
			Reporter.addStepLog("Clicked on object: " + element.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void rightClickObject(WebElement element) {
		Actions action = new Actions(driver);
		try {
			action.contextClick(element).perform();
			Reporter.addStepLog("Right clicked on object: " + element.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void doubleClickObject(WebElement element, Boolean acceptAlert) {
		Actions action = new Actions(driver);
		try {
			action.doubleClick(element).perform();
			if (acceptAlert.equals(true)) {
				//Switch to the alert box and click on OK button
				Alert alert = driver.switchTo().alert();
				System.out.println("Alert Text\n" +alert.getText());
				alert.accept();
			}
			Reporter.addStepLog("Double clicked on object: " + element.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void setValueObject(WebElement element, String sValue) {
		try {
			element.sendKeys(sValue);
			Reporter.addStepLog("Set value of object: '" + element.toString() + "' and value: '" + sValue + "'");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public String getPropertyObject(WebElement element, String propertyName) {
		String propertyVlue = null;
		try {
			propertyVlue = element.getAttribute(propertyName).toString();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return propertyVlue;
	}

	public int getWebTableRowCnt(WebElement element) {
		int rowCnt = 0;
		try {
			//element: Object of WebTable
			List<WebElement>TotalRowsList = element.findElements(By.tagName("tr"));
			rowCnt = TotalRowsList.size();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowCnt;
	}

	public int getWebTableColCnt(WebElement element) {
		int colCnt = 0;
		try {
			//element: Object of first tr tag in WebTable
			List<WebElement> TotalColsList = element.findElements(By.tagName("td"));
			colCnt = TotalColsList.size();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return colCnt;

	}
}
