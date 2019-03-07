package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class FBHomeOps {

	/****************************page objects *****************************************/
	
//	how button
	@FindBy (how = How.XPATH, using = "//a[@href='https://www.facebook.com/?ref=tn_tnmn']") WebElement homePage;
	
	//setting buttn
	@FindBy (how = How.PARTIAL_LINK_TEXT, using = "Settings") WebElement Settings ;
	
	
	@FindBy (how = How.XPATH , using = "//*[@id='userNavigationLabel']") WebElement HomePageDropDown ; 
	

//	get settings title
	@FindBy (how = How.CLASS_NAME , using = "uiHeaderTitle") WebElement settingsTitle ; 
	
//	Edit button for temperature 
	@FindBy (how = How.XPATH , using = "//li[@data-testid='settings_section_temperature'] and text()='Edit'") WebElement temperatureEdit ;
	
//	drop down select list
	@FindBy (how = How.NAME, using = "temperature") WebElement tempDropdown ;
	
//	find Save button
	@FindBy (how = How.XPATH , using = "//input[@value= 'save changes' and @type= 'submit']") WebElement SaveTemp ;
	
//	Notification id icon
	@FindBy(how = How.ID , using = "fbNotificationsJewel") WebElement fbNotification ;
	
//	search button on home screen 
	@FindBy(how=How.XPATH,using="//input[@placeholder='Search']") WebElement seachBox;
	
//	scoop whoop image tag
	@FindBy (how=How.XPATH, using = "//img[@class = '_6xu4 _6xu5 img']") WebElement scoopimage ;
	
	
	
	/*****************************page actions*************************************************/ 
	
	public void clickHomebutton ()
	{
		homePage.click();
	}
	
	public void navigateToSetting()
	{
		Settings.click(); 
		String title = "General Account Settings" ;
	}
	
	public void dropDown()
	{
		HomePageDropDown.click();
	}
	
	public String getSettingText() {
		return settingsTitle.getText();
	}
	
	public void editTemperature ()
	{
		temperatureEdit.click();
	}
	
	public void fahrenheitSelect ()
	{
		Select sel = new Select (tempDropdown);
		sel.selectByVisibleText("Fahrenheit");
	}
	
	public void saveSettings()
	{
		SaveTemp.click();
	}
	
	public void selectNotification ()
	{
		fbNotification.click();
	}
	public void enterSearchText (String text) {
		
		seachBox.sendKeys(text);
//		Action act = new Actions(driver); -- action cannot be executed from here
	}
	
	public void clickScoopwhoop ()
	{
		scoopimage.click();
	}
	
}

