package com.qa.utils;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
	
	@DataProvider(name="data-provider")
	public static Object[] getData() {
		String filename= Constants.EXCEL_SHEET_EMPLOYEE;
		ExcelReader excel = new ExcelReader(Constants.EXCEL_TESTDATA_FILE_PATH);
		Hashtable<String,String> table;
		int rowCount= excel.getRowCount(filename);
		int colCount= excel.getColumnCount(filename);
		
		Object data [][]=new Object[rowCount-1][1];
		
		
		for(int row=2; row<=rowCount; row++ ) {
			
			table= new Hashtable<String,String>();
			
			for(int col=0; col<colCount; col++) {
				
				table.put(excel.getCellData(filename, col, 1), excel.getCellData(filename, col, row));
				
			
				
				
				
			}
			
			data[row-2][0]=table;
			
		}
		
		
		return data;
		
	}

}
