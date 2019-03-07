package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HFDCHome {

	@FindBy(how=How.LINK_TEXT , using = "Customer Care") WebElement CCare ;
	@FindBy(how=How.LINK_TEXT,using = "Queries, Feedback or Complaints") WebElement queryLink ;
	@FindBy(how=How.LINK_TEXT, using = "How do I update my address ?") WebElement addLink;

	//	frame handling in Tools SQA
	
	@FindBy(how = How.TAG_NAME, using = "iframe") WebElement iframes ; 
	@FindBy(how=How.ID, using = "IF1") WebElement frame1;
	@FindBy(how=How.NAME , using = "iframe2") WebElement frame2;
	
	
//	context click 
	
	@FindBy(how=How.XPATH, using = "//input[@placeholder='Search']") WebElement contextSearch;
}