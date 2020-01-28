package com.test.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.test.manage.FileReaderManager;
import com.test.testData.TestData;

public class ExcelDataReader {
	private static ExcelDataReader excelDataReader = new ExcelDataReader();
	private final String dataFileName = FileReaderManager.getInstance().getConfigReader().getTestDataFileName();
	private final String dataFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataPath() + dataFileName;
	public ExcelDataReader() {
	}
	
	public static ExcelDataReader getInstance( ) {
		return excelDataReader;
	}

	public List<TestData> getTestData() {
		Gson gson = new Gson();
		File file = new File(dataFilePath);
		TestData[] testData = gson.fromJson(getExcelDataAsJsonArray(file), TestData[].class);
		return Arrays.asList(testData);
	}

	public static JsonArray getExcelDataAsJsonArray(File excelFile) {
		//		JsonObject sheetsJsonObject = new JsonObject();
		XSSFWorkbook workbook = null;

		try {
			workbook = new XSSFWorkbook(excelFile);
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}

		JsonArray sheetArray = new JsonArray();
		ArrayList<String> columnNames = new ArrayList<String>();
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> sheetIterator = sheet.iterator();
		DataFormatter fmt = new DataFormatter();	
		while (sheetIterator.hasNext()) {
			Row currentRow = sheetIterator.next();
			JsonObject jsonObject = new JsonObject();
			if (currentRow.getRowNum() != 0) {
				for (int j = 0; j < columnNames.size(); j++) {
					if (currentRow.getCell(j) != null) {
						if (currentRow.getCell(j).getCellType() == CellType.STRING) {
							jsonObject.addProperty(columnNames.get(j), currentRow.getCell(j).getStringCellValue());
						} else if (currentRow.getCell(j).getCellType() == CellType.NUMERIC) {
							if (DateUtil.isCellDateFormatted(currentRow.getCell(j))) {
								Date date = currentRow.getCell(j).getDateCellValue();
								DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
								//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
								jsonObject.addProperty(columnNames.get(j), dateFormat.format(date).toString());
							} else {
								jsonObject.addProperty(columnNames.get(j), 
										fmt.formatCellValue(currentRow.getCell(j)).toString());
							}
							jsonObject.addProperty(columnNames.get(j), currentRow.getCell(j).getNumericCellValue());
						} else if (currentRow.getCell(j).getCellType() == CellType.BOOLEAN) {
							jsonObject.addProperty(columnNames.get(j), currentRow.getCell(j).getBooleanCellValue());
						} else if (currentRow.getCell(j).getCellType() == CellType.BLANK) {
							jsonObject.addProperty(columnNames.get(j), "");
						} else if (currentRow.getCell(j).getCellType() == CellType.FORMULA) {
							jsonObject.addProperty(columnNames.get(j), 
									Double.toString(currentRow.getCell(j).getNumericCellValue()));
						}
					} else {
						jsonObject.addProperty(columnNames.get(j), "");
					}
				}
				sheetArray.add(jsonObject);
			} else {
				// store column names
				for (int k = 0; k < currentRow.getPhysicalNumberOfCells(); k++) {
					columnNames.add(currentRow.getCell(k).getStringCellValue());
				}
			}
		}
		//		sheetsJsonObject.add("TestData", sheetArray);
		return sheetArray;
	}
}
