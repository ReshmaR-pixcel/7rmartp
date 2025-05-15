package utilities1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants1.Constants;



public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook wb;
	static XSSFSheet sh;
	public static String getStringData(int i, int j, String sheet) throws IOException {
		String filepath = Constants.TESTDATAFILE;
		
		f = new FileInputStream(filepath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		XSSFRow row = sh.getRow(i);
		XSSFCell cell = row.getCell(j);
		return cell.getStringCellValue();

	}
	public static String getIntegerData(int i, int j, String sheet) throws IOException {

		String filepath = Constants.TESTDATAFILE;
			f = new FileInputStream(filepath);
			wb = new XSSFWorkbook(f); 
			sh = wb.getSheet(sheet);
			XSSFRow row = sh.getRow(i);
			XSSFCell cell = row.getCell(j);
			int x = (int) cell.getNumericCellValue();
			return String.valueOf(x);
	
}
}
