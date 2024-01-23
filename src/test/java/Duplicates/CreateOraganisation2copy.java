package Duplicates;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commonutils.ExcelUtils;
import commonutils.FileUtils1;
import commonutils.JavaUtils;
import commonutils.WebDriverUtils;

public class CreateOraganisation2copy {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		final WebDriver driver;
		FileUtils1 futils = new FileUtils1();
		WebDriverUtils wutils = new WebDriverUtils();
		ExcelUtils eutils = new ExcelUtils();
		JavaUtils jutils = new JavaUtils();
		//To read the data from propety file
		String BROWSER  = futils.getDataFromProperty("browser");
		String URL      = futils.getDataFromProperty("url");
		String USERNAME = futils.getDataFromProperty("username");
		String PASSWORD = futils.getDataFromProperty("password");
		
		//to read the data from excel file
		String OrgName = eutils.getDataFromExcelFile("Sheet1", 1, 0);
		String Group = eutils.getDataFromExcelFile("Sheet1", 1, 1);
		String Industry = eutils.getDataFromExcelFile("Sheet1", 1, 2);
		
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		
		wutils.maximize(driver);
		wutils.implicitwait(driver);
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(OrgName+jutils.getrandomnumber());
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		wutils.handledropdown(dropdown, Group);
		wutils.handledropdown(dropdown, 2);
		//Dropdown WebElement
		WebElement industrydropdown = driver.findElement(By.name("industry"));
		wutils.handledropdown(industrydropdown, Industry);
		
		WebElement box = driver.findElement(By.name("notify_owner"));
		wutils.action(driver, box);
		//
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		Thread.sleep(5000);
		
		WebElement image = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		wutils.mouseover(driver, image);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}

	

}
