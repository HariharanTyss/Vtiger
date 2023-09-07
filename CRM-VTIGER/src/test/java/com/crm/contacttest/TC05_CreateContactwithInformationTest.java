package com.crm.contacttest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.comcast.Basetest.BaseClass;
import com.crm.generic.ObjectRepository.ContactInformationPage;
import com.crm.generic.ObjectRepository.ContactPage;
import com.crm.generic.ObjectRepository.HomePage;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.listenerimplements.ListenerImplementation;
 //@Listeners(com.crm.generic.listenerimplements.ListenerImplementation.class)
public class TC05_CreateContactwithInformationTest  extends BaseClass
{
	@Test(groups = "smoke")
	public void createContactwithInformation() throws Throwable 
	{
		wdu.waitForPageToLoad(driver);
		//click on Contact Link in home page
		HomePage homepg=new HomePage(driver);
		homepg.getcontactlink().click();
		//ListenerImplementation.test.log(Status.PASS, "Clicked Contact link in Header");

		//Click on Create Contaact Logo in Contact page
		ContactPage contactpg=new ContactPage(driver);
		contactpg.getCreatecontactlogo().click();
		//ListenerImplementation.test.log(Status.PASS, "Clicked Create Contactlogo link in Header");

		//Enter the Conatct name in last Name Textfield
		ExcelUtility excel=new ExcelUtility();
		String name = excel.getDataFromExcelFile("contact", 1, 3);

		//concat with Random number
		int randomno=jau.getrandomnumber();
		String contactname = name+randomno;

		//Enter  the Contact Name in Text field 
		ContactInformationPage contactInfoPg=new ContactInformationPage(driver);
		
		contactInfoPg.getlastnameTF().sendKeys(contactname);
		//ListenerImplementation.test.log(Status.PASS, "Entered Contact lastname ");

		//enter Start Date
		contactInfoPg.getstart_dateTF().sendKeys(jau.getSystemData());
		//ListenerImplementation.test.log(Status.PASS, "Entered Stardate ");

		//Enterr End Date
		contactInfoPg.getend_dateTF().sendKeys(jau.getReqDate(30));
		//ListenerImplementation.test.log(Status.PASS, "Entered ENdDate ");

		//click on Save Button
		contactInfoPg.getsaveButton().click();


		//verify the Contact Name is take or not

		String namee = contactInfoPg.getcontactname().getText();
		if(name.contains(contactname)) 
		{
			//verfify  Contact Name
			System.out.println(contactname+" is Created !! ");
		}
		else {
			System.out.println(contactname+" is Not created !!");
		}
		System.out.println("<<<Create ContactwithInformation Completed>>>");
	}
}
