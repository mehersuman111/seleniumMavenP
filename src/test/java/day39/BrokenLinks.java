package day39;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://www.deadlinkcity.com/");
		
		int noOfBrokenLink = 0;
		// Check links href attribute and respective values.
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The no of avaiable links are " + links.size());
		
		for (WebElement link : links) {
			String hrefAttVal = link.getAttribute("href");
			System.out.println("The href value is " + hrefAttVal);
			
			if (hrefAttVal.equals(null) || hrefAttVal.isEmpty()) {
				System.out.println("Href attribute value is null or empty. So not possible to verify.");
				continue;
			}
			try {
			// Hit URL to the server.
				// Need to convert the String to URL format.
			URL linkURL = new URL(hrefAttVal);		// Will convert the href attribute value in to URL format.
			System.out.println("Href string value after conveted to URL type is " +linkURL);
			HttpsURLConnection connLinkURL = (HttpsURLConnection)linkURL.openConnection();		// This method will open the connection to the server.
			connLinkURL.connect();// Connect to server and send request to server.
			
			if (connLinkURL.getResponseCode()>=400) {
				System.out.println(" It is a broken link.");
				noOfBrokenLink++;
			}else{
				System.out.println("It is not a broken link.");
			};
			}catch (Exception e) {
				// TODO: handle exception
				e.getStackTrace();
			}
		}
		System.out.println("No of broken links is " + noOfBrokenLink);
	}

}
