package com.test.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.test.manage.FileReaderManager;
import com.test.testData.TestData;

public class JsonDataReader {
	private static JsonDataReader jsonDataReader = new JsonDataReader();
	private final String dataFileName = FileReaderManager.getInstance().getConfigReader().getTestDataFileName();
	private final String dataFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataPath() + dataFileName;
	public JsonDataReader(){
	}
	
	public static JsonDataReader getInstance( ) {
		return jsonDataReader;
	}

	public List<TestData> getTestData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(dataFilePath));
			TestData[] testData = gson.fromJson(bufferReader, TestData[].class);
			return Arrays.asList(testData);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + dataFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
}
