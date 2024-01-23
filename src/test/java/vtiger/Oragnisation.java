package vtiger;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Oragnisation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("http://localhost:8888/index.php?action=Login&module=Users");
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		d.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		d.findElement(By.id("submitButton")).click();
		d.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		d.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		d.findElement(By.name("accountname")).sendKeys("Qspiders");
		d.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
	}

}
