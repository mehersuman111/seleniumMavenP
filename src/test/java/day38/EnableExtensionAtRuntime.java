package day38;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtensionAtRuntime {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		File file = new File("C:\\Suman\\\\Mine\\NAD\\Selenium\\Source Files Req\\CRX Files\\GoogleTranslate.crx");
		options.addExtensions(file);
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");

	}

}
