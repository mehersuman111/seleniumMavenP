package day40;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WrittingDynamicDataInToExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\DynamicDataFile.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("DyData");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter how many rows ?");
		int noOfRows = sc.nextInt();
		
		System.out.println("Enter how many cells ?");
		int noOfCells = sc.nextInt();
		
		for (int r = 0; r<=noOfRows; r++) {
			
			XSSFRow curRow = sheet.createRow(r);
			
			for (int c = 0; c < noOfCells; c++) {
				XSSFCell curCell = curRow.createCell(c);
				curCell.setCellValue(sc.next());
			}
		}
		
		wb.write(file);
		
		wb.close();
		file.close();

	}

}
