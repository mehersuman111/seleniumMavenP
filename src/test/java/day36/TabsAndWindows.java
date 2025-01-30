package day36;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindows {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.nopcommerce.com/en");
		
		// If we have two URL and if aour requirement is like open an URL is one tab and nect URL in another tab.
		// For this in Selenium 4 has provided a new command like 
		
		// It will accept the parameter as Window type.
		// As soon as we execute above command then the cusrson will be in second window.
		
		driver.get("https://opensource-demo.orangehrmlive.com/auth/login");
		
		
		
		

	}

}
