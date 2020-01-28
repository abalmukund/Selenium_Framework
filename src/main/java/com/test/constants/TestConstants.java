package com.test.constants;

import com.test.manage.FileReaderManager;

public class TestConstants {
	public static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	public static final String CHROME_DRIVER_NAME = "chromedriver.exe";
	public static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	public static final String FIREFOX_DRIVER_NAME = "geckodriver.exe";
	public static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";
	public static final String IE_DRIVER_NAME = "IEDriverServer.exe";
	public static final String PROPERTY_FILE_PATH = "src//test//resources//config//Configuration.properties";
	public static final String DEFAULT_DRIVER_PATH = "src//test//resources//driver//";
	public static final String DEFAULT_TESTDATA_PATH = "src//test//resources//TestData//";
	public static final String SCREENSHOT_PATH = System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/";
	public static final String SCREENSHOT_IMAGE_EXT = ".png";
	public static final String REPORT_CONFIGURATION_FILE = "src//test//resources//config//report.xml";
	public static final long IMPLICIT_WAIT = FileReaderManager.getInstance().getConfigReader().getImplicitlyWait();
}
