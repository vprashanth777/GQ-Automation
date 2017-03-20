package cucumber.Framework;





import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;



import cucumber.Framework.CommanStepDefinations.Initialization;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions(
		format = { "pretty", "html:target/cucumber","json:target/JSON/Output.json" },
		
		features ={ "."},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/CucumberReport.html","rerun:target/rerun.txt"},
       
        tags={"@GQSMOKE"}
   

)


public class FirstRunnerTest extends AbstractTestNGCucumberTests {
	

	
}


