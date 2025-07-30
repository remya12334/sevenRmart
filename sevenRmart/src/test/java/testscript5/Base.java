package testscript5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class Base {
	public WebDriver driver;
@BeforeMethod(alwaysRun=true)	
@Parameters("browser")
public void browserInitialization(String browser) throws Exception
{
	if(browser.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else
	{
		throw new Exception("invalid");
	}
	//driver=new ChromeDriver();
	driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	driver.manage().window().maximize();
	
}
@AfterMethod(alwaysRun=true)
	public void driverQuit()
	{
		//driver.close();
		driver.quit();
	}

}
