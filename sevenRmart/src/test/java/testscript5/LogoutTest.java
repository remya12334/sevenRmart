package testscript5;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utility.Excelutility;

public class LogoutTest extends Base {
@Test
	public void validateadminisabletologout() throws IOException
	{
		String username=Excelutility.getStringData(1,0,"LOGINPAGE");
		String password=Excelutility.getStringData(1,1,"LOGINPAGE");
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterUsername(username);
	    loginPage.enterPassword(password);
	    loginPage.clickSignin();
		LogoutPage logout=new LogoutPage(driver);
		logout.clickadminButton();
		logout.clicklogoutbutton();
		Boolean signup=logout.isSigninpageDisplayed();
		Assert.assertTrue(signup);
	}
}
