package vtiger;
import java.io.IOException;
import java.util.Set;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import commonutils.BaseClass;
import commonutils.ExcelUtils;
import commonutils.FileUtils1;
import commonutils.WebDriverUtils;

public class CreateContact extends BaseClass {
	
		FileUtils1 futils = new FileUtils1();
		WebDriverUtils wutils = new WebDriverUtils();
		ExcelUtils eutils = new ExcelUtils();
		@Test
		public void Contact() throws EncryptedDocumentException, IOException, InterruptedException   {
			// TODO Auto-generated method stub
		
		//To read the data from propety file
		
		String FIRSTNAME = eutils.getDataFromExcelFile("Sheet1", 1, 3);
		String LASTNAME = eutils.getDataFromExcelFile("Sheet1", 1, 4);
		String DROP = eutils.getDataFromExcelFile("Sheet1", 2, 1);
		
		wutils.implicitwait(driver);
		
		driver.findElement(By.xpath("(//a[text()='Contacts'][1])")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		wutils.handledropdown(dropdown, DROP);
		
        driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		
		Set<String> s = driver.getWindowHandles();
		for (String st : s) {
			driver.switchTo().window(st);
			
		}
		driver.findElement(By.id("search_txt")).sendKeys("Qspider47");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Qspider47']")).click();
		
		//To transfer the control from child to parent
		for (String allids : s) {
					
		String allurl = driver.switchTo().window(allids).getCurrentUrl();
		System.out.println(allurl);
		String parenturl = "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
		if (allurl.contains(parenturl)) {
			break;
						
			}
		}
		wutils.screenshot(driver, "Sumit1");
		WebElement image = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutils.mouseover(driver, image);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}

}
