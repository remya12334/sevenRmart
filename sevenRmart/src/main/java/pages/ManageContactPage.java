package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ManageContactPage {
@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-contact']")WebElement moreinfo ;
@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")WebElement actions;
@FindBy(xpath="//input[@id='email' ]")WebElement email;
@FindBy(xpath="//input[@id='phone' ]")WebElement phone;
@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")WebElement update;
@FindBy(xpath="//i[@class='icon fas fa-check']")WebElement greenalert;
public WebDriver driver;
public ManageContactPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
public void clickmoreInfo()
{
	moreinfo.click();
}
public void clickActions()
{
	actions.click();
}
public void updateEmail(String mailid)
{
	email.clear();
	email.sendKeys(mailid);
}

public void updateDetails()
{
	/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.elementToBeClickable(update));
	update.click();*/
	JavascriptExecutor js = (JavascriptExecutor) driver;

    // Scroll the element into view (optional but recommended)
   // js.executeScript("arguments[0].scrollIntoView({block: 'center'});", update);

    // Use JS to click the element directly
    js.executeScript("arguments[0].click();", update);
}
public boolean isgreenalertDisplayed()
{
	return greenalert.isDisplayed();
}
}
