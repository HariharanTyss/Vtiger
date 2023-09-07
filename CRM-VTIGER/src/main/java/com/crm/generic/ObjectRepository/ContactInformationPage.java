package com.crm.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage 
{
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}



	@FindBy(xpath  = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement linkogrlogo;

	@FindBy(name = "lastname")
	private WebElement lastnameTF;

	@FindBy(id = "phone")
	private WebElement phonenumberTF;

	@FindBy(name = "button")
	private WebElement saveButton;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactname;
	
	@FindBy(id = "jscal_field_support_end_date")
	private WebElement end_dateTF;
	
	@FindBy(id = "jscal_field_support_start_date")
	private WebElement start_dateTF;

	public WebElement getend_dateTF() {
		return end_dateTF;
	}
	
	public WebElement getstart_dateTF() {
		return start_dateTF;
	}
	public WebElement getphonenumberTF() {
		return phonenumberTF;
	}
	
	public WebElement getcontactname() {
		return contactname;
	}
	public WebElement getlastnameTF() {
		return lastnameTF;
	}
	public WebElement getsaveButton() {
		return saveButton;
	}
	public WebElement getlinkogrlogo() {
		return linkogrlogo;
	}

	
}
