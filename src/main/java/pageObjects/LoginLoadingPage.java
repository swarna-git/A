package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginLoadingPage

{
	WebDriver driver;

		public LoginLoadingPage(WebDriver driver)
		{
			this.driver=driver;
		}
	
	By Sign_in=By.cssSelector("a[href*='sign_in']");
	By Popup=By.xpath("//button[text(),'NO THANKS']");
	
	public WebElement SignIn()
	{
		return driver.findElement(Sign_in);
	}
	public WebElement Popup() 
	{
	 return driver.findElement(Popup);	
	}
	public int Popupsize()
	{
		return driver.findElements(Popup).size();
	}
}
