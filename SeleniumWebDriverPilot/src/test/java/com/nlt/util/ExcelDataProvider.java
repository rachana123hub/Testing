package com.nlt.util;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

	@DataProvider(name = "test1Data")
	public Object[][] getDataForSignUp() {
		String projectPath = System.getProperty("user.dir");
		String excelPath=(projectPath+"/excel/register.xlsx");
		String sheetName="sheet1";
		Object data[][]=testData(excelPath,sheetName);
		return data;
	}

	@DataProvider(name = "test2Data")
	public Object[][] getDataForLogin() {
		String projectPath = System.getProperty("user.dir");
		String excelPath=(projectPath+"/excel/credentials.xlsx");
		String sheetName="sheet1";
		Object data[][]=testData(excelPath,sheetName);
		return data;
	}


	public static Object[][] testData(String excelPath, String sheetName) {

		ExcelUtils excel =  new ExcelUtils(excelPath, sheetName);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		Object data[][] = new Object[rowCount-1][colCount];

		for(int i=1 ; i<rowCount ; i++) {
			for(int j=0 ; j<colCount ; j++) {

				String cellData = excel.getStringColumnData(i, j);
				data[i-1][j]=cellData;

			}

		}
		return data;
	}

}
