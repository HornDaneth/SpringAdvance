package com.mcnc.excel.util;

import org.apache.poi.ss.usermodel.Cell;

public abstract class ExcelUtils {
	public static Object readCellValue(Cell cell){
		Object result = null;
		int cellType = cell.getCellType();

		switch (cellType) {
		case Cell.CELL_TYPE_STRING:
			result = cell.getStringCellValue();
			break;
			
		case Cell.CELL_TYPE_NUMERIC:
			result = cell.getNumericCellValue();
			break;
			
		case Cell.CELL_TYPE_FORMULA:
			result = cell.getCellFormula();
			break;
		case Cell.CELL_TYPE_ERROR:
			result = cell.getErrorCellValue();
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			result = cell.getBooleanCellValue();
			break;
		case Cell.CELL_TYPE_BLANK:
			result = "";
		default:
			break;
		}
		
		return result;
	}
}
