package com.qa.hubspot.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	//Read Data from Excel File:
	
		public static String TEST_DATA_SHEET_PATH=System.getProperty("user.dir")+File.separator+"TestData"+File.separator+"ContactsData.xlsx";
		public static Workbook book;
		public static Sheet sheet;
		public static Object[][] getTestData(String sheetName) {
			
			try {
				FileInputStream file = new FileInputStream(TEST_DATA_SHEET_PATH);
				book = WorkbookFactory.create(file);
				sheet = book.getSheet(sheetName);
				
				Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
				for(int i=0; i< sheet.getLastRowNum(); i++) {
					for(int k=0; k< sheet.getRow(0).getLastCellNum();k++) {
						data[i][k] = sheet.getRow(i+1).getCell(k).toString();
					}
				}
				
				return data;
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (EncryptedDocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	return null;
			
		}
	}
	
	
	

