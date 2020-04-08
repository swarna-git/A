package E2E_Framework;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HeaderPage;
import pageObjects.LoginLoadingPage;
import pageObjects.LoginPage;
import resources.BaseClass;

public class LoginTest extends BaseClass {

	@BeforeTest
	public void initialize() throws IOException
	{
		driver=InitializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test(dataProvider="getData") 
	public void login(String username,String password) throws IOException
	{
	LoginLoadingPage l=new LoginLoadingPage(driver);
	System.out.println("i made chnages in A sub folder");
	l.SignIn().click();
	LoginPage login=new LoginPage(driver);
	login.email().sendKeys(username);
	login.password().sendKeys(password);
	login.submit().click();
		}
	
	
	@DataProvider()
	public Object[][] getData()
	{
	Object[][] ob=new Object[1][2];
	ob[0][0]="swarnam98@gmail.com";
	ob[0][1]="swarna*56";
	return ob;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
}
