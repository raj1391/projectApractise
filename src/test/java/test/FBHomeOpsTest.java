package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataProviders.TestBase;
import pageObjects.FBHomeOps;

public class FBHomeOpsTest extends TestBase {

	FBHomeOps homeOp = PageFactory.initElements(driver, FBHomeOps.class);

	@Test(priority = 1)
	public void verfyclickOnHome() {
		homeOp.clickHomebutton();
		String fbUrl = driver.getCurrentUrl();
		String urlexpected = "https://www.facebook.com/";
		Assert.assertEquals(fbUrl, urlexpected);
	}

	@Test(priority = 2)
	public void verifySeetingsPageLoad() {
		homeOp.dropDown();
		homeOp.navigateToSetting();
		String settingName = "General Account Settings";
		Assert.assertEquals(settingName, homeOp.getSettingText());
	}
}
