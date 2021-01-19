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
		System.out.println("Number of rows :"+rowCount);
		return rowCount;


	}
	public int getColCount() {

		int colCount= sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Number of cols :"+colCount);
		return colCount;

	}
	public String getStringColumnData(int rowNum, int colNum) {

		String value= sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		//System.out.println("username:"+value);
		return value;

	}

	public Object getNumColumnData(int rowNum, int colNum) {

		double value1= sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
	//	System.out.println("pass:"+value1);
		return value1;


	}	
}
