package com.mcnc.excel.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mcnc.excel.util.ExcelUtils;



public class ReadExcel {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String fileName = "src/test/resources/PushUsersTemplete.xlsx" ;
		Workbook workBook = null;
		FileInputStream file = new FileInputStream(new File(fileName));
		String fileExtension = FilenameUtils.getExtension(fileName);
		
		int rowCount = 0;		
		Sheet sheet = null;
		
		/*For xls 2003*/
		if(fileExtension.equalsIgnoreCase("xls")){
			//Get the workbook instance for XLS file 
			workBook = new HSSFWorkbook(file);
			
			//Get first sheet from the workbook - HSSFSheet
			sheet = workBook.getSheetAt(0);
			 
			//Get row number of related sheet
			rowCount = sheet.getPhysicalNumberOfRows();
			 
		}
		
		/*For xlsx 2007 or later*/
		
		else if(fileExtension.equalsIgnoreCase("xlsx"))
		{
			workBook = new XSSFWorkbook(file); 
			sheet = workBook.getSheetAt(0); //XSSFSheet
			rowCount = sheet.getPhysicalNumberOfRows();
		}
		
		List< ExcelUser > users = new ArrayList< ExcelUser >();
		
		/* Iterate each row*/
		for( int i = 1; i < rowCount; i++ ){
			Row row = sheet.getRow( i );
			ExcelUser user = new ExcelUser();
			Cell orderIdCell = row.getCell( 0 );
			if( orderIdCell != null ){
				user.setOrderId((Double) ExcelUtils.readCellValue(orderIdCell));
			}
			Cell targetIdCell = row.getCell( 1 );
			if( targetIdCell !=null )
				user.setTargetId((String) ExcelUtils.readCellValue(targetIdCell));
			Cell targetNameCell = row.getCell( 2 );
			if( targetNameCell != null )
				user.setTargetName((String) ExcelUtils.readCellValue(targetNameCell));
			Cell targetTypeCell = row.getCell( 3 );
			if( targetTypeCell != null )
				user.setTargetType((String) ExcelUtils.readCellValue(targetTypeCell));
			users.add( user );
		}
		
		System.out.println( users );
		
		file.close();
		workBook.close();
			
	}
		

}
