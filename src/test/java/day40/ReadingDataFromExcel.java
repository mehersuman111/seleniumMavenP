package day40;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		//System.out.println(System.getProperty("user.dir"));
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\SampleTestDataFile.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		int totalRows = sheet.getLastRowNum();
		
		int totalCells = sheet.getRow(1).getLastCellNum();
		
		System.out.println("The total number of rows are " + totalRows);
		System.out.println("Total number of cell in any rows are " + totalCells);
		System.out.println("\n");
		
		for (int r = 0; r <= totalRows; r++) {
			{
				XSSFRow curRow = sheet.getRow(r);
				
				for (int c = 0; c < totalCells; c++) {
					XSSFCell curCell = curRow.getCell(c);
					System.out.print(curCell.toString()+"\t");
				}
				System.out.println("\n");
			}
		}
		
		wb.close();
		fis.close();
	}

}
