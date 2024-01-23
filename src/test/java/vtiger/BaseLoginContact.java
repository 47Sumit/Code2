package vtiger;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import commonutils.ExcelUtils;
import commonutils.FileUtils1;
import commonutils.WebDriverUtils;
import pom.ContactPage;
import pom.Homepage1;
import pom.Loginpage;

public class BaseLoginContact {

	
	public static void main(String[]args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		final WebDriver driver;
		FileUtils1 futils = new FileUtils1();
		WebDriverUtils wutils = new WebDriverUtils();
		ExcelUtils eutils = new ExcelUtils();
		
		//To read the data from propety file
	    String BROWSER  = futils.getDataFromProperty("browser");
		String URL      = futils.getDataFromProperty("url");
		String USERNAME = futils.getDataFromProperty("username");
		String PASSWORD = futils.getDataFromProperty("password");
				
		String FIRSTNAME = eutils.getDataFromExcelFile("Sheet1", 1, 3);
		String LASTNAME = eutils.getDataFromExcelFile("Sheet1", 1, 4);
		String DROP = eutils.getDataFromExcelFile("Sheet1", 2, 1);
		//String PARENTURL = eutils.getDataFromExcelFile("Sheet1", 1, 5);
		//String CHILDURL = eutils.getDataFromExcelFile("Sheet1", 1, 6);
		
		
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		
		//To launch URL
		driver.get(URL);
		
		//Maximize the window
		wutils.maximize(driver);
		//To apply implicite wait
		wutils.implicitwait(driver);
		
		//To login the page
		Loginpage lp =new Loginpage();
		PageFactory.initElements(driver, lp);
		lp.getUsernametf().sendKeys(USERNAME);
		lp.getPasswordtf().sendKeys(PASSWORD);
		lp.getLoginbtn().click();
		
		//To navigate the Homepage
		Homepage1 hp1 = new Homepage1();
		PageFactory.initElements(driver, hp1);
		hp1.getContact().click();
		hp1.getContactlink().click();
		
		//To navigate the Organization page
		ContactPage con = new ContactPage();
		PageFactory.initElements(driver, con);
		con.getFirstnametf().sendKeys(FIRSTNAME);
		con.getLastnametf().sendKeys(LASTNAME);
		con.getContactAssigntobtn().click();
		
		wutils.handledropdown(con.getContactdropdown(), DROP);
		
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		
		Set<String> ids= driver.getWindowHandles();
		//to transfer control from parent to child
		for (String allids : ids) {
			//System.out.println(allids);
			String allurl = driver.switchTo().window(allids).getCurrentUrl();
			System.out.println(allurl);
		
		}
		//to enter the Orgnisation name in text feild
		driver.findElement(By.id("search_txt")).sendKeys("Qspider47");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Qspider47']")).click();
		Thread.sleep(4000);
		
		//To transfer the control from child to parent
		for (String allids : ids) {
			
			String allurl = driver.switchTo().window(allids).getCurrentUrl();
			System.out.println(allurl);
			String parenturl = "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
			
			if (allurl.contains(parenturl)) {
				break;
				
			}
		}
		//To take the Screenshot of webpage
		wutils.screenshot(driver, "Sumit");

		
		//To Scroll the Page
		Thread.sleep(2000);
		wutils.scrolling(driver);

		
		con.getContactSavebtn().click();
		
		wutils.mouseover(driver, con.getContactImagebtn());
		
		Thread.sleep(3000);
		con.getContactSignoutbtn().click();
		
	}

}
