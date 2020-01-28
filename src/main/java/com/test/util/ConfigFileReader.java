package com.test.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.test.constants.TestConstants;
import com.test.enums.DriverType;
import com.test.enums.EnvironmentType;

public class ConfigFileReader { 
	private Properties properties;

	public ConfigFileReader(){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(TestConstants.PROPERTY_FILE_PATH));
			properties = new Properties();
			try { properties.load(reader); }
			catch (IOException e) { e.printStackTrace(); }
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Properties file not found at path : " + TestConstants.PROPERTY_FILE_PATH);
		}finally {
			try { if(reader != null) reader.close(); }
			catch (IOException ignore) {}
		} 
	}

	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) {
			if (driverPath.equalsIgnoreCase("default")) {
				return TestConstants.DEFAULT_DRIVER_PATH;
			}
			else {
				return driverPath;
			}
		}
		else throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath"); 
	}

	public long getImplicitlyWait() { 
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) {
			try{
				return Long.parseLong(implicitlyWait);
			}catch(NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			}
		}
		return 30; 
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
		else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}

	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}

	public String getTestDataPath(){
		String testDataPath = properties.getProperty("testDataPath");
		if(testDataPath!= null) {
			if (testDataPath.equalsIgnoreCase("default")) {
				return TestConstants.DEFAULT_TESTDATA_PATH;
			}
			else {
				return testDataPath;
			}
		}
		else throw new RuntimeException("Test Data Resource Path is not specified in the Configuration.properties file for the Key:testDataResourcePath"); 
	}

	public String getTestDataType(){
		String testDataType = properties.getProperty("testDataType");
		if(testDataType!= null) return testDataType;
		else throw new RuntimeException("Test Data Type is not specified in the Configuration.properties file for the Key:testDataType"); 
	}
	public String getTestDataFileName(){
		String testDataFileName = properties.getProperty("testDataFileName");
		if(testDataFileName!= null) return testDataFileName;
		else throw new RuntimeException("Test Data File Name is not specified in the Configuration.properties file for the testDataFileName"); 
	}
	
	public String getNodeURL() {
		String nodeURL = properties.getProperty("nodeURL");
		if(nodeURL!= null) return nodeURL;
		else throw new RuntimeException("Node URL is not specified in the Configuration.properties file for the nodeURL");
	}
}
