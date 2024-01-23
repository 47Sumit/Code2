package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test2 {
	SoftAssert s = new SoftAssert();
   @Test
	public void vtiger() {
		// TODO Auto-generated method stub
	   WebDriver driver = new ChromeDriver();
		driver.get("https://demo.vtiger.com/vtigercrm/");
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		
		String expectedtitle = "vtigerSumit";
		s.assertEquals(actualtitle, expectedtitle);
		//Assert.assertEquals(actualtitle, expectedtitle);
		System.out.println(actualtitle);
		System.out.println("Good Morning");
		s.assertAll();//It is the method which is used to failed script in soft assert
		
		
		
		
		
		
		
		
		
		
		
//		String expectedtitle = "vtiger";
//		
//		if (actualtitle.equals(expectedtitle)) {
//			System.out.println("Title is same");
//			
//		} else {
//			System.out.println("Title is not same");
//
//		}

	}

}
