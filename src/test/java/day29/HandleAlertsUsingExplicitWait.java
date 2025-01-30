package day29;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlertsUsingExplicitWait {

	public static void main(String[] args) {
		
		// Handle alert without using the switchTo() command - *** Imp ***
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement jsAlertBtn = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		jsAlertBtn.click();
		
		Alert myAlert = myWait.until(ExpectedConditions.alertIsPresent());
		
		String alertText = myAlert.getText();
		System.out.println("The text present in the alert is " + alertText);
		myAlert.accept();
	}

}
