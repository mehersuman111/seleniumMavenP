package day32;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		WebElement searchBox = driver.findElement(By.id("APjFqb"));
		searchBox.sendKeys("Selenium");
		
		List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		
		for (WebElement searchOpt : suggestions) {
			System.out.println("The search options appearing are " + searchOpt.getText());
			
			if (searchOpt.getText().equals("selenium grid")) {
				searchOpt.click();
				break;
			}
		}

	}

}
