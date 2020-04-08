package E2E_Framework;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import pageObjects.LoginLoadingPage;
import pageObjects.LoginPage;
import pageObjects.SignOutPage;
import resources.BaseClass;

public class SignOutTest extends BaseClass{

	
		// TODO Auto-generated constructor stub
		
		@BeforeTest
		public void initialize() throws IOException
		{
			driver=InitializeDriver();
			driver.get(prop.getProperty("url"));	
		}

		@Parameters({"username","password"})
		@Test
		public void signout(String username,String password)
		
		{
				LoginLoadingPage l=new LoginLoadingPage(driver);
			l.SignIn().click();
			LoginPage login=new LoginPage(driver);
			login.email().sendKeys(username);
			login.password().sendKeys(password);
			login.submit().click();
			SignOutPage signout=new SignOutPage(driver);
			signout.signout().click();
					
		}
		
		@AfterTest
		public void teardown()
		{
			driver.close();
			driver=null;
		}


	
}
