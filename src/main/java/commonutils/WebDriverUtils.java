package commonutils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtils {

	public void maximize(WebDriver driver) {
		
		driver.manage().window().maximize();
		
	}
	
    public void minimize(WebDriver driver) {
		
    	driver.manage().window().minimize();
	}
    
    public void implicitwait(WebDriver driver) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    public void handledropdown(WebElement elementname,String Data){
    	Select s = new Select(elementname);
		s.selectByVisibleText(Data);
    	
    }
    
    public void handledropdown(WebElement elementname,int indexnumber) {
    	Select s = new Select(elementname);
    	s.selectByIndex(indexnumber);
    }
    
    public void action(WebDriver driver,WebElement elementname) {
    	Actions a = new Actions(driver);
    	a.click(elementname);
    	a.perform();
    }
    //To mouseover the element
    public void mouseover(WebDriver driver,WebElement elementname) {
    	Actions a = new Actions(driver);
    	a.moveToElement(elementname);
    	a.perform();
    }
    //TO double click the Element
    public void doubleclick(WebDriver driver,WebElement element) {
    	Actions a = new Actions(driver);
    	a.doubleClick(element);
    	a.perform();	
    }
    //To right click the element
    public void rightContextClick(WebDriver driver,WebElement elementname) {
    	Actions a = new Actions(driver);
    	a.contextClick(elementname);
    	a.perform();
    	
    }
    
    public void draganddropby(WebDriver driver,WebElement source,WebElement destination) {
    	Actions a = new Actions(driver);
    	a.dragAndDrop(source, destination);
    	a.perform();
    }
    
    //To take the Screenshot of the webpage
    public String screenshot(WebDriver driver,String Screenshotname) throws IOException {
    	LocalDateTime ldt = LocalDateTime.now();
    	String timestamp = ldt.toString().replace(':','-');
    	TakesScreenshot ts =(TakesScreenshot)driver;
		File tempfile = ts.getScreenshotAs(OutputType.FILE);
		File destinationfile = new File("./images/"+Screenshotname+timestamp+".jpg");
		FileUtils.copyFile(tempfile, destinationfile);
		return destinationfile.getAbsolutePath();
    }
    //To Scroll the Page
    public void scrolling(WebDriver driver) {
    	JavascriptExecutor jse =(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,900)");
    }
    
    //To transfer the control from child
    public void switchwindow(WebDriver driver,String childurl) {
    	Set<String> ids= driver.getWindowHandles();
		System.out.println(ids);
		
		for (String allids : ids) {
			//System.out.println(allids);
			String allurl = driver.switchTo().window(allids).getCurrentUrl();
			System.out.println(allurl);
			
			if (allurl.contains(childurl)) {
				break;
				
			}
				
			}
		
		}
    public void okpopup(WebDriver driver) {
    	driver.switchTo().alert().accept();
    }
    public void cancelpopup(WebDriver driver) {
    	driver.switchTo().alert().dismiss();
    }
    public void textpopup(WebDriver driver) {
    	driver.switchTo().alert().getText();
    }
    public void valuepopup(WebDriver driver,String text) {
    	driver.switchTo().alert().sendKeys(text);
    }
    public void frames (WebDriver driver,int index) {
    	driver.switchTo().frame(index);
    }
    public void frames(WebDriver driver,String name) {
    	driver.switchTo().frame(name);
    } 
    
    public void frames (WebDriver driver,WebElement element) {
    	driver.switchTo().frame(element);
    }
    
    
    
}
    

    
   

