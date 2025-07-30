package testscript5;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminusersUpdatePage;
import pages.LoginPage;
import utility.Excelutility;

public class AdminusersUpdateTest extends Base
{
	@Test
	public void validateadminusersisabletoUpdate() throws IOException
	{
	String username=Excelutility.getStringData(1,0,"LOGINPAGE");
	String password=Excelutility.getStringData(1,1,"LOGINPAGE");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsername(username);
	loginpage.enterPassword(password);
	loginpage.clickSignin();
	boolean isHomepageDisplayed=loginpage.isDashboardDisplayed();
	Assert.assertTrue(isHomepageDisplayed);	
	AdminusersUpdatePage adminupdate=new AdminusersUpdatePage(driver);
	adminupdate.moreinfo();
	adminupdate.updateadminusers();
	String username1=Excelutility.getStringData(1,0,"adminupdate");
	adminupdate.updateusername(username1);
	String password1=Excelutility.getStringData(1,1,"adminupdate");
	adminupdate.updatepassword(password1);
	adminupdate.selectadmintype();
	Boolean alertdisplayed=adminupdate.isalertDisplayed();
    Assert.assertTrue(alertdisplayed);
	}
	@Test
	public void validateadminusersupdatebuttonisVisible() throws IOException
	{
		String username=Excelutility.getStringData(1,0,"LOGINPAGE");
		String password=Excelutility.getStringData(1,1,"LOGINPAGE");
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterUsername(username);
	    loginPage.enterPassword(password);
	    loginPage.clickSignin();
	    
	    AdminusersUpdatePage adminupdate=new AdminusersUpdatePage(driver);
	    adminupdate.moreinfo();
	    adminupdate.updateadminusers();
	    String username1=Excelutility.getStringData(1,0,"adminupdate");
		adminupdate.updateusername(username1);
		String password1=Excelutility.getStringData(1,1,"adminupdate");
		adminupdate.updatepassword(password1);
		//adminupdate.selectadmintype();
		    Boolean buttondisplayed=adminupdate.isupdatebuttonDisplayed();
		    Assert.assertTrue(buttondisplayed);
	}

}
