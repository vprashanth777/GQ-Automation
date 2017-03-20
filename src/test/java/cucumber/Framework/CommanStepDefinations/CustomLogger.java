package cucumber.Framework.CommanStepDefinations;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.*;;

public class CustomLogger {

	public static Logger log(Class sourceClass){
		Logger log = Logger.getLogger(sourceClass);
		PropertyConfigurator.configure("./log4j.properties");
		return log;
	}
		
}
