package com.test.manage;

import java.util.List;

import com.test.testData.TestData;

public class TestDataManager {
	private static TestDataManager testDataManager = new TestDataManager();
	private String dataType;
	private List<TestData> testData;
	
	private TestDataManager() {
	}
	
	public static TestDataManager getInstance( ) {
		return testDataManager;
	}

	public List<TestData> getTestData() {
		dataType = FileReaderManager.getInstance().getConfigReader().getTestDataType();
		if (dataType.equalsIgnoreCase("json")) {
			testData = FileReaderManager.getInstance().getJsonReader().getTestData();
		}
		else if(dataType.equalsIgnoreCase("excel")) {
			testData = FileReaderManager.getInstance().getExcelReader().getTestData();
		}
		else {
			throw new RuntimeException("Test Data Type is not specified in the Configuration.properties file for the Key:testDataType");
		}
		return testData;
	}
	
	public void setTestData() {
		this.testData = getTestData();
	}
	
	public TestData getTestDataByTestCaseID(String testCaseID) {
		return testData.stream().filter(x -> x.TestCaseID.equalsIgnoreCase(testCaseID)).findAny().get();
	}
}
