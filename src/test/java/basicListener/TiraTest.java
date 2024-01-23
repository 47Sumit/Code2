package basicListener;

import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
//@Listeners(Listenerimplementation.class)
public class TiraTest {
	
	@Test
	public  void PerfumeTest() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.tirabeauty.com/");
		//Assert.assertEquals("pune", "Deccan");
		WebElement searchtf = driver.findElement(By.id("search"));
		searchtf.sendKeys("perfumes");
		searchtf.sendKeys(Keys.ENTER);
		
	}
//	@Test
//	public void LaunchTest() {
//		
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.zomato.com/");
//		
//	}

}
