package stepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginLoadingPage;
import pageObjects.LoginPage;
import resources.BaseClass;

public class LoginStepDefination extends BaseClass {

	@Given("^Initialize the Chrome browser$")
	public void initialize_the_Chrome_browser() throws Throwable {
	   
		driver=InitializeDriver();
			
	}

	@Given("^Navigate to \"([^\"]*)\"$")
	public void navigate_to(String arg1) throws Throwable {
		driver.get(arg1);
 	}

	@Given("^Click on login link in home page$")
	public void click_on_login_link_in_home_page() throws Throwable {
		LoginLoadingPage l=new LoginLoadingPage(driver);
		l.SignIn().click();
    
	}

    @When("^user enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
        LoginPage login=new LoginPage(driver);
		login.email().sendKeys(username);
		login.password().sendKeys(password);
		login.submit().click();

 	}

	@Then("^verify if the user is successfully logged in$")
	public void verify_if_the_user_is_successfully_logged_in() throws Throwable {
		HomePage hp=new HomePage(driver);
		Assert.assertTrue(hp.SearchBox().isDisplayed());
		
	}
	 @And("^Close the browser$")
	    public void close_the_browser() throws Throwable {
		 driver.close();
		 driver=null;
	         }


}
