package com.nlt.util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFWorkbook workbook=null;
	private static XSSFSheet sheet=null;


	public ExcelUtils(String excelPath,String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);

		} catch (IOException e) {

			e.printStackTrace();
		}


	}
	public int getRowCount() {

		int rowCount= sheet.getPhysicalNumberOfRows();
		return rowCount;


	}
	public int getColCount() {

		int colCount= sheet.getRow(0).getPhysicalNumberOfCells();
		return colCount;

	}
	public String getStringColumnData(int rowNum, int colNum) {

		String value= sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;

	}

	public Object getNumColumnData(int rowNum, int colNum) {

		double value1= sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		return value1;


	}	
}
