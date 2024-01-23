package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {
	
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement Oraganization;

	public WebElement getOraganization() {
		return Oraganization;
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement Oragnazationlink;

	public WebElement getOragnazationlink() {
		return Oragnazationlink;
	}
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
