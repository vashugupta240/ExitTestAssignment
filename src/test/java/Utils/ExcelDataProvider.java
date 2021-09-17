package Utils;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

	@DataProvider(name = "ValidLogin")
	public Object[][] getData1() {

		String excelPath = ".\\Resources\\TestData.xlsx";
		Object data[][] = testData(excelPath, "validLogin");
		return data;
	}
	
	@DataProvider(name = "invalidLogin")
	public Object[][] getData2() {

		String excelPath = ".\\Resources\\TestData.xlsx";
		Object data[][] = testData(excelPath, "invalidLogin");
		return data;
	}
	@DataProvider(name = "addressTest")
	public Object[][] getData3() {

		String excelPath = ".\\Resources\\TestData.xlsx";
		Object data[][] = testData(excelPath, "address");
		return data;
	}

	@DataProvider(name = "buyAProduct")
	public Object[][] getData5() {

		String excelPath = ".\\Resources\\TestData.xlsx";
		Object data[][] = testData(excelPath, "buyAProduct");
		return data;
	}
	@DataProvider(name = "searchAproduct")
	public Object[][] getData6() {

		String excelPath = ".\\Resources\\TestData.xlsx";
		Object data[][] = testData(excelPath, "searchAproduct");
		return data;
	}
	
	@DataProvider(name = "loginForAllMethod")
	public Object[][] getData4() {
		String excelPath = ".\\Resources\\TestData.xlsx";
		Object data[][] = testData(excelPath, "loginforalltestcase");
		return data;
	}
	public static Object[][] testData(String excelPath, String sheetName) {
		ExcelFile excel = new ExcelFile(excelPath, sheetName);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		Object data[][] = new Object[rowCount - 1][colCount];
			for (int i = 1; i < rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					String cellData = excel.getCellDataString(i, j);
					data[i - 1][j] = cellData;
				}
			}
		return data;
	}
}
