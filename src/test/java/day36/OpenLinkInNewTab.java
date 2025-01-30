package day36;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenLinkInNewTab {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.nopcommerce.com/en");
		
		WebElement getStarted = driver.findElement(By.xpath("(//a[text()='Get started'])[2]"));
		Actions act = new Actions(driver);
		
		// CTRL + Click
		act.keyDown(Keys.CONTROL).click(getStarted).keyUp(Keys.CONTROL).perform();
		
		// Switch to next window
			// We need to get the window handle list in the Array list because it preserve the indexing concept and HasSet does not.
		ArrayList<String> winHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(winHandles.get(1));
		
		WebElement quote = driver.findElement(By.xpath("(//a[text()='Request a quote'])[1]"));
		quote.click();
		
		driver.switchTo().window(winHandles.get(0));
		
		WebElement viewDemo = driver.findElement(By.xpath("(//a[text()='View demo'])[1]"));
		viewDemo.click();
		
		
		
	}

}
