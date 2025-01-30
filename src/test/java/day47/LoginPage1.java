package day47;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {

	WebDriver driver;
	
	// Constructor
		public LoginPage1(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
	//@FindBy(xpath = "//input[@name='username']")
	@FindBy(how = How.XPATH,using="//input[@name='username']")
	WebElement userNameF;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordF;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement logInBtn;
	@FindBy(tagName = "a")
	List<WebElement> links;
	
	// Actions
		public void setUserName(String userName) {
			userNameF.sendKeys(userName);
		}
		public void setPassword(String password) {
			passwordF.sendKeys(password);
		}
		public void clickLogin() {
			logInBtn.click();
		}
		public LoginPage1() {
			// TODO Auto-generated constructor stub
		}
		
}
