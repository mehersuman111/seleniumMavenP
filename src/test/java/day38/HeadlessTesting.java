package day38;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	public static void main(String[] args) {
		
		
		// To run this in headless mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		
		WebElement closeBtn = driver.findElement(By.cssSelector("span.logSprite"));
		if (closeBtn.isDisplayed()) {
			closeBtn.click();
		}
		
		WebElement hotels = driver.findElement(By.xpath("(//a[@href='/hotels/'])[1]"));
		hotels.click();
		WebElement radioBtn = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
		radioBtn.click();
		WebElement header = driver.findElement(By.xpath("//h1"));
		System.out.println(header.getText());

	}

}
