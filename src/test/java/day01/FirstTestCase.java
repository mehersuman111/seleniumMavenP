package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {
	
	public static void main(String args[]) {
		
		System.out.println("Testing");
		
		//1) Lunch browser.
		//ChromeDriver driver = new ChromeDriver();
		
		// We can also do this with WebDriver because WebDriver is Parent only and ChromeDriver is derived from RemoteWebdriver 
		//i.e., also derived from parent WebDriver.

		WebDriver driver = new ChromeDriver();
		
		//2) Open the URL
		// driver variable will use the get method which accept a parameter of String type
		driver.get("https://www.google.com/");
		
		//3) Validate the title
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals("Google")) {
			System.out.println("Test passed");
		}
		else {
			System.out.println("Test Failed");
		}
		
		//4) Close the browser
		driver.close();
		//driver.quit();
	}

}
