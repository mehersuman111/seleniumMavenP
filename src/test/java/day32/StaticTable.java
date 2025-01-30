package day32;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		int currentPrice = 0;
		
		// 1) Find total no of rows in a table
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		int rowSize = rows.size();
		System.out.println("The number of rows is " + rowSize);
		
		// 2) Find total no of columns in the table
		List<WebElement> columns = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		int colSize = columns.size();
		System.out.println("The total no of column present in the table is " + colSize);
		
		// 3) Read data from specific row and column. Suppose 5th row and 1st column
		String cellValue = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println("The value present in 5th row and 1st column is " + cellValue);
		
		// 4) Read data from all the rows and columns
		for (int r = 2; r<=rowSize; r++) {
			for (int c = 1; c <=colSize; c++) {
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.println(value + "\t");
			}
			System.out.println();
		}
		
		// 5) Conditional based
		for (int r = 2; r <= rowSize; r ++) {
			if (driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText().equals("Mukesh")) {
				System.out.println(("The book authored by Mukesh is "+driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText()));
			}
			
		}
		
		// To find total price
		for (int r = 2; r <= rowSize; r ++) {
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			currentPrice = currentPrice + Integer.valueOf(price);
			}
		System.out.println("The total value prices of all book is " + currentPrice);
			
		}
		

	}
