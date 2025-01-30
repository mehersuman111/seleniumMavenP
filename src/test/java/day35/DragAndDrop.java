package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		
		driver.findElement(By.id("Accepted Elements")).click();
		
		Actions action = new Actions(driver);
		
		driver.switchTo().frame(4);
		
		WebElement dragableEle = driver.findElement(By.id("draggable"));
		WebElement dropableEle = driver.findElement(By.id("droppable"));
		
		// Drag and drop
		action.dragAndDrop(dragableEle,dropableEle).perform();
	}

}
