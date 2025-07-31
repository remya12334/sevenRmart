package testscript5;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Messages;
import pages.LoginPage;
import pages.LogoutPage;
import utility.Excelutility;

public class LogoutTest extends Base {
@Test(description="validate admin is able to logout")
	public void validateadminisAbleToLogout() throws IOException
	{
		String username=Excelutility.getStringData(1,0,"LOGINPAGE");
		String password=Excelutility.getStringData(1,1,"LOGINPAGE");
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterUsername(username);
	    loginPage.enterPassword(password);
	    loginPage.clickSignin();
		LogoutPage logout=new LogoutPage(driver);
		logout.clickAdminButton();
		logout.clickLogoutButton();
		Boolean signup=logout.isSigninpageDisplayed();
		Assert.assertTrue(signup,Messages.ADMINLOGOUT);
	}
}
