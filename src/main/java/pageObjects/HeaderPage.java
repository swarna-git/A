package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {

	WebDriver driver;
		@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']")
		WebElement Header;
		
		public HeaderPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}

		public WebElement getHeader()
		{
			return Header;
		}
	}

