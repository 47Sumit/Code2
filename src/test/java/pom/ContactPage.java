package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage {
	
	
	@FindBy(name="firstname")
	private WebElement firstnametf;

	
	@FindBy(name="lastname")
	private WebElement Lastnametf;
	

	public WebElement getFirstnametf() {
		return firstnametf;
	}
	
	
	public WebElement getLastnametf() {
		return Lastnametf;
	}
	
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement ContactAssigntobtn;

	
	public WebElement getContactAssigntobtn() {
		return ContactAssigntobtn;
	}
	
	@FindBy(name="assigned_group_id")
    private WebElement Contactdropdown ;

	
	public WebElement getContactdropdown() {
		return Contactdropdown;
	}
	//For Save Button
	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement ContactSavebtn ;

	
	public WebElement getContactSavebtn() {
		return ContactSavebtn;
	}
	
	@FindBy(xpath="(//img[@style='padding: 0px;padding-left:5px'])[1]")
	private WebElement ContactImagebtn  ;

	
	public WebElement getContactImagebtn() {
		return ContactImagebtn;
	}
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement ContactSignoutbtn  ;

	
	public WebElement getContactSignoutbtn() {
		return ContactSignoutbtn;
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement ContactPlusbtn;


	public WebElement getContactPlusbtn() {
		return ContactPlusbtn;
	}
	
	@FindBy(id="search_txt")
	private WebElement ContactSearchtf;
	
	
	public WebElement getContactSearchtf() {
		return ContactSearchtf;
	}
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement Searchbtn;


	public WebElement getSearchbtn() {
		return Searchbtn;
	}
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement Contacttext;


	public WebElement getContacttext() {
		return Contacttext;
	}

}
