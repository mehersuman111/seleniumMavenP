package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
		
		//XPath with single attribute.
		driver.findElement(By.xpath("//input[@type='text']"));
		
		//XPath with multiple attribute
		driver.findElement(By.xpath("//input[@type='text'][@name='email']"));
		
		//XPath with AND operator
		driver.findElement(By.xpath("//input[@type='text' and @name='firstname']"));
		
		//XPath with OR operator
		driver.findElement(By.xpath("//input[@type='text' and @name='xyz']"));
		
		//XPath with Text Method - Inner text
		driver.findElement(By.xpath("//a[text()='Blog']")).click();
		
		//XPath with Contains Method
		driver.findElement(By.xpath("//a[contains(@class,'black')]")).click();
		
		//XPath with Starts-with Method
		driver.findElement(By.xpath("//img[starts-with(@alt,'Facebook')]")).click();
		
		//Chained XPath
		Boolean imageStatus = driver.findElement(By.xpath("//div[@id='logo']/a/img")).isDisplayed();
		
		
	}
}