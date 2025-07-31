package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.FileUploadUtility;


public class ManageCategoryPage {
@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-category']")WebElement moreinfo;
@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
@FindBy(xpath="//input[@id='category']")WebElement category;
@FindBy(xpath="//input[@id='main_img']")WebElement choosefile;
@FindBy(xpath="//div[@id='imagePreview']")WebElement imagepreview;
//public WebElement choosefile;
public WebDriver driver;
FileUploadUtility fileUpload;
public ManageCategoryPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	 fileUpload = new FileUploadUtility();
}
	public void moreInfo()
	{
		moreinfo.click();
	}
	public void newButton()
	{
		newbutton.click();
		
	}
	public void enterCategory(String category1)
	{
		category.sendKeys(category1);
	}
	/*public void imageupload()
	{
		choosefile.click();
	}
	*/
	 // Upload image using sendKeys only
    public void uploadImageUsingSendKeys(String imagePath) {
        fileUpload.fileuploadusingSendKeys(choosefile, imagePath);
    }
    public boolean isimagePreviewDisplayed()
	{
		return imagepreview.isDisplayed();
	}

}
