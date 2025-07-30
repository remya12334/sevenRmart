package testscript5;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utility.Excelutility;


public class ManageNewsTest extends Base {
	@Test
	public void manageNewsEntry() throws IOException {
	    
        String username = Excelutility.getStringData(1,0,"LOGINPAGE");
        String password = Excelutility.getStringData(1,1,"LOGINPAGE");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSignin();
        //Assert.assertTrue(loginPage.isDashboardDisplayed());     
        ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
        manageNewsPage.clickManageNewsLink();
        Assert.assertTrue(manageNewsPage.isManageNewsPageVisible());
        manageNewsPage.clickNewButton();
        String newsContent = Excelutility.getStringData(0,0,"news");
        manageNewsPage.enterNewsText(newsContent);
        manageNewsPage.clickSaveButton();
        Assert.assertTrue(manageNewsPage.isSuccessAlertDisplayed());
    }

}
