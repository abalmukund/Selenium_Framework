package com.test.manage;

import com.test.util.ConfigFileReader;
import com.test.util.ExcelDataReader;
import com.test.util.JsonDataReader;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static JsonDataReader jsonDataReader;
	private static ExcelDataReader excelDataReader;

	private FileReaderManager() {
	}

	public static FileReaderManager getInstance( ) {
		return fileReaderManager;
	}

	public ConfigFileReader getConfigReader() {
		return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	}

	public JsonDataReader getJsonReader(){
		return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;
	}
	
	public ExcelDataReader getExcelReader(){
		return (excelDataReader == null) ? new ExcelDataReader() : excelDataReader;
	}

}
