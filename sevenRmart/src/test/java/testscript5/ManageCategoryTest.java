package testscript5;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utility.Excelutility;



public class ManageCategoryTest extends Base{
@Test
	public void validatewhetheruserisabletoupdatecategoryanduploadImage() throws IOException, AWTException
	{
		String username=Excelutility.getStringData(1,0,"LOGINPAGE");
		String password=Excelutility.getStringData(1,1,"LOGINPAGE");
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterUsername(username);
	    loginPage.enterPassword(password);
	    loginPage.clickSignin();
	    
		ManageCategoryPage managecategory=new ManageCategoryPage(driver);
		managecategory.moreinfo();
		managecategory.newbutton();
		String category=Excelutility.getStringData(1,0,"managecategory");
		managecategory.entercategory(category);
		String imagePath = "C:\\Users\\user\\Desktop\\SELENIUM\\dragonfruit.jpg";
        managecategory.uploadImageUsingSendKeys(imagePath);
        Boolean imagedisplayed=managecategory.isimagepreviewDisplayed();
	    Assert.assertTrue(imagedisplayed);
	}
}
