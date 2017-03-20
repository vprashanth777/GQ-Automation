package cucumber.Framework.CommanStepDefinations;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import com.google.common.base.Predicate;

public class ReUsablesKeywords extends Initialization {
	
	Robot robot;
	
	public void SelectFromList(WebElement WE,String Value)
	{
		Select S=new Select(WE);
		
		try{S.selectByValue(Value);}
		catch (Exception e) {
			log.warn("SelectFromList selectByValue exception ::" + e.toString());
		}

		
		try{S.selectByVisibleText(Value);}
		catch (Exception e) {
			log.warn("SelectFromList selectByVisibleText exception ::" + e.toString());
		}
		
		try {S.selectByIndex(Integer.parseInt(Value));} 
		catch (Exception e) {
			log.warn("SelectFromList selectByIndex exception ::" + e.toString());
		}
		
		WE.sendKeys(Keys.TAB);
		WaitforPageLoad();
	}
	

	public void WaitforPageLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
			
	    Predicate<WebDriver> pageLoaded = new Predicate<WebDriver>() {

	        @Override
	        public boolean apply(WebDriver input) {
	            return ((JavascriptExecutor) input).executeScript("return document.readyState").equals("complete");
	        }

	    };
	    try{
	    wait.until(pageLoaded);
	    }
	    catch(Exception e){
	    		
		log.error("WaitforPageLoad exception occured " + e.toString());	}           
	}

	


	public void UploadfilefromLocal(String Path)  {
		
	    
	    try {
			robot = new Robot();
		
		robot.delay(5000);
		//enterChars ("oupbeta2");
				
		StringSelection ss=new StringSelection(Path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
	    } catch (AWTException e) {
			// TODO Auto-generated catch block
	    	log.error("UploadfilefromLocal exception occured " + e.toString());
			e.printStackTrace();
		}		 
	}
	
	public void HandleAlert()
	{
		try{
			
			if(driver.getCurrentUrl().contains("rto-partnering-enhance-your-rto")){
				WD.until(ExpectedConditions.alertIsPresent()).accept();
			}
			
			
			 WD.until(ExpectedConditions.alertIsPresent()).dismiss();
			 log.info("Alert was dismissed");
		}
		
		catch(Exception e){
			//Assert.fail("No Alert Present");
			System.out.println("No Alert Present");
			log.warn("No Alert Present ,Exception occured "+e.toString());
		}
		
	}
	
	
	public List<WebElement> FindObject(String arg1)
	{
		List<WebElement> WB = null;
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		 if(driver.findElements(By.linkText(arg1)).size() >0)
		{
			 WB=driver.findElements(By.linkText(arg1));
			 log.info("Element is identified as linkText");
		}
		
		else if(driver.findElements(By.partialLinkText(arg1)).size() >0)
		{
			 WB=driver.findElements(By.partialLinkText(arg1));
			 //System.out.println("By.partialLinkText(arg1)");
			 log.info("Element is identified as partialLinkText");
		}	
		
		
		else if(driver.findElements(By.id(arg1)).size() >0)
		{
			WB=driver.findElements(By.id(arg1));
			//System.out.println("By.id(arg1)");
			log.info("Element is identified as ID");
		}
		 
		else if(driver.findElements(By.name(arg1)).size() >0)
		{
			 WB=driver.findElements(By.name(arg1));
			 //System.out.println("By.name(arg1)");
			 log.info("Element is identified as Name");
		}	 
		 
		else if(driver.findElements(By.xpath(XpathBuilder(arg1))).size() >0)
		{
			 WB=driver.findElements(By.xpath(XpathBuilder(arg1)));
			 log.info("Element is identified as XpathBuilder");
		}	
		 
				
		
		else if(driver.findElements(By.xpath("//.[contains(@onclick,'"+arg1+"')]")).size() >0)
		{
			 WB=driver.findElements(By.xpath("//.[contains(@onclick,'"+arg1+"')]"));
			 //System.out.println("//.[contains(@onclick,'"+arg1+"')]");
			 
			 log.info("Element is identified xpath as //.[contains(@onclick,'"+arg1+"')]" );
		}
		
		else if(driver.findElements(By.xpath("//img[contains(@alt,'"+arg1+"')]")).size() >0)
		{
			 WB=driver.findElements(By.xpath("//img[contains(@alt,'"+arg1+"')]"));			 
			 //System.out.println("//img[contains(@alt,'"+arg1+"')]");
			 log.info("Element is identified xpath as //img[contains(@alt,'"+arg1+"')]" );
		}
		
		else if(driver.findElements(By.xpath("//span[contains(.,'"+arg1+"')]")).size() >0)
		{
			 WB=driver.findElements(By.xpath("//span[contains(.,'"+arg1+"')]"));
			 //System.out.println("//span[contains(.,'"+arg1+"')]");
			 log.info("Element is identified xpath as //span[contains(.,'"+arg1+"')]" );
		}
		
		
		 
		else if(driver.findElements(By.xpath("//.[contains(@id,'"+arg1+"')]")).size() >0)
		{
			 WB=driver.findElements(By.xpath("//.[contains(@id,'"+arg1+"')]"));
			 //System.out.println("//.[contains(@id,'"+arg1+"')]");
			 log.info("Element is identified xpath as //.[contains(@id,'"+arg1+"')]" );
		}
		else if(driver.findElements(By.xpath("//button[contains(.,'"+arg1+"')]")).size() >0)
		{
			 WB=driver.findElements(By.xpath("//button[contains(.,'"+arg1+"')]"));
			 //System.out.println("//.[contains(.,'"+arg1+"')]");
			 log.info("Element is identified xpath as //button[contains(.,'"+arg1+"')]" );
		}
		 
		 
		 
		 
		
		else if(driver.findElements(By.xpath("//.[contains(.,'"+arg1+"')]")).size() >0)
		{
			 WB=driver.findElements(By.xpath("//.[contains(.,'"+arg1+"')]"));
			 //System.out.println("//.[contains(.,'"+arg1+"')]");
			 log.info("Element is identified xpath as //.[contains(.,'"+arg1+"')]" );
		}	
		 
		 
			
		 
		 
		else if(driver.findElements(By.xpath(arg1)).size() >0)
		{
			 WB=driver.findElements(By.xpath(arg1));
			 //System.out.println("driver.findElements(By.xpath(arg1))");
			 log.info("Element is identified xpath as "+ arg1);
		} 

		
		else{
			Assert.fail("Not able to FIND the Element with :: "+arg1 );
			log.error("Unable to identify the Element with :" + arg1);
		}
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 return WB;
		 
		
	}
	
	public void ClickonObject(List<WebElement> WBL) throws InterruptedException
	{
		
		for(WebElement WB:WBL)
		{
			String value ;
		//	WD.until(ExpectedConditions.elementToBeClickable(WB));
		if(WB.isDisplayed() && WB.isEnabled() )
		{
			
			WD.until(ExpectedConditions.elementToBeClickable(WB));
			
			 try {
				 Actions actions = new Actions(driver);
					actions.moveToElement(WB).build().perform();
					Thread.sleep(1000); 
					actions.click(WB).build().perform();   
					
					 log.info("Element is clicked " + WB.getText());
			 }   
			
			 catch (Exception e) {
			
				 try{
					 value = WB.getAttribute("href");
			         driver.navigate().to(value);
			         KeyWords.WaitforPageLoad();
				 }
				 catch (Exception e1) {}
			 }
				
			 break;
		}
		
		}
	
	}

	public void Entertext(String arg1,String text)
	{
		List<WebElement> WB = null;

		String xpath = "//input[contains(translate(@placeholder, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'"
				+ arg1.toLowerCase() + "')]";
		if (driver.findElements(By.xpath(xpath)).size() > 0) {
			WB = driver.findElements(By.xpath(xpath));
			log.info("Entertext:Element was identified by xpath ");
		}

		else if (driver.findElements(By.id(arg1)).size() > 0) {
			WB = driver.findElements(By.id(arg1));
			log.info("Entertext:Element was identified by id ");

		} else if (driver.findElements(By.name(arg1)).size() > 0) {
			WB = driver.findElements(By.name(arg1));
			log.info("Entertext:Element was identified by name ");

		} else if (driver.findElements(By.xpath("//input[contains(translate(@id, '-', ''),'" + arg1 + "')]"))
				.size() > 0) {
			WB = driver.findElements(By.xpath("//input[contains(translate(@id, '-', ''),'" + arg1 + "')]"));
			log.info("Entertext:Element was identified by xpath //input[contains(translate(@id, '-', '')" + arg1 );
		} else {
			log.error("Not able to locate  the Element with ::" + arg1);
			Assert.fail("Not able to locate  the Element with ::" + arg1);
			
		}

		for (WebElement W : WB) {
			if (W.isDisplayed() && W.isEnabled()) {
				W.click();
				W.clear();
				W.sendKeys(text);
			}
		}
		
	}
	
	

	 public String XpathBuilder(String str)
	 {
		String xpathbuilder="//a[translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='"+str.toLowerCase()+"']";
		//System.out.println(xpathbuilder);
		
		//log.info("Xpath Builder ::" + xpathbuilder );
		return xpathbuilder;
		
	 }
	 
	 public void Prirequisite_Mobile()
	 {
		 StartAppium();
		 StartEmulator();
		
	 }
	 
	 public void StartEmulator()
	 {
		/* String value = System.getenv("ANDROID_HOME");
			
			String sdkPath = value.replace("sdk", "");
			String adbPath = sdkPath + "platform-tools" + File.separator + "adb";
			String emulatorPath = sdkPath + "tools" + File.separator + "emulator";*/
			
		 String value = System.getenv("ANDROID_PATH");
		 
		 String emulatorPath = value +  File.separator + "emulator";
			Initialization.log.info("Starting emulator for 'GQA' ...");
				 String[] aCommand = new String[] { emulatorPath, "-avd", "GQA" };
				 try {
					 Initialization.process= new ProcessBuilder(aCommand).start();
					 Initialization.process.waitFor(180, TimeUnit.SECONDS);
				  Initialization.log.info("Emulator launched successfully!");
				 }
				 catch (Exception e) {
					  e.printStackTrace();
					 }
	 }
	 
	 public void StartAppium()
	 {
		 
		 
		 try{
			 Runtime.getRuntime().exec("taskkill /F /IM Appium.exe");
			 ImplicitlyWait(3000);
			  ServerArguments serverArguments = new ServerArguments();
				serverArguments.setArgument("--address", "127.0.0.1");
				serverArguments.setArgument("--chromedriver-port", 9516);
				serverArguments.setArgument("--bootstrap-port", 4725);
				serverArguments.setArgument("--no-reset", true);
				serverArguments.setArgument("--local-timezone", true);

				Initialization.appiumServer= new AppiumServer(serverArguments);

				Initialization.appiumServer.startServer();
				
			 } catch (Exception e) {
			 // e.printStackTrace();
			 }
		 
		 while(!appiumServer.isServerRunning())
			{
				try {
					Thread.sleep(60000);
				} catch (InterruptedException e) {
					
				}
			}
	 }
	 
	 public void ImplicitlyWait(long I)
	 {
		 try {
				Thread.sleep(I);
			} catch (Exception e) {
				
	 }
	 }
	 
	 public void teardown()
	 {
		 Initialization.process.destroy();
			Initialization.process=null;
			
			if(Initialization.appiumServer.isServerRunning())
			{
				Initialization.appiumServer.stopServer();
				Initialization.appiumServer=null;
			}
			
			try {
				Runtime.getRuntime().exec("taskkill /F /IM qemu-system-i386.exe");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 
	 public void ActionClick(WebElement WE)
	 {
		 Actions actions = new Actions(driver);
			actions.moveToElement(WE).build().perform();
			ImplicitlyWait(1000);
			actions.click(WE).build().perform();
	 }
	 
	 public void dragAndDrop(WebElement sourceElement)
	    {
		 
		
			List<WebElement> DragandDrop=driver.findElements(By.xpath("//div[@class='fsr-canvas-row ui-droppable ui-sortable']"));
			//System.out.println(DragandDrop.size());
			WebElement destinationElement=DragandDrop.get(DragandDrop.size()-1);
			
			ActionClick(destinationElement);
			ImplicitlyWait(3000);
		 try {
				if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
					 Actions builder = new Actions(driver);

				        // Click and hold fromElem
				        builder = builder.clickAndHold(sourceElement);

				        builder.moveToElement(destinationElement).release().build().perform();
				        
				        KeyWords.ImplicitlyWait(2000);
						KeyWords.WaitforPageLoad();
						KeyWords.ImplicitlyWait(2000);
					
					
				} else {
					System.out.println("Element was not displayed to drag");
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Element with " + sourceElement + "or" + destinationElement + "is not attached to the page document "
						+ e.getStackTrace());
			} catch (NoSuchElementException e) {
				System.out.println("Element " + sourceElement + "or" + destinationElement + " was not found in DOM "+ e.getStackTrace());
			} catch (Exception e) {
				System.out.println("Error occurred while performing drag and drop operation "+ e.getStackTrace());
			}
		 
		
	    }
	 
	 public void switchwindow()
	 {
		 
			 for(String S:driver.getWindowHandles())
			 {
				 if(!S.equalsIgnoreCase(winHandleBefore))
				 {
					 driver.switchTo().window(S);
					 log.info("Switch to Child Window");
						
				 }
			 }
		 
	 }
	 
	 public void switchtoparentwindow()
	 {
		 for(String S:driver.getWindowHandles())
		 {
			 if(!S.equalsIgnoreCase(winHandleBefore))
			 {
				 driver.switchTo().window(S).close();
				 
				 WaitforPageLoad();
					
			 }
		 }
		 
		 driver.switchTo().window(winHandleBefore);
	 }
	 
}
