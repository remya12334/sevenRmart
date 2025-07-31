package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement adminbutton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")WebElement logoutbutton;
	@FindBy(xpath="//button[@type='submit']")WebElement signin;
	public WebDriver driver;
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
public void clickAdminButton()
{
	adminbutton.click();
}
public void clickLogoutButton()
{
	logoutbutton.click();
}
public boolean isSigninpageDisplayed()
{
	return signin.isDisplayed();
}
}
