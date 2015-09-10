package com.mcnc.excel.test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.mcnc.excel.test.data.Company;
import com.mcnc.excel.test.data.CompanyService;

public class ExcelWriter{
	public static final int ROW_NUMBER_WRITE_INDEX = 4;
	private String fileName;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public ExcelWriter( String fileName){
		this.fileName = fileName;
	}
	public void create() throws IOException{
		File file = createNewFile();
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(  );
			
			// create new sheet
			workbook.createSheet( "Company Sheet" );
			// get created sheet
			HSSFSheet sheet = workbook.getSheet( "Company Sheet" );
			// get companies
			CompanyService companyService = new CompanyService();
			List< Company > companies = companyService.getCompanies();
			
			
			/*create header*/
			createHeader( sheet , workbook );
			
			
			/*write data*/
			int i = ROW_NUMBER_WRITE_INDEX;
			// iterate on the companies
			for( Company com : companies ){
				// create new row of the sheet
				HSSFRow createRow = sheet.createRow( i );
				// create new cells
				createNewCells( com, createRow );
				i++;
			}
			
			// automatically fix columns' size
			autoSizeColumns( sheet );
			
			
			saveToFile( file, workbook );
			
		} catch (IOException e) { 
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void autoSizeColumns( HSSFSheet sheet ){
		sheet.autoSizeColumn( 0 );
		sheet.autoSizeColumn( 1 );
		sheet.autoSizeColumn( 2 );
	}
	
	private void createHeader( HSSFSheet sheet , HSSFWorkbook workbook){
		HSSFRow createRow = sheet.createRow( 3 );
		HSSFCell createCell = createRow.createCell( 0 );
		createCell.setCellValue( "Company Id" );
		applyStyle( createCell, workbook );
		
		HSSFCell createCell2 = createRow.createCell( 1 );
		createCell2.setCellValue( "Company Name" );
		applyStyle( createCell2, workbook );
		
		HSSFCell createCell3 = createRow.createCell( 2 );
		createCell3.setCellValue( "Address" );
		applyStyle( createCell3, workbook );
	}
	
	private void applyStyle( HSSFCell cell, HSSFWorkbook workbook ){
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor( HSSFColor.GREY_25_PERCENT.index );
		style.setFillPattern( HSSFCellStyle.SOLID_FOREGROUND );
		style.setVerticalAlignment( HSSFCellStyle.VERTICAL_CENTER );
		style.setWrapText( true );

		HSSFFont font = workbook.createFont();
		font.setFontName( HSSFFont.FONT_ARIAL );
		font.setColor( HSSFColor.BLUE_GREY.index );
		font.setBoldweight( HSSFFont.BOLDWEIGHT_BOLD );
		style.setFont( font );
		cell.setCellStyle( style );
	}
	
	
	/**
	 * @return
	 * @throws IOException
	 */
	private File createNewFile() throws IOException {
		File file = new File( fileName );
		file.getParentFile().mkdirs();
		file.createNewFile();
		return file;
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
		ExcelWriter util = new ExcelWriter( "src/test/resources/company.xls" );
		try {
			util.create();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}