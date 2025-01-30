package day28;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment28 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement searchBox = driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));
		searchBox.sendKeys("Automation");
		WebElement searchButton = driver.findElement(By.className("wikipedia-search-button"));
		searchButton.click();
		
		//Set<WebElement> searchResult = (Set<WebElement>) driver.findElement(By.xpath("//div[contains(@id,'wikipedia-search')]//a[@target='_blank']"));
		List<WebElement> searchResult = driver.findElements(By.xpath("//div[contains(@id,'wikipedia-search')]//a[@target='_blank']"));
		System.out.println("The no of search result is " + searchResult.size());
		
		for (WebElement webElement : searchResult) {
			webElement.click();
			System.out.println("The window id for " + webElement.getText());
		}
		
		Set<String> windowIDs = driver.getWindowHandles();
		for (String winID : windowIDs) {
			driver.switchTo().window(winID);
			System.out.println("The window id for " + driver.getWindowHandle());
			String title = driver.getTitle();
			System.out.println("The title of the window handle is " + title);
			
			if (title.equals("Automation Master - Wikipedia")) {
				driver.close();
			}
		}
		
	}

}
