package cucumber.Framework;





import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.EmailTrigger.Sendmail;

import cucumber.Framework.CommanStepDefinations.Initialization;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions(
		format = { "pretty", "html:target/cucumber","json:target/JSON/OutputRerun.json" },
        features ={ "@target/rerun.txt"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/CucumberReport_ReRun.html","rerun:target/rerun1.txt"}
   

)


public class SecondRunnerFailed extends AbstractTestNGCucumberTests {
	
	@BeforeClass
	public static void CheckFile() throws Exception 
	{
		Initialization I=new Initialization();
		if(I.GetPropertValue("BrowserType").equalsIgnoreCase("MOBIWEB"))
		{I.KeyWords.Prirequisite_Mobile();}
		
		
		File file = new File("target/rerun.txt");
		while (!file.exists()) {Thread.sleep(1000);}
		
		while(!file .canWrite()){Thread.sleep(1000);}
		  Thread.sleep(10000);
				    
		   
		Initialization.log.info("Execution is started from Second Runner Test");
	}
	
 	
	@AfterClass
	public static void sendemail()
	{
		Sendmail s=new Sendmail();
		try {
			s.mail();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Initialization.log.info("Execution is ended from second Runner Test");
		Initialization.KeyWords.teardown();
		
	}
	
}


