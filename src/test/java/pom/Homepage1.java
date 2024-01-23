package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage1 {
	@FindBy(xpath="(//a[text()='Contacts'])[1]")
	private WebElement Contacts;

	public WebElement getContact() {
		return Contacts;
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement Createcontactbtn;

	public WebElement getContactlink() {
		return Createcontactbtn;
	}

}
