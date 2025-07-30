package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.PageUtility;

public class AdminusersUpdatePage {
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement moreinfo;
	 @FindBy(xpath="//a[contains(@class, 'btn-primary') and contains(@href,'/admin/user/edit')]")WebElement update;
@FindBy(xpath="//input[@id='username']")WebElement username;
@FindBy(xpath="//input[@id='password']")WebElement password;
@FindBy(xpath="//select[@id='user_type']")WebElement usertype;
@FindBy(xpath="//button[@name='Update']")WebElement updateadmin;
@FindBy(xpath="//i[contains(@class,'fa-check')]")WebElement alert;
public WebDriver driver;
public AdminusersUpdatePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
public void moreinfo()
{
	moreinfo.click();
}
public void updateadminusers() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(update));
    update.click();
}
public void updateusername(String username1)
{
	username.clear();
	username.sendKeys(username1);
}
public void updatepassword(String password1)
{
	password.clear();
	password.sendKeys(password1);
}
public void selectadmintype()
{
	PageUtility page=new PageUtility();
	page.selectByIndex(usertype,3);
	updateadmin.click();
}
public boolean isalertDisplayed() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(alert));
    return alert.isDisplayed();
}
public boolean isupdatebuttonDisplayed()
{
	return updateadmin.isDisplayed();
}
}