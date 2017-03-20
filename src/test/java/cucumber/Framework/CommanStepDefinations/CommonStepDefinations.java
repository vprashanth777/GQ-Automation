package cucumber.Framework.CommanStepDefinations;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CommonStepDefinations extends Initialization {

	String Url = null;
	
	@Before

	public void BrowserSetup()
	{
		GetDriverObject();
		WD=new WebDriverWait(driver, 60);
		winHandleBefore= driver.getWindowHandle();
		
		log.info("Execution started");
		
		
	}
	
	
	@After
	public void tearDown(Scenario scenario) {
	    if (scenario.isFailed() && !GetPropertValue("BrowserType").equalsIgnoreCase("HTMLUNIT")) {			
	      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			
	      scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
	      
	      log.warn("Execution got failed for " + scenario.getName() +" and screenshot got captured" );
	    
	   }
	driver.quit();
	log.info("Execution Completed and Browser was quit");
	
	
	    driver=null;
	}
	

	
	
	@Given("^User Navigate to the \"([^\"]*)\" URL$")
	public void user_Navigate_to_the_URL(String arg1) throws Throwable {
		String Title = null;
		switch (arg1.toUpperCase())
		{
		case "GQWEB": 
			Url=GetPropertValue("GQWebURL");
			 log.info("User Navigate to the GQWebURL "+ arg1.toUpperCase() );
			 Title="Get Qualified Australia";
        break;
		case "FSR": 
			Url=GetPropertValue("FSRWebURL");
			 log.info("User Navigate to the FSRWebURL "+ arg1.toUpperCase() );
			 Title="Free Skills Review Generator";
        break;
		default: 
			Url=arg1;
			System.out.println("Please enter valid URL name");
			log.warn("Please enter valid URL name");
		        break;
		}
		
		driver.get(Url); 
		try{
		  WD.until(ExpectedConditions.titleContains(Title));
		  log.info("Page title validation is successfull after URl navigation");
		}
		
		catch(Exception e)
		{
			log.error("Exception got occured during title validation after URl navigation :" + e.toString());
		}
	//	Assert.fail();
	  
	}
	
	@Given("^User Navigate to the ([^\"]*) URL within Application$")
	public void user_Navigate_to_the_training_package_engineering_URL_within_Application(String arg1) throws Throwable {
	   String urlbuild=Url+"/"+arg1;
	   
	   driver.navigate().to(urlbuild);
	   KeyWords.WaitforPageLoad();
	   log.info("User Navigate to the "+arg1+" URL within Application");
	}

	
	
	
	@When("^User click the \"([^\"]*)\"$")

	public void user_click_the_Object(String arg1) throws Throwable {
	
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		try{
		KeyWords.ClickonObject(KeyWords.FindObject(arg1));
		}
		catch(Exception e)
		{
			Assert.fail(e.toString());
			log.error("Exception got occured at User click the object ::" + e.toString());
		}
				
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		KeyWords.WaitforPageLoad();
	
	} 
	
	
	
	@Then("^User Application should be navigated to the \"([^\"]*)\" Page$")
	public void user_Application_should_be_navigated_to_the_Page(String arg1) throws Throwable {
		try{
		WD.until(ExpectedConditions.titleContains(arg1));
		}
		
		catch (Exception e) {
			System.out.println(driver.getTitle());
			log.error("Page Title Validation got failed for Page Name::" +arg1+ " Actual ::"+driver.getTitle());
			Assert.fail("Page Title Validation got failed for Page Name::" +arg1+ " Actual ::"+driver.getTitle());
			
		}
		
	}

	
	@Then("^User is able to see the \"([^\"]*)\" from Page$")
	public void user_is_able_to_see_the_from_Page(String arg1) throws Throwable {
	/*	try{
		WD.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathBuilder(arg1))));
		}
		catch (Exception e) {
			Assert.fail("Field Validation got failed for field" +arg1);
		}
		*/
		
		if (!driver.findElement(By.tagName("html")).getText().toLowerCase().contains(arg1.toLowerCase().trim())) {
            System.out.println("verifyTextPresent failed expected ::"+arg1.toLowerCase().trim());
            //System.out.println(driver.findElement(By.tagName("html")).getText().toLowerCase());
            log.error("verifyTextPresent in a page failed expected ::"+arg1.toLowerCase().trim());
            Assert.fail("verifyTextPresent in a page failed expected ::"+arg1.toLowerCase().trim());
        }
	}

	@When("^User click the links$")
	public void user_click_Events(List<String>  name) throws Throwable {
		for(String S:name)
		{
			System.out.println(S);
			user_click_the_Object(S);
		}
		
	}
	
	
	@Given("^User navigate to the application exact ([^\"]*)$")
	public void user_navigate_to_the_application_exact_URL(String URL) throws Throwable {
		driver.get(URL);
		log.info("User navigate to the application exact URL " + URL);

	}
	
}
