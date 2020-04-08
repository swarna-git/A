package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	/*@FindBy(id="username")
	WebElement Email;
	
	@FindBy(id="password")
	WebElement Password;
	*/
	By email=By.id("user_email");
	By pwd=By.id("user_password");
	By submit=By.cssSelector("input[type='submit']");
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	public WebElement email()
	{
		return driver.findElement(email);
	}
	
	public WebElement password()
	{
		return driver.findElement(pwd);
	}
	public WebElement submit()
	{
		return driver.findElement(submit);
	}
	
}
