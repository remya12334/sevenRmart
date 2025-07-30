package testscript5;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextPage;
import utility.Excelutility;


	public class ManageFooterTextTest extends Base
	{
		@Test
		public void validateuserisabletomanageFooterText() throws IOException
		{
			String username=Excelutility.getStringData(1,0,"LOGINPAGE");
			String password=Excelutility.getStringData(1,1,"LOGINPAGE");
			LoginPage loginPage = new LoginPage(driver);
		    loginPage.enterUsername(username);
		    loginPage.enterPassword(password);
		    loginPage.clickSignin();
		    
		    ManageFooterTextPage managefooter=new ManageFooterTextPage(driver);
		    managefooter.moreinfo();
		    managefooter.action();
		    String newaddress=Excelutility.getStringData(1,0,"managefooter");
		    //String email=Excelutility.getStringData(1,1,"managefooter");
		    managefooter.address(newaddress);
		    String newemail=Excelutility.getStringData(1,1,"managefooter");
		    managefooter.email(newemail);
		    managefooter.update();
		    Boolean alertdisplayed=managefooter.isalertDisplayed();
		    Assert.assertTrue(alertdisplayed);
		}
		@Test
		public void validateupdatebuttonisDisplayed() throws IOException
		{
			String username=Excelutility.getStringData(1,0,"LOGINPAGE");
			String password=Excelutility.getStringData(1,1,"LOGINPAGE");
			LoginPage loginPage = new LoginPage(driver);
		    loginPage.enterUsername(username);
		    loginPage.enterPassword(password);
		    loginPage.clickSignin();
		    
			ManageFooterTextPage managefooter=new ManageFooterTextPage(driver);
	         managefooter.moreinfo();
	           managefooter.action();
			    Boolean buttondisplayed=managefooter.isupdatebuttonDisplayed();
			    Assert.assertTrue(buttondisplayed);
		}
		
	
	}


