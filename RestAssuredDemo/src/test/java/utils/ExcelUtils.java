package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {

		try
		{
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet("Sheet1");
		} catch (Exception exp) {

			System.out.println(exp.getMessage());
			System.err.println(exp.getCause());
			exp.printStackTrace();
		}
	}
	public void getCellData(int rownum, int colNum) {

		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(sheet.getRow(rownum).getCell(colNum));
		System.out.println(value);
	}

	public void getRow() {

		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
	}
}
