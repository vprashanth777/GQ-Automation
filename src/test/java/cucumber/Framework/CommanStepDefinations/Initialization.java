package cucumber.Framework.CommanStepDefinations;



import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.Logger;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class Initialization{
	

	public static  WebDriver driver=null;
	public static AndroidDriver ADdriver=null;
	public static WebDriverWait WD=null;

	public static String winHandleBefore ;
	public static JavascriptExecutor JS=null;
	public static ReUsablesKeywords KeyWords=new ReUsablesKeywords();
	public static CommonStepDefinations CommonStep= new CommonStepDefinations();
	
	public static Logger log = CustomLogger.log(Initialization.class);

	public static AppiumServer appiumServer=null;
	public static Process process;
	 
	Properties properties;
	String BrowserType;
	int I_wait=10;
	int WD_wait=60;
	int PG_wait=60;
	 public Initialization()
	 {
		
		  properties = new Properties();
		 FileInputStream fis;
		try {
			fis = new FileInputStream("Data/TestProperties.xml");
			 properties.loadFromXML(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  
		
		 
			
	 }
	 
	 public String GetPropertValue(String S)
	 {
		return properties.getProperty(S);
		 
	 }
	



	 
	public void GetDriverObject() 
	{
		String BrowserType=System.getProperty("BROWSER","Firefox");
		log.info("Execution will be begin on Browser name " +BrowserType );
		String Environment=properties.getProperty("Environment");
		log.info("Execution will be begin on Environment  " +Environment );
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
		if(driver==null)
		{
			if(BrowserType.equalsIgnoreCase("IE")) {
			
				
				
				
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				

				//System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
				 driver = new InternetExplorerDriver(capabilities);

				
				driver.manage().window().maximize();
			}
			
			
			else if(BrowserType.equalsIgnoreCase("CHROME")) {
				
				
				
				System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
				driver=new ChromeDriver();
				driver.manage().window().maximize();
			}
			
			else if(BrowserType.equalsIgnoreCase("FIREFOX")) {
				//System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
				//System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
				
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				
				}
			
			else if(BrowserType.equalsIgnoreCase("HTMLUNIT")) {
				LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log",
						"org.apache.commons.logging.impl.NoOpLog");
				java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit")
						.setLevel(Level.OFF);
				java.util.logging.Logger.getLogger("org.apache.commons.httpclient")
						.setLevel(Level.OFF);
				driver = new HtmlUnitDriver();
			
				 I_wait=10;
				 WD_wait=30;
				
			}
			
		/*	else if(BrowserType.equalsIgnoreCase("PHANTOMJS")) {
				
			
				capabilities.setJavascriptEnabled(true);                
				capabilities.setCapability("takesScreenshot", true);  
				capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"Drivers/phantomjs.exe");
                    driver = new  PhantomJSDriver(capabilities);
				
			}*/
			
			else if(BrowserType.equalsIgnoreCase("NATIVE") || BrowserType.equalsIgnoreCase("HYBRID") ) {
				
				
			      
		        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		        capabilities.setCapability("deviceName", "Android Emulator");
		       // capabilities.setCapability("app","C:\\Users\\prashanth.veldandi\\Downloads\\Kesineni_POC_Android_V0.7_.apk");
		        
		        try {
					driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			
			else if(BrowserType.equalsIgnoreCase("MOBIWEB")) {
				
				
			
			if(process==null)
				{
					KeyWords.StartEmulator();
					
				}
				
				if(appiumServer==null)
				{
					
					KeyWords.StartAppium();
								
					
				}
				
				while(!appiumServer.isServerRunning())
				{
					try {
						Thread.sleep(60000);
					} catch (InterruptedException e) {
						
					}
				}
				
				
				
				
		           capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
		           //capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"4.2.2");
		           capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android"); 
		       
		        
		           capabilities.setCapability("deviceName", "Android Emulator");
		           try {
					driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
		       // capabilities.setCapability("deviceName", "Android Emulator");
		       
			}
		
			else if(BrowserType.equalsIgnoreCase("BROWSERSTACK")) {
			 String USERNAME = "prasanthpillai1";
			 String AUTOMATE_KEY = "pGCB5mwUkBfv7acdEGjB";
			 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
			 
			 ReadBrowserStack RBS=new ReadBrowserStack(Environment);
			 
					 if(Environment.equalsIgnoreCase("WINDOWS"))
					 {
					 capabilities.setCapability("browser", RBS.Browser);
					 capabilities.setCapability("browser_version", RBS.Browser_version);
					 capabilities.setCapability("os", RBS.OperatingSystem);
					 capabilities.setCapability("os_version", RBS.OperatingSystemversion);
					 capabilities.setCapability("resolution", "1024x768");
					 }
					 
					 else if(Environment.toLowerCase().contains("mobile"))
					 {
						 capabilities.setCapability("browserName", RBS.Browser);
						 capabilities.setCapability("platform", RBS.OperatingSystem);
						 capabilities.setCapability("device", RBS.Device);
					 }
			 
			 
			    try {
					driver = new RemoteWebDriver(new URL(URL), capabilities);
				} catch (MalformedURLException e) {
				
					e.printStackTrace();
				}
				
			}
			
			else {
				System.out.println("Please select a valid Browser");
				System.exit(0);
			}
			
			I_wait=100;
			 WD_wait=60;
			 PG_wait=320;
		}
		
	
		driver.manage().timeouts().implicitlyWait(I_wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PG_wait, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		WD=new WebDriverWait(driver, WD_wait);
		 JS=(JavascriptExecutor) driver;
		
	}
	
	
	
	
	
	
	}
