package com.test.manage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.test.constants.TestConstants;
import com.test.enums.DriverType;
import com.test.enums.EnvironmentType;

public class WebDriverManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		switch (environmentType) {     
		case LOCAL : driver = createLocalDriver();
		break;
		case REMOTE : driver = createRemoteDriver();
		break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() {
		String nodeURL = FileReaderManager.getInstance().getConfigReader().getNodeURL();
		DesiredCapabilities capability;
		switch (driverType) { 
		case FIREFOX : 
			capability = DesiredCapabilities.firefox();
	        capability.setBrowserName(driverType.toString().toLowerCase());
	        capability.setPlatform(Platform.WIN10);
	        try {
				driver = new RemoteWebDriver(new URL(nodeURL), capability);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	        break;
		case CHROME :
			capability = DesiredCapabilities.chrome();
	        capability.setBrowserName(driverType.toString().toLowerCase());
	        capability.setPlatform(Platform.WIN10);
	        try {
				driver = new RemoteWebDriver(new URL(nodeURL), capability);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	        break;
		case INTERNETEXPLORER :
			capability = DesiredCapabilities.internetExplorer();
	        capability.setBrowserName(driverType.toString().toLowerCase());
	        capability.setPlatform(Platform.WIN10);
	        try {
				driver = new RemoteWebDriver(new URL(nodeURL), capability);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	        break;
		}
		if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestConstants.IMPLICIT_WAIT, 
				TimeUnit.SECONDS);
		return driver;
	}

	private WebDriver createLocalDriver() {
		switch (driverType) {     
		case FIREFOX : 
			System.setProperty(TestConstants.FIREFOX_DRIVER_PROPERTY, 
					FileReaderManager.getInstance().getConfigReader().getDriverPath() + TestConstants.FIREFOX_DRIVER_NAME);
			driver = new FirefoxDriver();
			break;
		case CHROME : 
			System.setProperty(TestConstants.CHROME_DRIVER_PROPERTY, 
					FileReaderManager.getInstance().getConfigReader().getDriverPath() + TestConstants.CHROME_DRIVER_NAME);
			driver = new ChromeDriver();
			break;
		case INTERNETEXPLORER : 
			System.setProperty(TestConstants.IE_DRIVER_PROPERTY, 
					FileReaderManager.getInstance().getConfigReader().getDriverPath() + TestConstants.IE_DRIVER_NAME);
			driver = new InternetExplorerDriver();
			break;
		}

		if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestConstants.IMPLICIT_WAIT, 
				TimeUnit.SECONDS);
		return driver;
	} 

	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}