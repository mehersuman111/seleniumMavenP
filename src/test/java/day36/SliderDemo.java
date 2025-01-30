package day36;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		WebElement minSlider = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle')])[1]"));
		// To know the current position of the Slider
		System.out.println("The current location of minimum Slider is "+minSlider.getLocation());	
									// getLocation is belongs to webElement not driver.
									// This method will return the location of the element i.e., X axis and Y axis.
									// This getLocation() will return the pointer type of an object.
		
		// To move the slider element
		Actions action = new Actions(driver);
		// Especially for slider element we have an method called dragAndDropBy() with parameter as the slider element and X axis and Y axis target.
		Thread.sleep(5000);
		action.dragAndDropBy(minSlider, 100, 250).perform();
		System.out.println("Location of the minimum slider after moving is " + minSlider.getLocation());
		
		WebElement maxSlider = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle')])[2]"));
		System.out.println("The current location of aximum Slider is "+maxSlider.getLocation());
		Thread.sleep(5000);
		action.dragAndDropBy(maxSlider, -144, 250).perform();
		System.out.println("Location of the maximum slider after moving is " + maxSlider.getLocation());
	}

}
