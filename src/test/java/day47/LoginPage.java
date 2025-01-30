package day47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Locators
	By txt_userName = By.xpath("//input[@name='username']");
	By txt_passWord = By.xpath("//input[@name='password']");
	By btn_logIn = By.xpath("//button[@type='submit']");
	
	// Actions
	public void setUserName(String userName) {
		driver.findElement(txt_userName).sendKeys(userName);
	}
	public void setPassword(String password) {
		driver.findElement(txt_passWord).sendKeys(password);
	}
	public void clickLogin() {
		driver.findElement(btn_logIn).click();
	}

}
