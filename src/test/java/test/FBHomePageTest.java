package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import dataProviders.TestBase;
import pageObjects.FbHomePage;

public class FBHomePageTest extends TestBase{

	FbHomePage homePage = PageFactory.initElements(driver, FbHomePage.class);
	@Test(priority=1)
	public void fBlogOut ()
	
	{
		homePage.clickOnProfileDropDown();
		homePage.clickOnLogOut();
	}
	
}
