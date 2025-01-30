package day38;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenShots {
			
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		
		WebElement closeBtn = driver.findElement(By.cssSelector("span.logSprite"));
		if (closeBtn.isDisplayed()) {
			closeBtn.click();
		}
//		//1) Capture full page screenshot
//		TakesScreenshot tss = (TakesScreenshot) driver;	// Type casting
//		//tss.getScreenshotAs(OutputType.FILE); --> This this getScreenshotsAs method will return an file types of object. And we are calling it from Interface. So,
//		File sourceFile = tss.getScreenshotAs(OutputType.FILE);	// So we can assign it to a file type of variable.
//																// Now we have captured the file and store it in a variable. But don't know where exactly is this.
//		// Now need to capture the file in some location.
//		File targetFile = new File(System.getProperty("user.dir")+"\\ScreenShots\\fullpage1.png");	// Target location has been defined.
//		
//		// Now we need to capture the source file in to our target location.
//		
//		sourceFile.renameTo(targetFile);	// renameTo() method copy from source to target
		
		//2) Capture a specific area on page
		
//		WebElement passengerType = driver.findElement(By.cssSelector("div.sc-12foipm-80"));
//		File sourceFile = passengerType.getScreenshotAs(OutputType.FILE);	// This getScreenShots method we are calling from Web element.
//		File targetFile = new File(System.getProperty("user.dir")+"\\ScreenShots\\specific1.png");
//		sourceFile.renameTo(targetFile);
		
		//3) Capture screenshot of web element
	
		WebElement flight = driver.findElement(By.xpath("(//a[@href='/flights/'])[1]"));
		File sourceFile = flight.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir")+"\\ScreenShots\\element1.png");
		sourceFile.renameTo(targetFile);
		
	}
	
}
