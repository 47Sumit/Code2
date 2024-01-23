package onlineclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
@Test
public class Testng1 {
	@BeforeSuite
	public void BS() {
		System.out.println("BS");
	}
	@AfterSuite
	public void AS() {
		System.out.println("AS");
		
	}
	@AfterClass
	public void Close() {
		System.out.println("Close the browser");
	}
	@BeforeClass
	public void Open() {
		System.out.println("Launch the browser");
	}
	@AfterMethod
	public void Logout() {
		System.out.println("Logout from the application");
	}
	@Test
	public void acti() {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}

}
