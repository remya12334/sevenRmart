package testscript5;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import constant.Constant;
import constant.Messages;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utility.Excelutility;

public class ManageCategoryTest extends Base {
	@Test(description = "validate admin is able to update category and upload image file")
	public void validatewhetheruserisabletoUpdateCategoryandUploadImage() throws IOException, AWTException {
		String username = Excelutility.getStringData(1, 0, "LOGINPAGE");
		String password = Excelutility.getStringData(1, 1, "LOGINPAGE");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickSignin();
		ManageCategoryPage managecategory = new ManageCategoryPage(driver);
		managecategory.moreInfo();
		managecategory.newButton();
		String category = Excelutility.getStringData(1, 0, "managecategory");
		managecategory.enterCategory(category);
		// String imagePath = "C:\\Users\\user\\Desktop\\SELENIUM\\dragonfruit.jpg";
		managecategory.uploadImageUsingSendKeys(Constant.IMAGEFILE);
		Boolean imagedisplayed = managecategory.isimagePreviewDisplayed();
		Assert.assertTrue(imagedisplayed, Messages.IMAGEUPLOAD);
	}
}
