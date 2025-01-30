package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement nameF = driver.findElement(By.id("name"));
		
		/* Create a variable for JavaScriptExecutor.
		   We can not create Object for this JavaScriptExecutor, because it is an Interface.
		   We need to assign the driver object to the Java Script Executor variable. But the driver object is WebDriver type.
		   So there is no relationship between JavascriptExecutor variable and driver. So using TypeCasting we can assign it.*/
		//JavascriptExecutor js = driver;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].setAttribute('value','Suman')", nameF);
		
		WebElement startBtn = driver.findElement(By.name("start"));
		js.executeScript("arguments[0].click()", startBtn);

	}

}
