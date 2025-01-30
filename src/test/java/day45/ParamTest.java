package day45;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {
	
	WebDriver driver;
	
//	@FindBy(xpath = "//img[@alt='company-branding']")
//	WebElement logo;
	
	@BeforeClass
	@Parameters({"browser"})
	void setUp(String br) {
		
		switch (br.toLowerCase()) {
		case "chrome" : driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		case "safari" : driver = new SafariDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		default:
			System.out.println("Invalid brouser name...!");
			return;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(baseURL);
	}
	
	@Test(priority = 1)
	void testLogo() throws InterruptedException {
		Thread.sleep(3000);
		Boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
	}
	
	@Test(priority = 2)
	void testTitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test(priority = 3)
	void testURL() {
		Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}
}
