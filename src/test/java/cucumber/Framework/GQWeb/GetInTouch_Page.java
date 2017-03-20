package cucumber.Framework.GQWeb;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class GetInTouch_Page extends cucumber.Framework.CommanStepDefinations.Initialization {
	
	
	AjaxElementLocatorFactory  factory;
	
	 @FindBy(id="fname")
	    WebElement FirstName_txtfield;
	 @FindBy(id="lname")
	    WebElement LastName_txtfield;
	 @FindBy(id="mobile")
	    WebElement Phone_txtfield;
	 @FindBy(id="email")
	    WebElement Email_txtfield;
	 @FindBy(id="aboutgq")
	    WebElement AboutGQ_txtfield;
	 @FindBy(id="message")
	    WebElement Message_txtfield;
	 //updated css path prashanth
	 @FindBy(css="input.wpcf7-form-control.wpcf7-submit")
	    WebElement Send_btn;
	 @FindBy(xpath=".//*[@id='wpcf7-f210-p1453-o1']/form/div[11]")
	    WebElement MessageSent_Label;
	 
	
	 
	public GetInTouch_Page(){
		
     PageFactory.initElements(driver, this);
 
     

	}
	
	@When("^User populate ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*) and ([^\"]*)$")
	public void user_populate_FirstName_LastName_Phone_Email_HowDidYouHearAboutUs_and_Message_field(String FirstName, String LastName, 
			String Phone, String Email, String AboutGQ, String Message) throws Throwable {
	    FirstName_txtfield.sendKeys(FirstName);	    
	    LastName_txtfield.sendKeys(LastName);
	    Phone_txtfield.sendKeys(Phone);
	    Email_txtfield.sendKeys(Email);
	    AboutGQ_txtfield.sendKeys(AboutGQ);
	    Message_txtfield.sendKeys(Message);
	    Message_txtfield.sendKeys(Keys.TAB);
	 log.info("User populate "+ FirstName + ", "+LastName +", " +Phone + ", "+ Email + ", " + AboutGQ +" and "+ Message);
	}
	
	@When("^User click the Send button$")
	public void user_click_the_Send_button() throws Throwable {
		WD.until(ExpectedConditions.elementToBeClickable(Send_btn));
		Send_btn.click();
		log.info("User click the Send button");
	//	JS.executeScript("arguments[0].click();", Send_btn);

	}

	@Then("^User successfully submitted my inquiry to the GQ system$")
	public void user_successfully_submitted_my_inquiry_to_the_GQ_system() throws Throwable {
		
		//Thread.sleep(5000);
		WD.until(ExpectedConditions.elementToBeClickable(MessageSent_Label));
		log.info("Your message was sent successfully. Thanks.Actual ::"+ MessageSent_Label.getText());
		Assert.assertEquals("Your message was sent successfully. Thanks.", MessageSent_Label.getText());	    
		

	}
	
	@Then("^User unsuccessfully submitted my inquiry to the GQ system$")
	public void user_unsuccessfully_submitted_my_inquiry_to_the_GQ_system() throws Throwable {
		
		//Thread.sleep(5000);
		WD.until(ExpectedConditions.elementToBeClickable(MessageSent_Label));
		log.info("Validation errors occurred. Please confirm the fields and submit it again.Actual is ::"+ MessageSent_Label.getText());
		Assert.assertEquals("Validation errors occurred. Please confirm the fields and submit it again.", MessageSent_Label.getText());	    
		

	}

	

}
