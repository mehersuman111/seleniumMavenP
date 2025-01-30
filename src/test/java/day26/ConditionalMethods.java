package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		//isDisplayed - We can check the display status of the element
		WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
		System.out.println("Display status of logo " + logo.isDisplayed());
		
		//isEnabled - We can check the enable/disable status of the element/operational element
		System.out.println(driver.findElement(By.name("username")).isEnabled());
		
		//isSelected - We can use to check the element us selected or not.
		
	}

}
