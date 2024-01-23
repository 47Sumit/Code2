package commonutils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass1 {
	public WebDriver driver;
	FileUtils1 futils = new FileUtils1();
	WebDriverUtils wutils = new WebDriverUtils();
	
	@BeforeSuite
	public void BS() {
		System.out.println("Connect To Database");
	}
	@BeforeClass
	public void BC() throws IOException {
		 String BROWSER  = futils.getDataFromProperty("browser");
		 String URL   = futils.getDataFromProperty("url");
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		wutils.maximize(driver);
		wutils.implicitwait(driver);
		
		//To launch URL
		driver.get(URL);
		
		
	}
	@BeforeMethod
	public void  BM () throws IOException {
		String USERNAME = futils.getDataFromProperty("username");
		String PASSWORD = futils.getDataFromProperty("password");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();	
	}

}
