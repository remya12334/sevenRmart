package testscript5;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Messages;
import pages.AdminusersUpdatePage;
import pages.LoginPage;
import utility.Excelutility;

public class AdminusersUpdateTest extends Base {
	@Test(description = "validate whether user is able to update admin")
	public void validateadminusersisabletoUpdate() throws IOException {
		String username = Excelutility.getStringData(1, 0, "LOGINPAGE");
		String password = Excelutility.getStringData(1, 1, "LOGINPAGE");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		Boolean isHomepageDisplayed = loginpage.isDashboardDisplayed();
		Assert.assertTrue(isHomepageDisplayed, Messages.LOGINVALIDCREDENTIALS);

		AdminusersUpdatePage adminupdate = new AdminusersUpdatePage(driver);
		adminupdate.moreInfo();
		adminupdate.updateAdminUsers();
		String username1 = Excelutility.getStringData(1, 0, "adminupdate");
		adminupdate.updateUsername(username1);
		String password1 = Excelutility.getStringData(1, 1, "adminupdate");
		adminupdate.updatePassword(password1);
		adminupdate.selectAdminType();
		Boolean alertdisplayed = adminupdate.isalertDisplayed();
		Assert.assertTrue(alertdisplayed, Messages.ADMINUSERUPDATION);
	}

	@Test(description = "validate whether the admin update button is visible")
	public void validateadminusersupdatebuttonisVisible() throws IOException {
		String username = Excelutility.getStringData(1, 0, "LOGINPAGE");
		String password = Excelutility.getStringData(1, 1, "LOGINPAGE");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickSignin();
		AdminusersUpdatePage adminupdate = new AdminusersUpdatePage(driver);
		adminupdate.moreInfo();
		adminupdate.updateAdminUsers();
		String username1 = Excelutility.getStringData(1, 0, "adminupdate");
		adminupdate.updateUsername(username1);
		String password1 = Excelutility.getStringData(1, 1, "adminupdate");
		adminupdate.updatePassword(password1);
		// adminupdate.selectadmintype();
		Boolean buttondisplayed = adminupdate.isupdatebuttonDisplayed();
		Assert.assertTrue(buttondisplayed,Messages.ADMINUSERUPDATEBUTTON);
	}

}
