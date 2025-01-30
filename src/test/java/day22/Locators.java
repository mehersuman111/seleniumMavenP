package day22;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.demoblaze.com/");
		
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total no of links available in this page is " + links.size());
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total no of images available in this page is " + images.size());
		
		WebElement signUp = driver.findElement(By.partialLinkText("up"));
		signUp.click();

	}

}
