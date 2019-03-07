package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import dataProviders.ConfigFileReader;
import dataProviders.TestBase;
import pageObjects.FBLoginPage;

public class FBLoginPageTest extends TestBase{

	FBLoginPage loginPg = PageFactory.initElements(driver, FBLoginPage.class);
	ConfigFileReader config = new ConfigFileReader();
	
	@Test(priority=1)
	public void loginUser ()
	{
		config.getURL1();
	}
	
	@Test(priority=2)
	public void setUsername()
	{
		loginPg.setEmail("9035915124");
	}
	
	@Test(priority=3)
	public void setPasswd()
	{
		loginPg.setPasswd("Selenium!!!");
	}
	
	@Test(priority=4)
	public void logincClck() {
		loginPg.clickOnLoginButton();
	}

}
