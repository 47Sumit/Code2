package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Organizationinformationpage {
	
	@FindBy(name="accountname")
	private WebElement Organizationtf;

	public WebElement getOrganizationtf() {
		return Organizationtf;
	}
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement Assigntobtn ;

	public WebElement getAssigntobtn() {
		return Assigntobtn;
	}
	
	@FindBy(name="assigned_group_id")
    private WebElement Assigntodropdown ;

	public WebElement getAssigntodropdown() {
		return Assigntodropdown;
	}
	//For Save Button
	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement Savebtn ;

	public WebElement getSavebtn() {
		return Savebtn;
	}
	//For Mouseover to the imagebutton
	@FindBy(xpath="(//img[@style='padding: 0px;padding-left:5px'])[1]")
	private WebElement Imagebtn  ;

	public WebElement getImagebtn() {
		return Imagebtn;
	}
	//To Sign out the page
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement Signoutbtn  ;

	public WebElement getSignoutbtn() {
		return Signoutbtn;
	}
	
	

}

