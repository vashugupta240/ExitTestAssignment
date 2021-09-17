package Utils;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelFile {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public ExcelFile(String excelPath,String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static int getRowCount() {
		int rowCount=0;
		try {
			rowCount=sheet.getPhysicalNumberOfRows();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public static int getColCount() {
		int colCount=0;
		try {
			colCount=sheet.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return colCount;
	}
	
	public static String getCellDataString(int rowNum,int colNum) {
		String cellData=null;
		try {
			cellData=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellData;
	}
	public static void getCellDataNumber(int rowNum,int colNum) {
		double cellData;
		try {
			cellData=sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(cellData);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
