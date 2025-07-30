package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath="//input[@type='text']")WebElement username;
	@FindBy(xpath="//input[@type='password']")WebElement password;
	@FindBy(xpath="//button[@type='submit']")WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
    @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement redalert;
    public WebDriver driver;
    public LoginPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    }
    public void enterUsername(String username2)
    {
    	username.sendKeys(username2);
    	
    }
    public void enterPassword(String password2)
    {
    	password.sendKeys(password2);
    }
    public void clickSignin() 
    {
    	signin.click();
    }
    public boolean isDashboardDisplayed()
    {
    	return dashboard.isDisplayed();
    }
    public boolean isAlertDisplayed()
    {
    	return redalert.isDisplayed();
    }
}
