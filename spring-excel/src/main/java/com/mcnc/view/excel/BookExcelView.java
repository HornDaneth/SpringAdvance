package com.mcnc.view.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.mcnc.dto.Book;

public class BookExcelView extends AbstractExcelView {
	
	public static final String SHEET_NAME = "Book List";

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		List<Book> books = (List<Book>) model.get("books");
		
		HSSFSheet sheet = workbook.createSheet(SHEET_NAME);
		
		buildHeaderCells(workbook, sheet);
		
		int rowCount  = 1;
		for (Book book : books) {
			HSSFRow row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(book.getTitle());
            row.createCell(1).setCellValue(book.getAuthor());
            row.createCell(2).setCellValue(book.getIsbn());
            row.createCell(3).setCellValue(book.getPublishedDate());
            row.createCell(4).setCellValue(book.getPrice());
		}
		
	}
	
	
	
	
	private void buildHeaderCells(HSSFWorkbook workbook, HSSFSheet sheet){
		// create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
		
		
		// create header row
		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("Book Title");
		header.getCell(0).setCellStyle(style);

		header.createCell(1).setCellValue("Author");
		header.getCell(1).setCellStyle(style);

		header.createCell(2).setCellValue("ISBN");
		header.getCell(2).setCellStyle(style);

		header.createCell(3).setCellValue("Published Date");
		header.getCell(3).setCellStyle(style);

		header.createCell(4).setCellValue("Price");
		header.getCell(4).setCellStyle(style);
	}
}
