package day29;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckBoxes {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//1) Select specific check box
//		driver.findElement(By.id("sunday")).click();
		
		//2) Select multiple check boxes
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		/*for (WebElement checkBox : checkBoxes) {
			checkBox.click();
		}*/
		
		//3) Select last 3 check boxes
		/*for (int i = checkBoxes.size()-3; i < checkBoxes.size(); i++) {
			checkBoxes.get(i).click();
		}*/
		
		//4) Select first 3 check boxes
		/*for (int i = 0; i < 3; i++) {
			checkBoxes.get(i).click();
		}*/
		
		//5) Unselect check box if they are selected
		for (WebElement checkBox : checkBoxes) {
			if (checkBox.isSelected()) {
				checkBox.click();
			}
		}
	}

}
