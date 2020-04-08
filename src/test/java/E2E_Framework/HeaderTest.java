package E2E_Framework;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HeaderPage;
import resources.BaseClass;

public class HeaderTest extends BaseClass {
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=InitializeDriver();
		driver.get(prop.getProperty("url"));
			
	}

	@Test(enabled=false)
	public void getHeader()
	{			
		HeaderPage header=new HeaderPage(driver);
		System.out.println(header.getHeader().getText());
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}

	
}
