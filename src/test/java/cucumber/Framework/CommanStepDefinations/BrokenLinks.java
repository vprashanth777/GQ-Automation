package cucumber.Framework.CommanStepDefinations;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.net.ssl.SSLException;

import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




 
public class BrokenLinks extends Initialization{
  
String pageUrl;
String logger;
public ExtentReports extent;
public ExtentTest test ;
public void testBrokenLinks(String URL) throws IOException, InterruptedException {
	 pageUrl=URL;
	 
	

	//System.out.println(Title);
	 log.info("Broken Link Validation started for URl ::"+URL);
	 
	  Document page = getPage(pageUrl);
	  
		Date date = new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		String timeStamp = sdf.format(date);
		
		System.out.println(timeStamp.replaceAll("[^\\w]", "_"));
	  //System.out.println(page.select("title").text().substring(0, 15).replace(" ", ""));
	  extent = new ExtentReports("target/BL_Valid_"+timeStamp.replaceAll("[^\\w]", "_")+".html", true);
	  test = extent.startTest("BrokenLinkValidation("+URL+")", URL);

	
	
     
     

  for (Element link : getLinksFromPage(page)) {
	  logger=null;
    String url = getHrefValueFromLink(link);
    if (isUrlValid(url))
    {
    	System.out.println("URL link:" +url);
    	int Responsecode=getPageResponseCode(url);
    	logger=logger+"  [ "+url+"("+Responsecode+")"+"]";
    	if(Responsecode<400)
    	{
    		//System.out.println("URL link Resopnse Code:200");
    		
    		 test.log(LogStatus.PASS,logger);
    		 log.info(logger);
    	}
    	
    	else
    	{
    	//logger=logger+"::"+url+"("+Responsecode+")";
   		 test.log(LogStatus.FAIL,logger);
   		 log.warn(logger);
    
    	}
    
      // assertTrue(getPageResponseCode(url) < 400);
    }
  }
  
  extent.endTest(test);
  extent.flush();
}
 
// connects to url, gets the document
 Document getPage(String url) throws IOException
{
  return Jsoup.connect(pageUrl).get();
}
 
// gets A elements from page, returns them Elements collection
 Elements getLinksFromPage(Document page)
{
  return page.select("a");
}
 Elements getscriptsFromPage(Document page)
{
  return page.select("script");
}
// extracts the href attribute from an element
 String getHrefValueFromLink(Element link)
{
//	System.out.println(link.text());
	logger="LinkText:: " +link.text();
	//System.out.println(link.attr("href"));
	//System.out.println(link.absUrl("href"));
	if(link.text().length()>0)
	{
  return link.absUrl("href");
	}
	
	else
		return "NotaLink";
}
 
// checks if the url includes http
 Boolean isUrlValid(String href)
{
  return href.indexOf("http") >= 0;
}
 
/*
  returns the page response code by
  1. creating an httpConnection
  2. connecting to the connection
  3. getting the response code for the connection
*/
 int getPageResponseCode(String url) throws IOException
{
  int responseCode = 500;
  try {
   HttpURLConnection httpConnection = createHttpConnection(url);
   httpConnection.setConnectTimeout(60000);
   httpConnection.connect();
   responseCode = httpConnection.getResponseCode();
  }
  catch (ProtocolException | SSLException exception) {
   System.out.println("could not open " + url);
   log.info("could not open " + url);
  }
  
  catch(Exception e)
  {
	  
  }
  return responseCode;
}
 
// create the httpConnection object
 HttpURLConnection createHttpConnection(String href) throws IOException
{
  URL url = new URL(href);
  HttpURLConnection huc = (HttpURLConnection)url.openConnection();
  huc.setRequestMethod("GET");
  return huc;
}
}