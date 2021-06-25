package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestUtil {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try {
			
			reader = new Xls_Reader("E:\\Eclipse_workspace\\SeleniumTraining\\src\\com\\testdata\\Book2.xlsx");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		for(int row = 2; row<=reader.getRowCount("Sheet1"); row++) {
			
			String emailData = reader.getCellData("Sheet1", "email", row);
			String passwordData = reader.getCellData("Sheet1", "password", row);
			
			Object ob[] = {emailData, passwordData};
			
			mydata.add(ob);
			
		}
		
		return mydata;
		
	}

}
