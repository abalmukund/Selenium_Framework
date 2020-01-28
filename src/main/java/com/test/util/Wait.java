package com.test.util;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.constants.TestConstants;


public class Wait {
	private static Long timeoutInSeconds = TestConstants.IMPLICIT_WAIT;

	public static void untilJqueryIsDone(WebDriver driver){
		untilJqueryIsDone(driver, timeoutInSeconds);
	}

	public static void untilJqueryIsDone(WebDriver driver, Long timeoutInSeconds){
		until(driver, (d) ->
		{
			Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
			if (!isJqueryCallDone) System.out.println("JQuery call is in Progress");
			return isJqueryCallDone;
		}, timeoutInSeconds);
	}

	public static void untilPageLoadComplete(WebDriver driver) {
		untilPageLoadComplete(driver, timeoutInSeconds);
	}

	public static void untilPageLoadComplete(WebDriver driver, Long timeoutInSeconds){
		until(driver, (d) ->
		{
			Boolean isPageLoaded = (Boolean)((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			if (!isPageLoaded) System.out.println("Document is loading");
			return isPageLoaded;
		}, timeoutInSeconds);
	}

	public static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition){
		until(driver, waitCondition, timeoutInSeconds);
	}

	private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds){
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
		webDriverWait.withTimeout(Duration.ofSeconds(timeoutInSeconds));
		try{
			webDriverWait.until(waitCondition);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}          
	}


}