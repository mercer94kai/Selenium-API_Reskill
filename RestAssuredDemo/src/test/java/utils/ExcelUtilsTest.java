package utils;

public class ExcelUtilsTest {

	public static void main(String[] args) {
		
		String excelPath = "./data/TestData.xlsx";
		String sheetName = "sheet1";
		
		ExcelUtils exl = new ExcelUtils(excelPath, sheetName);
		exl.getRow();
		exl.getCellData(1, 0);
		exl.getCellData(1, 1);
		exl.getCellData(1, 2);
	}

}
