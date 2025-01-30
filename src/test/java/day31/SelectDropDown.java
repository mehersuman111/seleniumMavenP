package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement selCountryDD = driver.findElement(By.id("country"));
		Select droCountry = new Select(selCountryDD);
		
		// Select option from the drop down
		droCountry.selectByVisibleText("Japan");
		droCountry.selectByValue("uk");
		droCountry.selectByIndex(9);
		
		// Capture the options available from the dropdown
		 List<WebElement> options = droCountry.getOptions();
		 System.out.println("The total no of options in the Country dropdown is " + options.size());
		 
		 // Printing the options
		 for (WebElement option : options) {
			System.out.println(option.getText());
		}
	}

}
