package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignOutPage {
	WebDriver driver;
	
	By signout=By.xpath("//img[@class='gravatar']");
		
	public SignOutPage(WebDriver driver) {
	this.driver=driver;	
	}

	
	public WebElement signout()
	{
		return driver.findElement(signout);
	}
	
}
