package com.test.cucumber;

import java.util.HashMap;
import java.util.Map;

import com.test.enums.Context;
import com.test.manage.TestDataManager;
import com.test.testData.TestData;

public class ScenarioContext {

	private  Map<String, Object> scenarioContextMap;

	public ScenarioContext() {
		scenarioContextMap = new HashMap<>();
	}

	public void setContextMap(Context key, Object value) {
		scenarioContextMap.put(key.toString(), value);
	}

	public Object getContextMap(Context key){
		return scenarioContextMap.get(key.toString());
	}

	public Boolean isContains(Context key){
		return scenarioContextMap.containsKey(key.toString());
	}
	
	public TestData getContextData(String testCaseID) {
		return TestDataManager.getInstance().getTestDataByTestCaseID(testCaseID);
	}
}