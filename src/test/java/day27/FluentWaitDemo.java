//package day27;
//
//import java.time.Duration;
//import java.util.NoSuchElementException;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.google.common.base.Function;
//
//public class FluentWaitDemo {
//
//	public static void main(String[] args) {
//		
//	WebDriver driver = new ChromeDriver();
//		
//		// Fluent Wait Declaration
//		Wait<WebDriver> myWait = new FluentWait<WebDriver>(driver)
//										.withTimeout(Duration.ofSeconds(30))
//										.pollingEvery(Duration.ofSeconds(5))
//										.ignoring(NoSuchElementException.class);
//		
//		
//		WebElement txtUser = myWait.until(new Function<WebDriver, WebElement>() {
//		     public WebElement apply(WebDriver driver) {
//		       return driver.findElement(By.linkText("OrangeHRM, Inc"));
//		     }
//		
//		//driver.findElement(By.linkText("OrangeHRM, Inc")).click();
//
//		
//		//driver.close();
//		//driver.quit();
//
//	
//	}
//
//}}