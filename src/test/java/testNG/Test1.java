package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1 {
	@Test(priority=3)
	public void facebook() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
	}
		
	@Test(invocationCount=1,priority=1)
	public void zomato() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://zomato.com/");
		
	}
	@Test(priority=2)
	public void instagram() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
		
	}
		
	

}
