package vtiger;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Contacts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("http://localhost:8888/index.php?action=Login&module=Users");
		d.findElement(By.name("user_name")).sendKeys("admin");
		d.findElement(By.name("user_password")).sendKeys("admin");
		d.findElement(By.id("submitButton")).click();
		d.findElement(By.xpath("//a[text()='Contacts']")).click();
		d.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
	    
		d.findElement(By.name("lastname")).sendKeys("Butle");
		d.findElement(By.name("assigntype")).click();
		d.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		 WebElement b = d.findElement(By.xpath("(//td[@class='small'])[2]"));
		Actions a=new Actions(d);
		a.moveToElement(b).perform();

	}

}
