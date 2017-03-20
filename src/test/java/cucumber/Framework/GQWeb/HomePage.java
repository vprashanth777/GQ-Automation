package cucumber.Framework.GQWeb;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.Framework.CommanStepDefinations.BrokenLinks;
import cucumber.Framework.CommanStepDefinations.Initialization;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePage extends Initialization {

	@FindBy(xpath = "//form[@id='frmsearch2']/input")
	WebElement SearchforQual;

	@FindBy(xpath = "//a[@href='tel:133-775']")
	WebElement Phone;

	@FindBy(xpath = "//div[@class='desktop-view']//i")
	WebElement Burger_icon;	

	
	//updated xpath 
	@FindBy(xpath = "//div[@id='operator_avatar']")
	WebElement ChatBubble_icon;

	@FindBy(xpath = ".//*[@id='LP_ChatViewController_1']//textarea")
	WebElement Chat_txtfield;

	@FindBy(xpath = "//button[@title='Send']")
	WebElement ChatSend_btn;

	@FindBy(xpath = ".//*[@id='lp_line_2']//span")
	WebElement ChatMessage_msg;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@When("^User click the Search icon$")
	public void user_click_the_Search_icon() throws Throwable {
		SearchforQual.click();
		SearchforQual.clear();

	}

	@When("^User search for ([^\"]*)$")
	public void user_search_for_Business(String arg1) throws Throwable {
		SearchforQual.sendKeys(arg1);
		log.info("User search for " +arg1);
	}

		@Then("^User GQ web menu is successfully opened$")
	public void user_GQ_web_menu_is_successfully_opened() throws Throwable {
		try {
			WD.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='overlay']//p[.='ABOUT GQA']")));
			log.info("User GQ web menu is successfully opened");
		}

		catch (Exception e) {
			log.error("click the Hamburger menu then the GQ web menu is not successfully opened");
			Assert.fail("click the Hamburger menu then the GQ web menu is not successfully opened");
		}
	}

	@When("^User click the phone$")
	public void user_click_the_phone() throws Throwable {

		if (!(driver instanceof HtmlUnitDriver)) {
			Phone.click();

		}

		else
			WD.until(ExpectedConditions.elementToBeClickable(Phone));
		
		log.info("User click the phone");
	}

	@When("^User click the \"([^\"]*)\" icon$")
	public void user_click_the_IconNName_icon(String IconName) throws Throwable {
		
		KeyWords.WaitforPageLoad();

		switch (IconName) {
		case "Burger":
			WD.until(ExpectedConditions.elementToBeClickable(Burger_icon));
			Burger_icon.click();
			log.info("User click the Burger icon");
			break;

		case "ChatBubble":
			WD.until(ExpectedConditions.elementToBeClickable(ChatBubble_icon));
			Thread.sleep(5000);
			ChatBubble_icon.click();
			log.info("User click the ChatBubble icon");
			break;

		default:
			break;

		}

	}

	@When("^User click the \"([^\"]*)\" link$")
	public void user_click_the_LinkName_link(String LinkName) throws Throwable {

		KeyWords.WaitforPageLoad();
		switch (LinkName) {
		case "Contact Us":
			KeyWords.ClickonObject(driver.findElements(By.xpath("//div[@class='footermenu']//a[text()='Contact Us']")));
			
			break;

		case "SiteMap":
			KeyWords.ClickonObject(driver.findElements(By.xpath("//div[@class='footermenu']//a[text()='SiteMap']")));
			
			break;

		case "TnC":
			KeyWords.ClickonObject(driver.findElements(By.xpath("//div[@class='footermenu']//a[text()='Terms and Conditions']")));
			break;

		case "Privacy":
			KeyWords.ClickonObject(driver.findElements(By.xpath("//div[@class='footermenu']//a[text()='Privacy Policy']")));
			
			break;

		case "Referral":
			KeyWords.ClickonObject(driver.findElements(By.xpath("//div[@class='footermenu']//a[text()='Referral Program']")));
			
			break;

		case "WorkingWithUs":
			KeyWords.ClickonObject(driver.findElements(By.xpath("//div[@class='footermenu']//a[text()='Working with us']")));
			break;

		case "RPL E-learning":
			KeyWords.ClickonObject(driver.findElements(By.xpath("//div[@class='footermenu']//a[text()='RPL E-learning']")));
			break;

		case "Promotions":
			KeyWords.ClickonObject(driver.findElements(By.xpath("//div[@class='footermenu']//a[text()='Promotions']")));
			break;

		case "Customer Testimonials":
			KeyWords.ClickonObject(driver.findElements(By.xpath("//div[@class='footermenu']//a[text()='Customer Testimonials']")));
			break;

		default:
			log.error("Link name is not matched with existing cases");
			break;
		}
		log.info("User click the "+LinkName+" link");
	}

	@When("^User populate the \"([^\"]*)\" field$")
	public void user_populate_the_FieldName_field(String FieldName) throws Throwable {

		KeyWords.WaitforPageLoad();
		switch (FieldName) {
		case "Chat":
			WD.until(ExpectedConditions.visibilityOf(Chat_txtfield));
			Chat_txtfield.sendKeys("Test is just a test");
			break;

		default:
			log.error("Feild name is not matched with existing cases");
			break;

		}
			log.info("User populate the "+FieldName+" field");
	}

	@When("^User click the \"([^\"]*)\" button$")
	public void user_click_the_ButtonName_button(String ButtonName) throws Throwable {

		KeyWords.WaitforPageLoad();
		switch (ButtonName) {
		case "ChatSend":
			WD.until(ExpectedConditions.elementToBeClickable(ChatSend_btn));
			ChatSend_btn.click();
			break;

		default:
			log.error("Button name is not matched with existing cases");
			break;

		}
		log.info("User click the "+ButtonName+" button");
	}

	@When("^User click the media footer ([^\"]*) icon$")
	public void user_click_the_media_footer_IconName_icon(String IconName) throws Throwable {

		KeyWords.WaitforPageLoad();
		switch (IconName) {
		case "Youtube":
			KeyWords.WaitforPageLoad();
			KeyWords.ClickonObject(driver.findElements(By.xpath("id('gq_footer')//i[contains(@class, 'youtube')]")));
			
			break;

		case "Facebook":
			KeyWords.WaitforPageLoad();
			KeyWords.ClickonObject(driver.findElements(By.xpath("id('gq_footer')//i[contains(@class, 'facebook')]")));
			break;

		case "Twitter":
			KeyWords.WaitforPageLoad();
			KeyWords.ClickonObject(driver.findElements(By.xpath("id('gq_footer')//i[contains(@class, 'twitter')]")));
			break;

		case "Linkedin":
			KeyWords.WaitforPageLoad();
			KeyWords.ClickonObject(driver.findElements(By.xpath("id('gq_footer')//i[contains(@class, 'linkedin')]")));
			break;

		case "Instagram":
			KeyWords.WaitforPageLoad();
			KeyWords.ClickonObject(driver.findElements(By.xpath("id('gq_footer')//i[contains(@class, 'instagram')]")));

		default:
			log.error("footer Icon name is not matched with existing cases");
			break;
		}
		
		log.info("User click the media footer "+IconName+" icon");
	}

	@When("^User click the media side ([^\"]*) icon$")
	public void user_click_the_media_side_IconName_icon(String IconName) throws Throwable {

		KeyWords.WaitforPageLoad();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		switch (IconName) {
		case "Facebook":
			KeyWords.WaitforPageLoad();
			je.executeScript("window.scrollTo(0, 700)",
					driver.findElement(By.xpath("//a[contains(@class,'facebook')]/span[@class='at-icon-wrapper']")));
			KeyWords.ClickonObject(driver.findElements(By.xpath("//a[contains(@class,'facebook')]/span[@class='at-icon-wrapper']")));
			break;

		case "Twitter":
			KeyWords.WaitforPageLoad();
			je.executeScript("window.scrollTo(0, 700)",
					driver.findElement(By.xpath("//a[contains(@class,'twitter')]/span[@class='at-icon-wrapper']")));
			KeyWords.ClickonObject(driver.findElements(By.xpath("//a[contains(@class,'twitter')]/span[@class='at-icon-wrapper']")));
			break;

		case "Linkedin":
			KeyWords.WaitforPageLoad();
			je.executeScript("window.scrollTo(0, 700)",
					driver.findElement(By.xpath("//a[contains(@class,'linkedin')]/span[@class='at-icon-wrapper']")));
			KeyWords.ClickonObject(driver.findElements(By.xpath("//a[contains(@class,'linkedin')]/span[@class='at-icon-wrapper']")));
			break;

		case "Mail":
			KeyWords.WaitforPageLoad();
			je.executeScript("window.scrollTo(0, 700)",
					driver.findElement(By.xpath("//a[contains(@class,'email')]/span[@class='at-icon-wrapper']")));
			KeyWords.ClickonObject(driver.findElements(By.xpath("//a[contains(@class,'email')]/span[@class='at-icon-wrapper']")));
			break;

		default:
			log.error("Side Icon name is not matched with existing cases");
			break;
		}
		log.info("User click the media side "+IconName+" icon");
	}

	
	@Then("^User successful send Chat message$")
	public void user_successful_send_Chat_message() throws Throwable {
		WD.until(ExpectedConditions.visibilityOf(ChatMessage_msg));
		log.info("Test is just a test,Acutal ::" +ChatMessage_msg.getText());
		Assert.assertEquals("Test is just a test", ChatMessage_msg.getText());

	}

	@Then("^User successfully redirected to media footer ([^\"]*) page$")
	public void user_successfuly_redirected_to_media_footer_MediaName_page(String MediaName) throws Throwable {
		log.info("User successfully redirected to media footer "+MediaName+"page");
		KeyWords.WaitforPageLoad();
		ArrayList<String> tabs = null;
		switch (MediaName) {
		case "Youtube":
			tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			log.info("https://www.youtube.com/user/GetQualifiedAust, Actual"+ driver.getCurrentUrl());
			Assert.assertEquals("https://www.youtube.com/user/GetQualifiedAust", driver.getCurrentUrl());

			break;

		case "Facebook":
			tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			log.info("https://www.facebook.com/GetQualifiedAUS,Actual"+ driver.getCurrentUrl());
			Assert.assertEquals("https://www.facebook.com/GetQualifiedAUS", driver.getCurrentUrl());

			break;

		case "Twitter":
			tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			log.info("https://twitter.com/getqualifiedaus,Actual"+ driver.getCurrentUrl());
			Assert.assertEquals("https://twitter.com/getqualifiedaus", driver.getCurrentUrl());

			break;

		case "Linkedin":
			tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			log.info("https://www.linkedin.com/company/get-qualified-australia,actual"+ driver.getCurrentUrl());
			Assert.assertEquals("https://www.linkedin.com/company/get-qualified-australia", driver.getCurrentUrl());

			break;

		case "Instagram":
			tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			log.info("https://www.instagram.com/getqualifiedaus/,actual "+ driver.getCurrentUrl());
			Assert.assertEquals("https://www.instagram.com/getqualifiedaus/", driver.getCurrentUrl());

			break;

		default:
			break;
		}

	}

	@Then("^User successfully redirected to media side ([^\"]*) page$")
	public void user_successfuly_redirected_to_media_side_MediaName_page(String MediaName) throws Throwable {

		Thread.sleep(5000);
		ArrayList<String> tabs = null;
		tabs = new ArrayList<String>(driver.getWindowHandles());
		String CurrentWindow = driver.getWindowHandle();
		switch (MediaName) {
		case "Facebook":
			driver.switchTo().window(tabs.get(1));
			Assert.assertEquals(true, driver.getCurrentUrl().contains("www.facebook.com/login"));
			driver.switchTo().window(CurrentWindow);
			break;

		case "Twitter":
			driver.switchTo().window(tabs.get(1));
			Assert.assertEquals(true, driver.getCurrentUrl().contains("twitter.com/intent/tweet"));
			driver.switchTo().window(CurrentWindow);
			break;

		case "Linkedin":
			driver.switchTo().window(tabs.get(1));
			Assert.assertEquals(true, driver.getCurrentUrl().contains("www.linkedin.com/uas/login"));
			driver.switchTo().window(CurrentWindow);
			break;

		case "Mail":
			driver.switchTo().window(tabs.get(1));
			Assert.assertEquals(true, driver.getCurrentUrl().contains("www.addthis.com/tellfriend_v2"));
			driver.switchTo().window(CurrentWindow);
			break;

		default:
			break;

		}
			log.info("User successfully redirected to media side " +MediaName+"Page");
	}
	
	@Then("^User successfully redirected to \"([^\"]*)\" page$")
	public void user_successfuly_redirected_to_PageName_page(String PageName) throws Throwable {

		KeyWords.WaitforPageLoad();
		//BrokenLinks Brokenlink = new BrokenLinks();
		switch (PageName) {
		case "SiteMap":
			Assert.assertEquals("https://www.gqaustralia.edu.au/site-map/", driver.getCurrentUrl());
			// Brokenlink.pageUrl = driver.getCurrentUrl();
			// Brokenlink.testBrokenLinks();

			break;

		case "TnC":
			Assert.assertEquals("https://www.gqaustralia.edu.au/terms-conditions/", driver.getCurrentUrl());
			// Brokenlink.pageUrl = driver.getCurrentUrl();
			// Brokenlink.testBrokenLinks();

			Assert.assertEquals(true,driver.findElement(By.xpath("//span[contains(text(),'RPL privacy & confidentiality policy & procedure')]")).isDisplayed());		
			Assert.assertEquals(true,driver.findElement(By.xpath("//span[contains(text(),'Recognition of current qualifications')]")).isDisplayed());		
			Assert.assertEquals(true,driver.findElement(By.xpath("//span[contains(text(),'RPL Gap training policy and procedure')]")).isDisplayed());
			Assert.assertEquals(true,driver.findElement(By.xpath("//span[contains(text(),'Plagiarism, copying, breach of intellectual property rights and trademark infringements')]")).isDisplayed());;
			Assert.assertEquals(true,driver.findElement(By.xpath("//span[contains(text(),'RPL extension policy and procedure')]")).isDisplayed());
			Assert.assertEquals(true,driver.findElement(By.xpath("//span[contains(text(),'Payment')]")).isDisplayed());
			Assert.assertEquals(true,driver.findElement(By.xpath("//span[contains(text(),'Refund policy')]")).isDisplayed());
			Assert.assertEquals(true,driver.findElement(By.xpath("//span[contains(text(),'RPL appeals policy and procedure')]")).isDisplayed());
			Assert.assertEquals(true,driver.findElement(By.xpath("//span[contains(text(),'Other key issues in Vocational education & training')]")).isDisplayed());
			Assert.assertEquals(true,driver.findElement(By.xpath("//span[contains(text(),'Statement of Advice')]")).isDisplayed());

			

			break;

		case "Privacy":
			Assert.assertEquals("https://www.gqaustralia.edu.au/privacy/", driver.getCurrentUrl());
			// Brokenlink.pageUrl = driver.getCurrentUrl();
			// Brokenlink.testBrokenLinks();
			
			Assert.assertEquals(true, driver.findElement(By.xpath("//span[contains(text(),'Privacy Statement')]")).isDisplayed());
			Assert.assertEquals(true,driver.findElement(By.xpath("//span[contains(text(),'Collection of your Personal Information')]")).isDisplayed());
			Assert.assertEquals(true,driver.findElement(By.xpath("//span[contains(text(),'Use of your Personal Information')]")).isDisplayed());
			Assert.assertEquals(true,driver.findElement(By.xpath("//span[contains(text(),'Use of Cookies')]")).isDisplayed());
			Assert.assertEquals(true,driver.findElement(By.xpath("//span[contains(text(),'Security of your Personal Information')]")).isDisplayed());
			Assert.assertEquals(true,driver.findElement(By.xpath("//span[contains(text(),'Changes to this Statement')]")).isDisplayed());
			Assert.assertEquals(true,driver.findElement(By.xpath("//span[contains(text(),'Contact Information')]")).isDisplayed());

			

			break;

		case "Referral":
			Assert.assertEquals("https://www.gqaustralia.edu.au/get-referral-income/", driver.getCurrentUrl());
			// Brokenlink.pageUrl = driver.getCurrentUrl();
			// Brokenlink.testBrokenLinks();

			break;

		case "WorkingWithUs":
			Assert.assertEquals("https://www.gqaustralia.edu.au/rto-partnering-enhance-your-rto/",
					driver.getCurrentUrl());
			// Brokenlink.pageUrl = driver.getCurrentUrl();
			// Brokenlink.testBrokenLinks();
			driver.findElement(By.xpath(".//*[@id='bannerBtn']")).click();

			/*
			 * TODO Validate that after the button above is click, the page is
			 * navigated to the middle To do that, below are the options: 1.
			 * Determinine scroll position has change 2. screen/image validation
			 * 3. TBD 4. TBD
			 */

			/*
			 * TODO Validate that video is playing To do that, below are the
			 * options: 1. TBD 2. TBD 3. TBD 4. TBD
			 */

			driver.findElement(By.xpath("//h3[contains(.,'Benefits for your RTO')]")).isDisplayed();
			driver.findElement(
					By.xpath("//p[contains(.,'Increase business revenues by providing and marketing RPL services')]"))
					.isDisplayed();
			driver.findElement(By.xpath("//p[contains(.,'Have your RTO marketed across the nation at no extra cost')]"))
					.isDisplayed();
			driver.findElement(
					By.xpath("//p[contains(.,'No cost for employing additional assessment staff to conduct RPL')]"))
					.isDisplayed();
			driver.findElement(By
					.xpath("//p[contains(.,'No cost for development of RPL kits and assessment resources as this is conducted by GQA')]"))
					.isDisplayed();

			Assert.assertEquals(true, driver.findElement(By.xpath(".//*[@id='footer-sidebar1']/div")).isDisplayed());

			driver.findElement(By.xpath(".//*[@id='firstname']")).sendKeys("septrpl");
			driver.findElement(By.xpath(".//*[@id='lastname']")).sendKeys("aussaaka");
			driver.findElement(By.xpath(".//*[@id='phone']")).sendKeys("456852951");
			driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("septrplaussaaka@gmail.com");
			driver.findElement(By.xpath(".//*[@id='rtoName']")).sendKeys("septrplaussaaka");
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='e-book_form']/div[4]/div/input")).click();
			//WD.until(ExpectedConditions.alertIsPresent()).accept();
			KeyWords.HandleAlert();			
	
			Thread.sleep(25000);
			ArrayList<String> tabs = null;
			tabs = new ArrayList<String>(driver.getWindowHandles());
			String CurrentWindow = driver.getWindowHandle();
			driver.switchTo().window(tabs.get(1));
			Assert.assertEquals(true, driver.getCurrentUrl().contains("10-steps-partnering.pdf"));
			driver.switchTo().window(CurrentWindow);

			break;

		case "RPL E-learning":
			Assert.assertEquals("https://www.gqaustralia.edu.au/e-learning/", driver.getCurrentUrl());
			// Brokenlink.pageUrl = driver.getCurrentUrl();
			// Brokenlink.testBrokenLinks();
			Assert.assertEquals(
					"About E-learning\n"
							+ "Accessible 24/7, our easy-to-use e-Learning platform is exactly what you need to complete"
							+ " a unit or selection of qualification units online, and at your own pace. From online"
							+ " assessments to quality gap training, our Facilitators are there to offer guidance and"
							+ " support at every stage of the e-Learning process.",
					driver.findElement(By.xpath("//div[@class='topsection']//div[contains(@class, 'col')]")).getText());

			driver.findElement(By.xpath("//span[contains(text(),'E-Learning - online short courses in Australia')]")).click();
			Thread.sleep(3000);
			Assert.assertEquals(
					"E-Learning - online short courses in Australia\n"
							+ "Get Qualified Australia�s easy-to-use e-Learning portal can be used to complete individual units, or a selection of units across a wide range of industries.\n"
							+ "The system is administered by the RTO (Registered Training Organisation) who will issue the Nationally Recognised Qualification upon successful completion of the course.\n"
							+ "One of the most important factors of our e-Learning portal is that it can be accessed 24/7, which means you can complete your training and respective assessments at your own pace in your own time.\n"
							+ "This web-based system includes interactive resources which are logical, easy to follow and fun to use.",
					driver.findElement(By.xpath(".//*[@id='accordion60']/div[1]")).getText());

			driver.findElement(By.xpath("//span[contains(text(),'e-Learning with RPL')]")).click();
			Thread.sleep(3000);
			Assert.assertEquals(
					"e-Learning with RPL\n"
							+ "Your Get Qualified Skills Facilitator will use your free skills review to determine if you can receive credits towards the Nationally Recognised Qualification.\n"
							+ "Once the process is completed, you will be advised on any suitable Gap Training you may need to undertake, which is usually conducted online through our e-Learning portal.",
					driver.findElement(By.xpath(".//*[@id='accordion60']/div[2]")).getText());

			driver.findElement(By.xpath("//span[contains(text(),'e-Learning Assessments')]")).click();
			Thread.sleep(3000);
			Assert.assertEquals(
					"e-Learning Assessments\n"
							+ "You may have to complete anything from multiple choice, short answer and/or true or false questions, assignments, projects and reports.\n"
							+ "While you are e-Learning, you can complete the assessments when you are ready and at your own pace.\n"
							+ "Once submitted, your assessments will be reviewed by Get Qualified Australia's Industry Assessors. If you achieve full competency, you can immediately move onto the next unit. If you are deemed not yet competent, you will receive detailed feedback to help you develop your knowledge, and you�ll be able to complete the assessments again at your convenience.",
					driver.findElement(By.xpath(".//*[@id='accordion60']/div[3]")).getText());

			driver.findElement(By.xpath("//span[contains(text(),'e-Learning Support')]")).click();
			Thread.sleep(3000);
			Assert.assertEquals(
					"e-Learning Support\n"
							+ "Our facilitators will provide you with full support and guidance at every stage of the e-Learning process. During office hours, we have a dedicated e-Learning Coordinator on hand to answer any questions directly via phone or email.",
					driver.findElement(By.xpath(".//*[@id='accordion60']/div[4]")).getText());

			Assert.assertEquals(true, driver.findElement(By.xpath(".//*[@id='footer-sidebar1']/div")).isDisplayed());

			break;

		case "Contact Us":
			Assert.assertEquals("https://www.gqaustralia.edu.au/get-in-touch/", driver.getCurrentUrl());
			// Brokenlink.pageUrl = driver.getCurrentUrl();
			// Brokenlink.testBrokenLinks();
			Assert.assertEquals(true, driver.findElement(By.xpath("//h1[contains(.,'Get in touch')]")).isDisplayed());
			Assert.assertEquals(true, driver.findElement(By.id("fname")).isDisplayed());
			Assert.assertEquals(true, driver.findElement(By.id("lname")).isDisplayed());
			Assert.assertEquals(true, driver.findElement(By.id("mobile")).isDisplayed());
			Assert.assertEquals(true, driver.findElement(By.id("email")).isDisplayed());
			Assert.assertEquals(true, driver.findElement(By.id("aboutgq")).isDisplayed());

			Assert.assertEquals(true, driver.findElement(By.xpath(".//*[@id='footer-sidebar1']/div")).isDisplayed());

			break;

		case "Promotions":
			Assert.assertEquals("https://www.gqaustralia.edu.au/promotions/", driver.getCurrentUrl());
			// Brokenlink.pageUrl = driver.getCurrentUrl();
			// Brokenlink.testBrokenLinks();
			//System.out.println(driver.findElement(By.xpath("//div[@class='offers']/div[1]")).getText());
			
			String Validation="Give your career that head start in 2017\n" +"Save 40%\n"+
					"Enrol in our RPL and Skills Recognition Services until 31st January 2017 and get a 40% discount for upfront payments. Yes, that's 40% off your targeted industry qualification! Go ahead and open doors for a better future in 2017 with the qualification your skills deserve.\n"
					+"Call us today to learn more about saving 40% with your enrolment.\n"
					+"Claim your discount";
			
			//System.out.println(Validation);
			Assert.assertEquals(Validation,
					driver.findElement(By.xpath("//div[@class='offers']/div[1]")).getText());

			Assert.assertEquals("Interest-free payment plan\n" + "Save 10%\n" + "(Save up to $650)\n"
					+ "Sign-up for a payment plan and receive 10% off your qualification.\n"
					+ "Can�t pay for your qualification up front and in full? No worries. Choose a payment plan that is best suited to your situational needs, and receive 10% off the cost of your qualification when you enrol.\n"
					+ "Call us today to learn more about saving 10% with your enrolment.\n" + "FREE SKILLS REVIEW",
					driver.findElement(By.xpath("//div[@class='offers']/div[2]")).getText());

			Assert.assertEquals("Get started with a $150 deposit\n" + "Enrol Today\n"
					+ "We want to make it as easy as possible for you to take that first step. Enrol today for as little as $150 and pay off the rest of the qualification through a flexible, interest-free plan, either on a weekly or fortnightly basis.\n"
					+ "Call us today to learn more about getting started with a $150 deposit.\n" + "FREE SKILLS REVIEW",
					driver.findElement(By.xpath("//div[@class='offers']/div[3]")).getText());

			Assert.assertEquals(true, driver.findElement(By.xpath(".//*[@id='footer-sidebar1']/div")).isDisplayed());

			break;

		case "Customer Testimonials":
			Assert.assertEquals("https://www.gqaustralia.edu.au/testimonials/", driver.getCurrentUrl());
			// Brokenlink.pageUrl = driver.getCurrentUrl();
			// Brokenlink.testBrokenLinks();
			Assert.assertEquals(
					"Thank you for all your support. I found the experience very positive and would certainly recommend "
							+ "you guys as my first choice for anyone who is wanting recognition in a trade or skill. The person "
							+ "who was looking after me was called Scott Raper.His service was outstanding. I found him polite "
							+ "and very keen to help. I was constantly kept up to date with every step of the way. Now I have a "
							+ "Certificate III in carpentry. Thank you to all the rest of the team. I have no doubt that every "
							+ "one here at get qualified Australia has the same high standard as Scott.",
					driver.findElement(By.xpath("//div[@class='col-sm-8']/p[1]")).getText());

			Assert.assertEquals(
					"I wish to acknowledge and thank Mr. Martin O'Sullivan who was my RPL facilitator for securing my "
							+ "RPL evaluation within a short time. He was specific with his request . He would also entertain my "
							+ "suggestion and accept what was logical. He was always available when I needed to talk to him. It "
							+ "was great to work with him-Thanks Martin, appreciate all your help",
					driver.findElement(By.xpath("//div[@class='col-sm-8']/p[11]")).getText());

			Assert.assertEquals(true, driver.findElement(By.xpath(".//*[@id='footer-sidebar1']/div")).isDisplayed());
			break;

		default:
			break;
		}
		log.info("User successfully redirected to "+PageName+" page");
	}
	
	

}
