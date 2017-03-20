package cucumber.Framework.GQWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.Framework.CommanStepDefinations.Initialization;
import cucumber.api.java.en.When;

public class FastTrackMBA extends Initialization{
	@FindBy(id="online")
	WebElement online;
	@FindBy(id="TV")
	WebElement TV;
	@FindBy(id="Radio")
	WebElement Radio;
	@FindBy(id="Print")
	WebElement Print;
	@FindBy(id="Referral")
	WebElement Referral;
	@FindBy(id="Other")
	WebElement Other;
	
	@FindBy(id="post_code")
	 WebElement PincodeObj;
	
	@FindBy(id="first_name")
	WebElement Firstname;
	
	@FindBy(id="last_name")
	WebElement Lasttname;
	
	@FindBy(id="inputEmail")
	WebElement EmailEle;
	public FastTrackMBA()
	{
	
		PageFactory.initElements(driver, this);
	}
	
	@When("^User enter \"([^\"]*)\" ([^\"]*)$")
	public void user_enter_Berkshire_Park_NSW(String arg1,String arg2) throws Throwable {
		WD.until(ExpectedConditions.presenceOfElementLocated(By.id(arg1.trim())));
		//System.out.println(driver.findElement(By.id(arg1)).getSize());
		driver.findElement(By.id(arg1.trim())).click();
		driver.findElement(By.id(arg1.trim())).clear();
		driver.findElement(By.id(arg1.trim())).sendKeys(arg2);
	log.info("Fast track MBA page :User enter "+ arg2);
	  
	}
	
	@When("^User enter ([^\"]*),([^\"]*),([^\"]*) in fasttrackMBA$")
	public void user_enter_TestFirst_TestLast_fasttrackMBA(String First,String Last,String Email) throws Throwable {
		KeyWords.WaitforPageLoad();
		Firstname.sendKeys(First);
		Lasttname.sendKeys(Last);
		EmailEle.sendKeys(Email);
		log.info("Entered First name,last name and Email");
	}
		
	

	
}
