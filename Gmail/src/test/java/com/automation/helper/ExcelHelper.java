package com.automation.helper;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelHelper {
	
	public static String[][] getTestdata(String filePath,String sheetName) throws Exception {

		String[][] data = null;

		File file = new File(filePath);

		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = WorkbookFactory.create(inputStream);

		Sheet sheet = workbook.getSheet(sheetName);

		data = new String[sheet.getPhysicalNumberOfRows()-1][sheet.getRow(0).getPhysicalNumberOfCells()];
		
		for (int rowIndex = sheet.getFirstRowNum()+1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			for (int colIndex = sheet.getRow(rowIndex).getFirstCellNum(); colIndex < sheet.getRow(rowIndex).getLastCellNum(); colIndex++) {
				
				if(ObjectUtils.isNotEmpty(sheet.getRow(rowIndex).getCell(colIndex))) {
					data[rowIndex-1][colIndex] = sheet.getRow(rowIndex).getCell(colIndex).toString();	
				}else {
					data[rowIndex-1][colIndex] = null;
				}
				
			}
		}

		workbook.close();

		return data;

	}


}
