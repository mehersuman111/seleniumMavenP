package day29;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticatedPoup {

	public static void main(String[] args) {
		
		// This is a special type of popup where we have to pass the Username and Password.
		/* Also we can not handle this popup using switch().to() or with explicit wait.
		 * Here we have to pass the username and password along with the url.
		 * 
		 * 	https://the-internet.herokuapp.com/basic_auth	----->	https://username:password@the-internet.herokuapp.com/basic_auth
		 * 
		 * In this way we can avoid this.
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		
	}

}
