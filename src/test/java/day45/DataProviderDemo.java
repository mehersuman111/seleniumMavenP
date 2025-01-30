package day45;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import day47.LoginPage;

public class DataProviderDemo {
	
	WebDriver driver;
	
	@BeforeClass
	void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(dataProvider = "credentialList")
	void logIn(String userName, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickLogin();
		
		//driver.switchTo().alert().accept();
		Boolean status = driver.findElement(By.xpath("(//img[@alt='profile picture'])[1]")).isDisplayed();
		if (status.equals(true)) {
			driver.findElement(By.cssSelector("li.oxd-userdropdown")).click();
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
			Assert.assertTrue(true);
		}else {
			Assert.fail();
		}
	}
	
	@DataProvider(name="credentialList",indices = {0,2})
	Object[][] logInData() {
		Object data[][] = {
							{"abc@gmail.com","Test@123"},
							{"suman@gmail.com","Suman@123"},
							{"suman111@gmail.com","Suman@123"},
							{"Admin","admin123"}
						  };
		return data;
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}

}
