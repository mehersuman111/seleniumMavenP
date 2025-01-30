package day42;

import org.testng.annotations.Test;

public class FirstTestCase {
	
	@Test
	void openApp() {
		System.out.println("Opening the application.");
	}
	@Test
	void loginApp() {
		System.out.println("Login in to the application.");
	}
	@Test
	void logoutApp() {
		System.out.println("Logout from the application.");
	}
	
}