package vtiger;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import commonutils.ExcelUtils;
import commonutils.FileUtils1;
import commonutils.WebDriverUtils;
import pom.Homepage;
import pom.Loginpage;
import pom.Organizationinformationpage;

public class BaseLogin {

	public static void main (String[]args) throws IOException, InterruptedException {
		final WebDriver driver;
		FileUtils1 futils = new FileUtils1();
		WebDriverUtils wutils = new WebDriverUtils();
		ExcelUtils eutils = new ExcelUtils();
		
		//To read the data from propety file
		String BROWSER  = futils.getDataFromProperty("browser");
		String URL      = futils.getDataFromProperty("url");
		String USERNAME = futils.getDataFromProperty("username");
		String PASSWORD = futils.getDataFromProperty("password");
		
		//to read the data from excel file
	    String OrgName = eutils.getDataFromExcelFile("Sheet1", 1, 0);
		String Group = eutils.getDataFromExcelFile("Sheet1", 1, 1);
		//String Industry = eutils.getDataFromExcelFile("Sheet1", 1, 2);
		
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		driver.get(URL);
		wutils.maximize(driver);
		wutils.implicitwait(driver);
		
		//To login the page
		Loginpage lp =new Loginpage();
		PageFactory.initElements(driver, lp);
		lp.getUsernametf().sendKeys(USERNAME);
		lp.getPasswordtf().sendKeys(PASSWORD);
		lp.getLoginbtn().click();
		
		//To navigate the Homepage
		Homepage hp = new Homepage();
		PageFactory.initElements(driver, hp);
		hp.getOraganization().click();
		hp.getOragnazationlink().click();
		
		//To navigate the Organization page
		Organizationinformationpage org = new Organizationinformationpage();
		PageFactory.initElements(driver, org);
		org.getOrganizationtf().sendKeys(OrgName);
		org.getAssigntobtn().click();
		
		wutils.handledropdown(org.getAssigntodropdown(), Group);
		org.getSavebtn().click();
		wutils.screenshot(driver, "sumit3");
		
		Thread.sleep(2000);
		wutils.mouseover(driver, org.getImagebtn());
		org.getSignoutbtn().click();;
		

	}

}
