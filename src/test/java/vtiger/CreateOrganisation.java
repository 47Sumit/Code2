package vtiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganisation {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		final WebDriver driver;
		FileInputStream fis = new FileInputStream("src\\test\\resources\\data3.properties");
		Properties p = new Properties();
		p.load(fis);
		String BROWSER  = p.getProperty("browser");
		String URL      = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		FileInputStream fisex = new FileInputStream("src\\test\\resources\\data3.xlsx");
		Workbook wb = WorkbookFactory.create(fisex);
		Sheet sh = wb.getSheet("Sheet1");
		Row rw = sh.getRow(1);
		Cell cl =rw.getCell(0);
		String DATA = cl.getStringCellValue();
		
		Row rw1 = sh.getRow(1);
		Cell cl1 =rw1.getCell(1);
		String DATA1 = cl1.getStringCellValue();
		
		driver.findElement(By.name("accountname")).sendKeys(DATA);
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		Select s = new Select(dropdown);
		s.selectByVisibleText(DATA1);
	}

}
