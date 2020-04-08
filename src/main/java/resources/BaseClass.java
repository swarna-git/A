package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseClass {
	public  WebDriver driver;
	public Properties prop;

	public WebDriver InitializeDriver() throws IOException
	{
		
	    prop=new Properties();
		FileInputStream f=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\config.properties");
		prop.load(f);
		String browser=prop.getProperty("browserName");
		if(browser.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sunde\\ZPractice\\src\\main\\java\\utilities\\chromedriver2.exe");
			ChromeOptions op=new ChromeOptions();
			if(browser.contains("headless"))
				op.addArguments("--headless");
			driver=new ChromeDriver(op);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sunde\\ZPractice\\src\\main\\java\\utilities\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();

		}
		else
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\sunde\\ZPractice\\src\\main\\java\\utilities\\MicrosoftWebDriver.exe");
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenShot(String result) throws IOException
	 {
		 Date d=new Date();
		 String date = d.toString().replace(":", "_").replace(" ", "_");
		 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://Users//sunde//Scrnsht_Eclipse_E2E//" + " " +date.toString()+" "+result+"screenshot.png"));
		System.out.println(d.toString());	
		 
	 }

}
