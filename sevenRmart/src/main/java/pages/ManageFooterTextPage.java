package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']") WebElement moreinfo;
@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")WebElement action;
@FindBy(xpath="//textarea[@id='content']")WebElement address;
@FindBy(xpath="//input[@id='email']")WebElement email;
@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")WebElement update;
@FindBy(xpath="//i[@class='icon fas fa-check']")WebElement alert;
public WebDriver driver;
public ManageFooterTextPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
public void moreInfo()
{
	moreinfo.click();
}
public void action()
{
	action.click();
}
public void address(String newadd)
{
	address.clear();
	address.sendKeys(newadd);
	//address.click();
}
public void email(String newmail)
{
	email.clear();
	email.sendKeys(newmail);
	//email.click();
}
public boolean isupdatebuttonDisplayed()
{
	return update.isDisplayed();
}
public void update()
{
	update.click();
}

public boolean isalertDisplayed()
{
	return alert.isDisplayed();
}

}
