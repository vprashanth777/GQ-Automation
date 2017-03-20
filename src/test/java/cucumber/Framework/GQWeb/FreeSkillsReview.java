package cucumber.Framework.GQWeb;



import java.awt.Robot;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

import cucumber.Framework.*;
import cucumber.Framework.CommanStepDefinations.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FreeSkillsReview extends Initialization{
	
	@FindBy(id="industry_selector")
	 WebElement IndustryValue;

	@FindBy(id="post_code")
	 WebElement PincodeObj;
	
	@FindBy(id="Australian")
	WebElement ExpTypeAustralia;
	
	@FindBy(id="Overseas")
	WebElement ExpTypeOverseas;
	
	@FindBy(id="both")
	WebElement ExpTypeboth;
	
	@FindBy(id="y3_5")
	WebElement WorkExp3_5;
	
	@FindBy(id="y1_3")
	WebElement WorkExp1_3;
	
	@FindBy(id="y6_9")
	WebElement WorkExp5_9;
	
	@FindBy(id="y10")
	WebElement WorkExp10;
	
	@FindBy(id="ai1")
	WebElement SpecificQulYes;
	
	@FindBy(id="ai2")
	WebElement SpecificQulNo;
	
	@FindBy(id="has_q")
	WebElement FormalQulYes;
	
	@FindBy(id="no_q")
	WebElement FormalQulNo;
	
	@FindBy(id="no_cv")
	WebElement ResumeuploadNo;
	
	@FindBy(id="fileSelect")
	WebElement ResumeuploadYes;
	
	@FindBy(id="fname")
	WebElement Firstname;
	
	@FindBy(id="lname")
	WebElement Lasttname;
	
	@FindBy(id="email")
	WebElement EmailEle;
	
	@FindBy(id="mobile")
	WebElement Mobile;
	
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
	

	

	
	public FreeSkillsReview()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@When("^User enter ([^\"]*),([^\"]*),([^\"]*) and ([^\"]*) in STEP1 Page$")
	public void user_enter_Business_and_Management_success_and(String Industry,String Exp,String ExpType, String Pincode) throws Throwable {
	
		KeyWords.SelectFromList(IndustryValue, Industry);
		
		//IndustryValue.sendKeys(Keys.TAB);
	switch (ExpType.toLowerCase().trim())
	{
	case "australian" :
		ExpTypeAustralia.click();
		log.info("User click on australian");
		break;
	case "overseas" :
		ExpTypeOverseas.click(); 
		log.info("User click on overseas");
		break;
	case "both" :
		ExpTypeboth.click();
		log.info("User click on both");
		break;
		
	
	}
	
	switch (Exp.trim())
	{
	case "1-3" :
		WorkExp1_3.click(); 
		log.info("User click on 1-3");
		break;
	case "3-5" :
		WorkExp3_5.click(); 
		log.info("User click on 3-5");
		break;
	case "5-10" :
		WorkExp5_9.click();
		log.info("User click on 5-10");
		break;
	case "10" :
		WorkExp10.click();
		log.info("User click on 10");
		break;
	default: 
		System.out.println("Please enter valid work exp");
		log.error("Please enter valid work exp");
	        break;
	}
	
	PincodeObj.sendKeys(Pincode);
	PincodeObj.sendKeys(Keys.TAB);
	KeyWords.WaitforPageLoad();
	}

	
	
	@When("^User enter ([^\"]*),([^\"]*) and ([^\"]*) in STEP2 Page$")
	public void user_enter_Notsure_Yes_and_Yes_in_STEP_Page(String Specificqual,String Formalqual,String UpLoad) throws Throwable {
		
	
		
		
		if(Specificqual.toLowerCase().contains("yes"))
		{
			SpecificQulYes.click();
			KeyWords.WaitforPageLoad();
			
			 String[]  SpecificqualDetails= Specificqual.split(":");
			 driver.findElement(By.xpath("//input[@placeholder='Qualification Name']")).sendKeys(SpecificqualDetails[1].trim());
		}
		
		else{SpecificQulNo.click();}
		
		
		
		if(Formalqual.toLowerCase().contains("yes"))
		{
			FormalQulYes.click();
			KeyWords.WaitforPageLoad();
			 String[]  FormalqualDetails= Formalqual.split(":");
			 if (FormalqualDetails[1].toLowerCase().contains("1"))
			 {	 driver.findElement(By.id("w1y")).click();}
			 
			 else if(FormalqualDetails[1].toLowerCase().contains("2"))
			 {
				 driver.findElement(By.id("w25")).click();;
			 }
			 
			 else
				 driver.findElement(By.id("w5")).click();
			 
		}
		
		else{FormalQulNo.click();}
		
		Thread.sleep(2000);
		
		
		/*KeyWords.WaitforPageLoad(5);
		WD.until(ExpectedConditions.elementToBeClickable(ResumeuploadNo));
		CommonStep.user_click_the_button(ResumeuploadNo);
		ResumeuploadNo.click();*/
		
		if(UpLoad.toLowerCase().contains("yes"))
		{
			KeyWords.WaitforPageLoad();
			
			WD.until(ExpectedConditions.elementToBeClickable(ResumeuploadYes));
			ResumeuploadYes.click();

		
			KeyWords.WaitforPageLoad();
			File file = new File("TestDataSampleFiles/SAMPLE RESUME.docx");
			String absolutePath = file.getAbsolutePath();
			
			KeyWords.UploadfilefromLocal(absolutePath);
			
			KeyWords.WaitforPageLoad();
			
		}
		
		else{ResumeuploadNo.click();}
		
		log.info("User enter "+Specificqual+"," +Formalqual +"and "+UpLoad+" in STEP2 Page");
	}
	
	
	@When("^User enter ([^\"]*),([^\"]*),([^\"]*),(\\d+) and ([^\"]*)  in STEP3 Page$")
	public void user_enter_TestFirst_TestLast_Test_Test_Test_com_and_TV_in_in_STEP_Page(String First,String Last,String Email,int phoneNum,String Media) throws Throwable {
		KeyWords.WaitforPageLoad();
	WD.until(ExpectedConditions.visibilityOf(Firstname));
		
		Firstname.sendKeys(First);
		Lasttname.sendKeys(Last);
		EmailEle.sendKeys(Email);
		Mobile.sendKeys(Integer.toString(phoneNum));
		KeyWords.WaitforPageLoad();
		switch(Media.toLowerCase())
		{
		case "online" : online.click();break;
		case "tv" : TV.click();break;
		case "radio" : Radio.click();break;
		case "print" : Print.click();break;
		case "referral" : Referral.click();break;
		default : Other.click();break;
		}
		
		KeyWords.WaitforPageLoad();
		
		log.info("User enter "+First+"," +Last +", "+Email+","+phoneNum +", and "+Media+" in STEP3 Page");
	}

	@When("^User is ([^\"]*) Free-ebook$")
	public void user_is_Yes_Free_ebook(String arg1) throws Throwable {
		
		if(arg1.toLowerCase().contains("yes"))
		{
			driver.findElement(By.cssSelector("span")).click();
	        if (!driver.findElement(By.id("payRise")).isSelected()) {
	        	driver.findElement(By.id("payRise")).click();
	        }
			CommonStep.user_click_the_Object("DOWNLOAD YOUR FREE E-BOOK HERE");
			KeyWords.WaitforPageLoad();
			
			
		}
	log.info("User is "+arg1+" Free-ebook");
	}


	



}
