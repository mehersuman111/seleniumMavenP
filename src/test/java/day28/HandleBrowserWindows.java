package day28;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> windowIDs = driver.getWindowHandles();
		
		/* If we have multiple items in above windowIDs and if we want to extract it one by one individually, we can not extract it
		Because Set collection don't have a get method to access individual item as Set collection doesn't follow indexing concept.
		So that is the reason we convert Set collection to List collection. So that in List collection we can extract individual item using get() method.*/
		/*//Approach - 1 - Convert Set collection to list - To extract the ID
			// Recommended only when we have 2/3 browser windows.
		List<String> windowsList = new ArrayList<String>(windowIDs);
		String parentID = windowsList.get(0);
		String childID = windowsList.get(1);
		
		//Switch to child window
		driver.switchTo().window(childID);
		System.out.println(driver.getTitle());
		
		//Switch to parent window
		driver.switchTo().window(parentID);*/
		
		//Approach - 2 - Looping statement
			// Recommended when we have multiple browser windows
		for (String winID : windowIDs) {
			String title = driver.switchTo().window(winID).getTitle();
			if (title.equals("OrangeHRM")) {
				//Actions
			}
		}
}
}	