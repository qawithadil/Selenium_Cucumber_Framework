package genericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excellib {

	public static String readSingleCellData(String sheetName, int rowNum, int colNum) throws IOException {

		FileInputStream fis = new FileInputStream(Constants.file_path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowNum);
		String data = row.getCell(colNum).toString();
		workbook.close();
		fis.close();
		return data;

	}

	public static void setSingleCellData(String sheetName, int rowNum, int cellNum, String data) throws IOException {

		FileInputStream fis1 = new FileInputStream(Constants.file_path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis1);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(Constants.file_path);
		workbook.write(fos);
		fis1.close();
		workbook.close();
		fos.close();
	}

	public static void getSignleColumnData(String sheetName, int colNum) throws IOException {

		FileInputStream fis = new FileInputStream(Constants.file_path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int row_num = sheet.getLastRowNum();
		System.out.println("Total Number of Rows =" + row_num);
		for (int i = 1; i <= row_num; i++) {
			XSSFRow row = sheet.getRow(i);
			String data = row.getCell(colNum).toString();
			System.out.println("Data=" + data);
			fis.close();
			workbook.close();

		}

	}

	public static void setSingleColumnData(String sheetName, int rowCount, int colNum) throws IOException {

		FileInputStream fis = new FileInputStream(Constants.file_path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		for (int iRow = 1; iRow <= rowCount; iRow++) {
			XSSFRow row = sheet.getRow(iRow);
			XSSFCell cell = row.createCell(colNum);
			cell.setCellValue("This is Data in row" + iRow);
		}
		FileOutputStream fos = new FileOutputStream(Constants.file_path);
		workbook.write(fos);
		fis.close();
		workbook.close();
		fos.close();

	}
	
	public static void getSignleColumnDataLatest(String sheetName, int colNum) throws IOException {

		FileInputStream fis = new FileInputStream(Constants.file_path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int row_num = sheet.getLastRowNum();
		System.out.println("Total Number of Rows =" + row_num);
		for (int i = 1; i <= row_num; i++) {
			XSSFRow row = sheet.getRow(i);
			String data = row.getCell(colNum).toString();
			System.out.println("Data=" + data);
			fis.close();
			workbook.close();

		}

	}

	public static Object[][] getLoginCreds(File fileName, String sheetName) throws IOException {

		FileInputStream fis = new FileInputStream(fileName);
		// Load the workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// Go to the sheet
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int startRow = 1;
		int StartCol = 0;
		int ci, cj;
		int total_Row = sheet.getLastRowNum();
		int total_Col = 1;
		ci = 0;
		Object[][] credsArray = new Object[total_Row][total_Col + 1];
		for (int i = startRow; i <= total_Row; i++) {
			cj = 0;
			for (int j = StartCol; j <= total_Col; j++) {
				XSSFRow row = sheet.getRow(i);
				String data = row.getCell(j).toString();

				credsArray[ci][cj] = data;

				cj++;

			}
			ci++;
		}

		fis.close();
		workbook.close();
		return credsArray;
	}
	

}
