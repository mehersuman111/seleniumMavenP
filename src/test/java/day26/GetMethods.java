package day26;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//We can access these get methods throw web driver instance.
		
		//get(URL) --> Open the URL on the browser.
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//getTitle --> Returns the Title of the web page
		System.out.println(driver.getTitle());
		
		//getCurrentUrl --> Returns URL of the page
		System.out.println(driver.getCurrentUrl());
		
		//getPageSource --> Returns source code of the page
		System.out.println(driver.getPageSource());
		
		//getWindowHandle --> Return ID of the single browser window
		System.out.println(driver.getWindowHandle());
		
		//getWindowHandles --> Return IDs of the multiple browser windows
		Set<String> windowHs = driver.getWindowHandles();
		System.out.println(windowHs);
		
	}

}
