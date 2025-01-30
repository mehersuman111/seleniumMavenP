package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/upload");
		
		// Single file upload
		WebElement chooseFileBtn = driver.findElement(By.id("fileInput"));
//		chooseFileBtn.sendKeys("C:\\Suman\\Mine\\NAD\\Certificate\\Cloud Computing Udemy Cert.pdf");
		// To validate if it is uploaded
		
		// Multiple files upload
		String file1 = "C:\\Suman\\Mine\\NAD\\Certificate\\Cloud Computing Udemy Cert.pdf";
		String file2 = "C:\\Suman\\Mine\\NAD\\Certificate\\Virtualization Udemy Cert.pdf";
		
		chooseFileBtn.sendKeys(file1+"\n"+file2);

	}

}
