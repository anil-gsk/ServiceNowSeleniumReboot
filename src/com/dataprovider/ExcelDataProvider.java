package com.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	
	
	public XSSFWorkbook book;
	
	public XSSFSheet sheet;
	
	public XSSFRow row;
	
	public XSSFCell cell;
	
	
	ExcelDataProvider(){
		
		

		System.out.println("'ddddddddddddddddddddd'");
		
		Object[][] arryobj = getData("D:/Users/AnilGurramKonda/Desktop/AutomaticTester/TestLab/TestData/ExcelData.xlsx","TestData1");
		
		
	}
	

		
	@Test
	
	public void trigger(){
		
		ExcelDataProvider ex = new ExcelDataProvider();
		
		System.out.println("sdsdsdsdsdsdsdsdsdsdsdsd");
		
	}
		
		
		
		

	
	
	
	
	
	
	
	
	
	
	
/*//	
//	//@DataProvider(name = "Exceldata")
//	@Test
//	public Object[][] getExcelData(){
//		
//		
//		
//		
//		
//	}
*/
	public Object[][] getData(String FilePath, String SheetName) {
		
		Object[][] arrayExcelData = null;
		
		int row_count, cell_count;
		
		row_count = cell_count= 0;
	
		
		try {
			FileInputStream file = new FileInputStream(FilePath);
			
			try {
				book = new XSSFWorkbook(file);
				
				sheet = book.getSheet(SheetName);
				
				//Iterating All the rows
				Iterator rows = sheet.rowIterator();
				
				
				System.out.println(rows.hasNext());
				
				
				while(rows.hasNext()){
					
					
					
					row = (XSSFRow) rows.next();
					
					Iterator cells = row.cellIterator();
					
					
							while(cells.hasNext()){
								
								
								cell = (XSSFCell) cells.next();
								
								arrayExcelData[row_count][cell_count] = cell.getStringCellValue();
								
								cell_count++;
							}
					
							row_count++;
				}
				
				
				
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		return null;
	}
	
	
	

}
