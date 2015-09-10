package com.mcnc.excel.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.mcnc.excel.test.data.Company;
import com.mcnc.excel.test.data.CompanyService;


public class ExcelWriterWithTemplate{
	public static final int ROW_NUMBER_WRITE_INDEX = 4;
	private String fileName;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public ExcelWriterWithTemplate(String fileName){
		this.fileName = fileName;
	}
	public void write() throws FileNotFoundException{
		File file = new File( fileName );
		if( !file.exists() )
			throw new FileNotFoundException();
		InputStream in = new FileInputStream( file );
		try {
			HSSFWorkbook workbook = new HSSFWorkbook( in );
			in.close();
			HSSFSheet sheet = workbook.getSheetAt( 0 );
			
			CompanyService companyService = new CompanyService();
			List< Company > companies = companyService.getCompanies();
			int i = ROW_NUMBER_WRITE_INDEX;
			for( Company com : companies ){
				HSSFRow createRow = sheet.createRow( i );
				createNewCells( com, createRow );
				i++;
			}
			
			saveToFile( file, workbook );
			
		} catch (IOException e) { 
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param file
	 * @param workbook
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void saveToFile( File file, HSSFWorkbook workbook )
			throws FileNotFoundException, IOException {
		OutputStream out = new FileOutputStream( file );
		workbook.write(out);
		out.close();
	}
	/**
	 * @param com
	 * @param createRow
	 */
	private void createNewCells( Company com, HSSFRow createRow ) {
		HSSFCell createCell = createRow.createCell( 0 );
		createCell.setCellValue( com.getComId() );
		HSSFCell createCell2 = createRow.createCell( 1 );
		createCell2.setCellValue( com.getComName() );
		HSSFCell createCell3 = createRow.createCell( 2 );
		createCell3.setCellValue( com.getAddress() );
	}
	
	public static void main( String[] arg){
		ExcelWriterWithTemplate util = new ExcelWriterWithTemplate( "src/test/resources/company.xls" );
		try {
			util.write();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}