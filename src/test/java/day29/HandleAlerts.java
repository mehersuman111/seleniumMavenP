package day29;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//1) Normal alert with OK button
		WebElement jsAlertBtn = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		jsAlertBtn.click();
		//driver.switchTo().alert().accept();
		// If we have to perform any action in the alert before clicking on OK button.
		Alert myAlert = driver.switchTo().alert();
		String alertText = myAlert.getText();
		System.out.println("The text present in the alert is " + alertText);
		myAlert.accept();
		
		//2) Confirmation alert with OK and Cancel button
		WebElement jsConfirmBtn = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
		jsConfirmBtn.click();
		Alert myAlert1 = driver.switchTo().alert();
		String alertText1 = myAlert1.getText();
		System.out.println("The text present in the Confirm alert is " + alertText1);
		myAlert1.dismiss();
		
		//3) Prompt alert with input box, Ok and Cancel button
		WebElement jsPromptBtn = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		jsPromptBtn.click();
		Alert myAlert2 = driver.switchTo().alert();
		myAlert2.sendKeys("Automation");
		myAlert2.accept();
	}

}
