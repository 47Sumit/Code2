package vtiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class vtigerXLreading {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
//		FileInputStream fis = new FileInputStream("src\\test\\resources\\data2.xlsx");
//		
//        Workbook wb = WorkbookFactory.create(fis);
//		
//		//To get control of the sheet
//	    Sheet sh = wb.getSheet("Sheet1");
//	    
//	    //To get control of row
//	    Row rw = sh.getRow(0);
//	    
//	    //To get control of cl
//	    Cell cl = rw.getCell(1);
//	      
//	    //to get the value of the cell
//	    String data = cl.getStringCellValue();
//	    System.out.println(data);
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		FileInputStream fis1 = new FileInputStream("src\\test\\resources\\data2.xlsx");
	    Workbook wb = WorkbookFactory.create(fis1); 
	    Sheet sh = wb.getSheet("Sheet1");
	    Row rw = sh.getRow(1);
	    Cell cl = rw.getCell(1);
	    String data = cl.getStringCellValue();
	    driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(data);
	    System.out.println(data);	    
		driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		Row rw1 = sh.getRow(2);
		Cell c2 = rw1.getCell(2);
		String data1 = c2.getStringCellValue();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(data1);

	}

}
