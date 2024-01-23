package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test3 {
	@Test
	public void vtigercrm () {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
	   WebElement loginbtn = driver.findElement(By.id("submitButton"));
//	   Assert.assertTrue(loginbtn.isEnabled());
//	   Assert.assertTrue(loginbtn.isSelected());
	   Assert.assertFalse(loginbtn.isSelected());
	   Assert.assertFalse(loginbtn.isEnabled());
	   System.out.println("Hello");
		
		
	}

}
