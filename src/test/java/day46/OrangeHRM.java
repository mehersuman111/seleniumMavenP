package day46;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(day46.MyListener.class)
public class OrangeHRM {
	
	WebDriver driver;
	String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@BeforeClass
	void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test(priority = 1)
	void testLogo() {
		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
	}
	@Test(priority = 2)
	void testAppURL() {
		String appURL = driver.getCurrentUrl();
		Assert.assertEquals(appURL, baseURL+"s");
	}
	@Test(priority = 3, dependsOnMethods = {"testAppURL"})
	void verifyHomePageTitle() {
		String hpTitle = driver.getTitle();
		Assert.assertEquals(hpTitle, "OrangeHRM");
	}
	
	@AfterClass
	void teardown() {
		driver.quit();
	}
	
}
