package testscript5;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Messages;
import pages.LoginPage;
import pages.ManageContactPage;
import utility.Excelutility;

public class ManageContactTest extends Base {
	@Test(description="validate admin is able to update manage contact page")
	public void validateadminisabletoUpdateManageContact() throws IOException {
		String username = Excelutility.getStringData(1, 0, "LOGINPAGE");
		String password = Excelutility.getStringData(1, 1, "LOGINPAGE");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickSignin();
		ManageContactPage manage = new ManageContactPage(driver);
		manage.clickmoreInfo();
		manage.clickActions();
		String mailid = Excelutility.getStringData(1, 0, "managecontact");
		manage.updateEmail(mailid);
		manage.updateDetails();
		Boolean alert = manage.isgreenalertDisplayed();
		Assert.assertTrue(alert,Messages.MANAGECONTACT);

	}

}
