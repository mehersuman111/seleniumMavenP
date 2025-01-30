package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocators {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//1) Tag ID
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Samsung");
		//As tag is optional so it can be
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Samsung");
		
		//2) Tag ClassName
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Iphone");
		//on removing the tag name
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Iphone");
		
		//3) Tag Attribute
		//driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("Phone");
		//with out the tag name
		//driver.findElement(By.cssSelector("[placeholder='Search store']")).sendKeys("Phone");
		
		//4) Tag ClassName Attribute
		//driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("Tshirt");
		//as tag name is optional so
		driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("Tshirt");
		
	}

}
