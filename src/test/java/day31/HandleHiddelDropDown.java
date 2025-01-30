package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleHiddelDropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		
		WebElement usernameF = driver.findElement(By.name("username"));
		usernameF.sendKeys("Admin");
		WebElement passwordF = driver.findElement(By.name("password"));
		passwordF.sendKeys("admin123");
		WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		loginBtn.click();
		
		WebElement pimTab = driver.findElement(By.xpath("//a[contains(@href,'viewPim')]/.."));
		pimTab.click();
		
		WebElement jobTitleDD = driver.findElement(By.xpath("(//div[contains(@class,'oxd-select-text')])[7]"));
		jobTitleDD.click();
		
//		WebElement ceoOpt = driver.findElement(By.xpath("//span[text()='Chief Financial Officer']/.."));
//		ceoOpt.click();
		
		// Count no of options
		List<WebElement> options =  driver.findElements(By.xpath("//div[@role='listbox']//span"));
		System.out.println("No of options " + options.size());
		
		// Printing options
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
	}

}
