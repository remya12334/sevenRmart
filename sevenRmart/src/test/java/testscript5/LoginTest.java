package testscript5;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Messages;
import pages.LoginPage;
import utility.Excelutility;

@Test
public class LoginTest extends Base {

	@Test(description = "validate user is able to login with valid credentials", groups = { "regression" })
	public void validateuserisabletoLoginwithValidCredentials() throws IOException {
		String username = Excelutility.getStringData(1, 0, "LOGINPAGE");
		String password = Excelutility.getStringData(1, 1, "LOGINPAGE");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		boolean isHomepageDisplayed = loginpage.isDashboardDisplayed();
		Assert.assertTrue(isHomepageDisplayed, Messages.LOGINVALIDCREDENTIALS);
	}

	@Test(description = "validate user is able to login with invalid username")
	public void validateuserisabletoLoginwithInvalidUsername() throws IOException {
		String username = Excelutility.getStringData(2, 0, "LOGINPAGE");
		String password = Excelutility.getStringData(2, 1, "LOGINPAGE");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		Boolean isLoginFailed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isLoginFailed, Messages.LOGINWITHINVALIDUSERNAME);
		// Assert.assertTrue(isLoginFailed,"User is able to login with invalid
		// credentials");
	}

	@Test(description = "validate user is able to login with invalid password")
	public void verifyuserisabletoLoginwithInvalidPassword() throws IOException {
		String username = Excelutility.getStringData(3, 0, "LOGINPAGE");
		String password = Excelutility.getStringData(3, 1, "LOGINPAGE");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		Boolean isLoginFailed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isLoginFailed, Messages.LOGINWITHIVALIDPASSWORD);

	}

	@Test(description = "validate user is able to login with invalid username and invalid password")
	public void verifyuserisabletoLoginwithInvalidUsernameandInvalidPassword() throws IOException {
		String username = Excelutility.getStringData(4, 0, "LOGINPAGE");
		String password = Excelutility.getStringData(4, 1, "LOGINPAGE");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		Boolean isLoginFailed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isLoginFailed, Messages.LOGINWITHINVALIDUSERNAMEPASSWORD);
	}
}
