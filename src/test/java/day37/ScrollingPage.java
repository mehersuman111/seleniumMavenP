package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.britannica.com/topic/list-of-countries-1993160");

		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// 1) Scroll down the page by Pixel number.
		js.executeScript("window.scrollBy(0,3000)", "");
		// To capture where we are exactly now after scrolling
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		// 2) Scroll the page till the element is visible
		WebElement ele = driver.findElement(By.xpath("//a[text()='Oman']"));
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		// 3) Scroll page till end of the page.	
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		// 4) Scrolling up to the initial position.
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
	}

}
