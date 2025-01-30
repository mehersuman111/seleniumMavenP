package day36;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://text-compare.com/");
		
		WebElement textArea1 = driver.findElement(By.id("inputText1"));
		textArea1.sendKeys("Welcome");
		
		Actions act =  new Actions(driver);
		
		// Ctrl + A		--> Select the Text
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		
		// Ctrl + C		--> Copy the Text
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		
		// Tab			--> Shift to second box
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		
		// Ctrl + V		--> Paste the Text
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
		// If we have three key action like CTRL+SHIFT+A
		act.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("A").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
	}

}
