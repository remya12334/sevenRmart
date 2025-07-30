package testscript5;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminusersPage;
import pages.LoginPage;
import utility.Excelutility;
import utility.Fakerutility;

	public class AdminusersTest extends Base{

		@Test(retryAnalyzer =retry.Retry.class)
			public void validateuserisabletoaddAdmin() throws IOException
			{
			String username=Excelutility.getStringData(1,0,"LOGINPAGE");
			String password=Excelutility.getStringData(1,1,"LOGINPAGE");
			LoginPage loginPage = new LoginPage(driver);
		    loginPage.enterUsername(username);
		    loginPage.enterPassword(password);
		    loginPage.clickSignin();
			
		    AdminusersPage adminuserspage=new AdminusersPage(driver);
		   adminuserspage.adminusersmoreinfo();
		   adminuserspage.adminuserAddNew();
		    //String username1=Excelutility.getStringData(1,0,"AdminAdd");
		    //String password1=Excelutility.getStringData(1,1,"AdminAdd");
		    Fakerutility fakerutility=new Fakerutility();
			String username1=fakerutility.creatARandomFirstName();
			String password1=fakerutility.creatARandomLastName();// 
		    adminuserspage.enterUsername(username1);
		    adminuserspage.enterPassword(password1);
		    adminuserspage.dropdownSelect();
		    adminuserspage.saveAdmin();
		    Boolean alertdisplayed=adminuserspage.isgreenalertDisplayed();
		    Assert.assertTrue(alertdisplayed);
		    
			}
		    

}
