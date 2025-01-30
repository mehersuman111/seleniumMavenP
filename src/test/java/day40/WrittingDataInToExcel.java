package day40;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WrittingDataInToExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\SampleDataFileModify.xlsx");
		
		// Creating a new work book to attach in file
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("DataWr");
		
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Welcome");
		row1.createCell(1).setCellValue("To");
		row1.createCell(2).setCellValue("Data Driven Testing");
		
		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("Suman");
		row2.createCell(1).setCellValue("Kumar");
		row2.createCell(2).setCellValue("Meher");
		
		XSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("Java");
		row3.createCell(1).setCellValue("Python");
		row3.createCell(2).setCellValue("Framework");
		
		// To attach the created workbook in to the file
		wb.write(file);
		
		wb.close();
		file.close();
		
	}

}
