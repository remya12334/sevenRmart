package testscript5;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utility.Excelutility;
@Test
public class LoginTest extends Base{
	@Test(groups= {"regression"})
	
	public void validateuserisabletologinwithvalidCredentials() throws IOException
	{   
		String username=Excelutility.getStringData(1,0,"LOGINPAGE");
		String password=Excelutility.getStringData(1,1,"LOGINPAGE");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		boolean isHomepageDisplayed=loginpage.isDashboardDisplayed();
		Assert.assertTrue(isHomepageDisplayed);	
	}
	@Test
	public void validateuserisabletologinwithInvalidUsername() throws IOException
	{
		String username=Excelutility.getStringData(2,0,"LOGINPAGE");
		String password=Excelutility.getStringData(2,1,"LOGINPAGE");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		Boolean isLoginFailed=loginpage.isAlertDisplayed();
		Assert.assertTrue(isLoginFailed);
	}
	@Test
	public void verifyuserisabletologinwithInvalidPassword() throws IOException
	{
		String username=Excelutility.getStringData(3,0,"LOGINPAGE");
		String password=Excelutility.getStringData(3,1,"LOGINPAGE");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		Boolean isLoginFailed=loginpage.isAlertDisplayed();
		Assert.assertTrue(isLoginFailed);
		
		
	}
	@Test
	public void verifyuserisabletologinwithInvalidUsernameandInvalidPassword() throws IOException
	{
		String username=Excelutility.getStringData(4,0,"LOGINPAGE");
		String password=Excelutility.getStringData(4,1,"LOGINPAGE");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		Boolean isLoginFailed=loginpage.isAlertDisplayed();
		Assert.assertTrue(isLoginFailed);
	}
}
