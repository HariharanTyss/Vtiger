package com.crm.orgtest;

import org.testng.annotations.Test;

import com.crm.comcast.Basetest.BaseClass;
import com.crm.generic.ObjectRepository.HomePage;
import com.crm.generic.ObjectRepository.OrganisationPage;
import com.crm.generic.ObjectRepository.OrganizationInformationPage;

public class CreateOrganisationTest extends BaseClass
{
	@Test
	public void createOrganisationSimple() throws Throwable {

		wdu.waitForPageToLoad(driver);
		String accname = exu.getDataFromExcelFile("Organisation", 1, 3);
		int randomno=jau.getrandomnumber();
		String accountname = accname+randomno;

		//String accountname = "Qsp1875";

		//Entering into Homepage
		HomePage homepg=new HomePage(driver);

		//click on Organisation Link
		homepg.getorganizationslink().click();

		//click on Create NewOrganisation Logo
		OrganisationPage orgpg= new OrganisationPage(driver);
		orgpg.getCreateOrganizationlogo().click();

		//Enter the Organisation Name
		OrganizationInformationPage orginfopg=new OrganizationInformationPage(driver);

		//Enter the Organisation Name
		orginfopg.getaccountnameTF().sendKeys(accountname);


		//click on Save Button
		orginfopg.getsaveButton().click();

		//verify the organisation Name is take or not
		try {
			boolean orgname = orginfopg.getorganisationname().isDisplayed();
			if(orgname) {
				//verfify  organisation Name
				System.out.println("<<< "+accountname+" Organisation is Created >>>");
			}
		}
		catch (Exception e) {
			driver.switchTo().alert().accept();
			System.out.println("Organisation Not created/Organization Name Already Exists!");
		}
	}
	@Test
	public void createOrgwithIndustry() throws Throwable 
	{
		wdu.waitForPageToLoad(driver);
		String accname = exu.getDataFromExcelFile("Organisation", 1, 3);
		String industry_option = exu.getDataFromExcelFile("Organisation", 1, 5);
		String account_option = exu.getDataFromExcelFile("Organisation", 1, 6);
		
		int randomno=jau.getrandomnumber();
		String accountname = accname+randomno;

		//Entering into Homepage
		HomePage homepg=new HomePage(driver);

		//click on Organisation Link
		homepg.getorganizationslink().click();

		//click on Create NewOrganisation Logo
		OrganisationPage orgpg= new OrganisationPage(driver);
		orgpg.getCreateOrganizationlogo().click();

		//Enter the Organisation Name
		OrganizationInformationPage orginfopg=new OrganizationInformationPage(driver);

		//Enter the Organisation Name
		orginfopg.getaccountnameTF().sendKeys(accountname);

		//select third Option in Acount Type Dropdown

		wdu.selectDropdown( driver,orginfopg.getactypedropdown(), 3);

		//Select Energy Option in industry Type Dropdown
		wdu.selectDropdown(driver,orginfopg.getindustrydropdown(), "Energy");

		//click on Save Button
		orginfopg.getsaveButton().click();
		
		//verify the organisation Name is take or not
		try {
			boolean orgname = orginfopg.getorganisationname().isDisplayed();
			if(orgname) {
				//verfify  organisation Name
				System.out.println("<<< "+accountname+" Organisation is Created >>>");
			}
		}
		catch (Exception e) {
			driver.switchTo().alert().accept();
			System.out.println("Organisation Not created/Organization Name Already Exists!");
		}

	}
	@Test
	public void createOrgUsingPhonno() throws Throwable {
		wdu.waitForPageToLoad(driver);
		String accname = exu.getDataFromExcelFile("Organisation", 1, 3);
		String phoneno = exu.getDataFromExcelFile("Organisation", 1, 4);
		int randomno=jau.getrandomnumber();
		String accountname = accname+randomno;
		//String accountname = "Qsp1875";

		//Entering into Homepage
		HomePage homepg=new HomePage(driver);

		//click on Organisation Link
		homepg.getorganizationslink().click();

		//click on Create NewOrganisation Logo
		OrganisationPage orgpg= new OrganisationPage(driver);
		orgpg.getCreateOrganizationlogo().click();

		//Enter the Organisation Name
		OrganizationInformationPage orginfopg=new OrganizationInformationPage(driver);

		//Enter the Organisation Name
		orginfopg.getaccountnameTF().sendKeys(accountname);

		//Enter the Phone Number 

		orginfopg.getphonenumberTF().sendKeys(phoneno);


		//click on Save Button
		orginfopg.getsaveButton().click();

		//verify the organisation Name is take or not
		try {
			boolean orgname = orginfopg.getorganisationname().isDisplayed();
			if(orgname) {
				//verfify  organisation Name
				System.out.println("<<< "+accountname+" Organisation is Created >>>");
			}
		}
		catch (Exception e) {
			driver.switchTo().alert().accept();
			System.out.println("Organisation Not created/Organization Name Already Exists!");

		}

	}

}
