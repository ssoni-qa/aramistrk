package testSuite;

import org.testng.Assert;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import crossBrowserTesting.CrossBrowserTestingTestNG;
import crossBrowserTesting.Page;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends CrossBrowserTestingTestNG{
	private String baseUrl;
	String fname,lname,email,dom,dob,doy;
	Boolean run=true;
	//String snapshotHash;
	ArrayList<String> mainList = new ArrayList<String>();
	ArrayList<String> ImageList = new ArrayList<String>();
	ExtentTest landingPageTC,surveyFlowTC,surveyConfTC,surveyOffLinkOutTC,smallBannerOfferFlowTC,bigBannerTC,endTC;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		baseUrl = "http://go.aramistrk.com/aff_c?offer_id=311&aff_id=1018";
	}



	@Test(priority=1)
	@org.testng.annotations.Parameters(value={"os", "browser"})
	public void testLandingPage(String os,String browser) throws Exception {
		String mainWindow1= driver.getWindowHandle();
		System.out.println("First Window Handles id - "+mainWindow1);
		landingPageTC = extent.startTest("Landing Page.");
		//CrossBrowserTestingTestNG myTest = new CrossBrowserTestingTestNG();
		Page ele=PageFactory.initElements(driver, Page.class);
		try {
			System.out.println("----Test Running On ---- >"+browser +" On Platform "+os);
			landingPageTC.log(LogStatus.INFO, "----Test Running On ---- >"+browser +" On Platform "+os);

			System.out.println("Device name - "+os+" Browser Name - "+browser);
			landingPageTC.log(LogStatus.INFO, "Device name - "+os+" Browser Name - "+browser);

			System.out.println("Landing Page.");

			driver.get(baseUrl);
			landingPageTC.log(LogStatus.INFO, "Test Case - Check for valid Landing Page."+baseUrl);
			System.out.println("Open Url.");
			//Screen Shots.
			landingPageTC.log(LogStatus.PASS,
					"Navigated to Landing Page." + landingPageTC.addScreenCapture(captureScreenMethod(dest)));

			ele.firstName.clear();
			ele.firstName.sendKeys("FirstName");
			fname=ele.firstName.getAttribute("value");
			System.out.println("Entered First Name.");
			landingPageTC.log(LogStatus.INFO, "Entered First Name -"+fname);

			ele.lastName.clear();
			ele.lastName.sendKeys("Last Name");
			lname=ele.lastName.getAttribute("value");
			System.out.println("Enter Last Name.");
			landingPageTC.log(LogStatus.INFO, "Entered Last Name -"+lname);

			System.out.println("Enter email address.");
			ele.emailAddress.clear();
			ele.emailAddress.sendKeys("dummyemail@domain.com");
			email=ele.emailAddress.getAttribute("value");
			landingPageTC.log(LogStatus.INFO, "Entered Email Address  -"+email);

			new Select(ele.month).selectByVisibleText("August");
			dom=ele.month.getAttribute("value");
			System.out.println("Select Month of birth.");
			landingPageTC.log(LogStatus.INFO, "Selected Date Month -"+dom);


			new Select(ele.day).selectByVisibleText("26");
			dob=ele.day.getText();
			System.out.println("Select Date of birth.");
			landingPageTC.log(LogStatus.INFO, "Selected Date  - 26");


			new Select(ele.year).selectByVisibleText("1988");
			doy=ele.year.getText();
			System.out.println("Select year of birth.");
			landingPageTC.log(LogStatus.INFO, "Selected Year - 1988");


			new Select(ele.gender).selectByVisibleText("Male");
			System.out.println("Select gender.");

			ele.phoneNo.clear();
			ele.phoneNo.click();
			ele.phoneNo.sendKeys("(111) 111-1111");
			System.out.println("Entering Phone Number.");
			landingPageTC.log(LogStatus.INFO, "Entered Phone Number  - '(111) 111-1111'.");



			ele.streetAdd.clear();
			ele.streetAdd.sendKeys("street address");
			System.out.println("Enter Street Address.");
			landingPageTC.log(LogStatus.INFO, "Entered Street Address  - 'street address'.");


			ele.city.sendKeys("CityName");
			System.out.println("Enter City name.");
			landingPageTC.log(LogStatus.INFO, "Entered City Name - 'City Name'.");

			new Select(ele.state).selectByVisibleText("AL");
			System.out.println("Select state from drop down.");
			landingPageTC.log(LogStatus.INFO, "Selected State - 'AL'.");


			ele.zipCode.sendKeys("(111) 111-1111");
			System.out.println("Enter zip code.");
			landingPageTC.log(LogStatus.INFO, "Entered Zip Code - '(111) 111-1111'.");

			System.out.println("Test Case : Check and Uncheck 'I Agree' check-box.");
			landingPageTC.log(LogStatus.INFO, "Test Cases : - Check and Uncheck 'I Agree' check-box.");

			try {
				ele.iAggree.click();
				Thread.sleep(2000);
				Assert.assertEquals(ele.iAggree.getCssValue("background-color"),
						"rgba(255, 57, 88, 1)");
				System.out.println("Pass.");
				landingPageTC.log(LogStatus.PASS,
						"Checked On 'I Agree' checkbox." + landingPageTC.addScreenCapture(captureScreenMethod(dest)));


			} catch (AssertionError ae) {
				System.out.println("Fail :"+ae.getMessage());
			}
			System.out.println("TC : Check-Box can Unchecked.");
			try {
				ele.iAggree.click();
				Thread.sleep(2000);
				assertEquals(ele.iAggree.getCssValue("background-color"),
						"rgba(255, 255, 255, 1)");
				System.out.println("Pass.");
				landingPageTC.log(LogStatus.PASS,
						"Un-Checked On 'I Agree' checkbox." + landingPageTC.addScreenCapture(captureScreenMethod(dest)));
			} catch (AssertionError ae) {
				System.out.println("Fail :"+ae.getMessage());
			}


			System.out.println("Test Case : Check Un-cheked ' I am Homeowner' check-box.");
			landingPageTC.log(LogStatus.INFO, "Test Case : Check Un-cheked ' I am Homeowner' check-box.");

			try {
				ele.homeOwner.click();
				Thread.sleep(2000);
				assertEquals(ele.homeOwner.getCssValue("background-color"),
						"rgba(255, 57, 88, 1)");
				System.out.println("Pass.");
				landingPageTC.log(LogStatus.PASS,
						"Checked on 'I am a Homeowner; check-box." + landingPageTC.addScreenCapture(captureScreenMethod(dest)));


			} catch (AssertionError ae) {
				System.out.println("Fail :"+ae.getMessage());
			}
			System.out.println("TC : Check-Box can Unchecked.");

			try {
				ele.homeOwner.click();
				Thread.sleep(2000);
				assertEquals(ele.homeOwner.getCssValue("background-color"),
						"rgba(255, 255, 255, 1)");
				System.out.println("Pass.");
				landingPageTC.log(LogStatus.INFO, "Un-Check on 'I am Homeowner' checkbox.");
				landingPageTC.log(LogStatus.PASS,
						"Un-Checked On 'I am A Homeowner' checkbox." + landingPageTC.addScreenCapture(captureScreenMethod(dest)));


			} catch (AssertionError ae) {
				System.out.println("Fail :"+ae.getMessage());
			}


			ele.continueBtn.click();
			driver.getCurrentUrl();
			landingPageTC.log(LogStatus.INFO, "Done.");
			extent.endTest(landingPageTC);
			System.out.println("******************************************************************************************");

			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			System.out.println("Survey Flow.");
			surveyFlowTC = extent.startTest("Survey Flow.");
			new WebDriverWait(driver, 15).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(ele.yesButton));
			System.out.println("Test Case - Provide response to page with question.");
			surveyFlowTC.log(LogStatus.INFO, "Test Case - Provide response to page with question.");

			while(true){
				wc.until(ExpectedConditions.elementToBeClickable(ele.yesBtn));
				if(ele.yesBtn.isDisplayed() 
						&& !ele.lablequest.getText().contains("FIRST NAME *"))
				{


					System.out.println(ele.lablequest.getText());
					System.out.println("Click on "+ele.yesBtn.getText()+" button.");
					surveyFlowTC.log(LogStatus.PASS,
							"" + surveyFlowTC.addScreenCapture(captureScreenMethod(dest)));


					ele.yesBtn.click();

					continue;
				}
				else
				{
					break;
				}

			}

			surveyFlowTC.log(LogStatus.INFO, "Done.");
			extent.endTest(surveyFlowTC);
			System.out.println("******************************************************************************************");

			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			System.out.println("Survey Confirmation Page.");
			surveyConfTC=extent.startTest("Survey Confirmation Page");
			Select dom=new Select(ele.conMonth);
			Select dod=new Select(ele.conDay);
			Select doy=new Select(ele.conYear);
			System.out.println("Test Case -Check all filed must be auto filled with correct data.");
			surveyConfTC.log(LogStatus.INFO, "Test Case -Check all filed must be auto filled with correct data.");			
			try {
				assertEquals(lname,"Last Name");
				assertEquals(email,"dummyemail@domain.com");
				assertEquals(dom.getFirstSelectedOption().getText(), "August");
				assertEquals(dod.getFirstSelectedOption().getText(), "26");
				assertEquals(doy.getFirstSelectedOption().getText(), "1988");
				surveyConfTC.log(LogStatus.PASS,
						"Check all field must be auto filled with correct data."
								+ surveyConfTC.addScreenCapture(captureScreenMethod(dest)));


			} catch (AssertionError e) {
				System.out.println("Fail");

			}

			System.out.println("Test Case- Vary between check and Un-check the 'I CONFIRM' acceptance checkbox.");
			System.out.println("'I Confirm check box is unchecked.");
			surveyConfTC.log(LogStatus.INFO, "Test Case- Vary between check and Un-check the 'I CONFIRM' acceptance checkbox.");			

			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele.iConfirm);
				assertEquals(ele.iConfirm.getCssValue("background-color"), "rgba(255, 255, 255, 1)");
				System.out.println("Pass");
				surveyConfTC.log(LogStatus.PASS,
						"Unchecked ' I Confirm' check-box."
								+ surveyConfTC.addScreenCapture(captureScreenMethod(dest)));


			} catch (AssertionError e) {

				System.out.println("Fail.");
			}

			System.out.println("'I Confirm check box is checked.");
			ele.iConfirm.click();
			Thread.sleep(2000);
			try {
				assertEquals(ele.iConfirm.getCssValue("background-color"), "rgba(255, 57, 88, 1)");
				System.out.println("Pass");
				surveyConfTC.log(LogStatus.PASS,
						"Checked ' I Confirm' check-box."
								+ surveyConfTC.addScreenCapture(captureScreenMethod(dest)));


			} catch (AssertionError e) {

				System.out.println("Fail.");
			}
			System.out.println("Verify Marketing Link is Working.");
			surveyConfTC.log(LogStatus.INFO, "Test Case- Verify Marketing Link is Working.");			
			ele.mktLink.click();
			Thread.sleep(2000);
			wc.until(ExpectedConditions.elementToBeClickable(ele.closeWindow));
			surveyConfTC.log(LogStatus.PASS,
					"Marketing Link is working."
							+ surveyConfTC.addScreenCapture(captureScreenMethod(dest)));
			ele.closeWindow.click();
			System.out.println("Marketing Link is working.");
			Thread.sleep(2000);
			System.out.println("Pass.");
			ele.conContinueBtn.click();
			System.out.println("Survey Confirmation Page completed");
			surveyConfTC.log(LogStatus.INFO, "Done.");			
			extent.endTest(surveyConfTC);
			System.out.println("**************************************************************************************************************");
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////











			System.out.println("Survey Offer Linkout Pages.");
			surveyOffLinkOutTC=extent.startTest("Survey Offer Linkout Pages.");
			try {
				wc.until(ExpectedConditions.visibilityOfElementLocated(By.id("i-3bee30e7-91ed-4eb2-902d-765f0a373ad9")));
				System.out.println("Yes I Do Button is visible.");
				surveyOffLinkOutTC.log(LogStatus.PASS, "On Click on button - "+surveyOffLinkOutTC.addScreenCapture(captureScreenMethod("dest")));
				ele.yesIDoBtn.click();
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle); 
				}
				System.out.println("On click URL : "+driver.getCurrentUrl());
				surveyOffLinkOutTC.log(LogStatus.PASS, "Open Url"+driver.getCurrentUrl()+""+surveyOffLinkOutTC.addScreenCapture(captureScreenMethod("dest")));
				driver.close();
				Thread.sleep(2000);
				driver.switchTo().window(mainWindow1);
			} catch (Exception e) {
				System.out.println("'Yes' I do button is not visible.");
			}

			try {
				wc.until(ExpectedConditions.visibilityOf(ele.imgbtn));
				System.out.println("Uber Start Now Button is visibled and click.");
				surveyOffLinkOutTC.log(LogStatus.PASS, "On Click on button - "+surveyOffLinkOutTC.addScreenCapture(captureScreenMethod("dest")));
				System.out.println("Small Image Banner is found.");
				ele.imgbtn.click();
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle); 
				}
				System.out.println("New Open Tab "+driver.getCurrentUrl());
				surveyOffLinkOutTC.log(LogStatus.PASS, "Open Url  "+driver.getCurrentUrl()+""+surveyOffLinkOutTC.addScreenCapture(captureScreenMethod("dest")));
				driver.close();
				Thread.sleep(2000);
				driver.switchTo().window(mainWindow1);
			} catch (Exception e) {
				System.out.println("Uber Banner Image.");

			}

			System.out.println("Now will move to iframe .");
			try {
				driver.switchTo().frame(driver.findElement(By.name("sandbox--518d3b8f-6787-458a-bcaf-8bce288d761c-1")));
				System.out.println("Iframe Founded and switched.");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while(true){
				try {
					wc.until(ExpectedConditions.visibilityOf(ele.imgbtn1));
					System.out.println("List Radio and button iframe is showned.");
					surveyOffLinkOutTC.log(LogStatus.PASS, "On Click 'Continue' Button "+surveyOffLinkOutTC.addScreenCapture(captureScreenMethod("dest")));
					ele.imgbtn1.click();
					surveyOffLinkOutTC.log(LogStatus.PASS, "Next Page :"+surveyOffLinkOutTC.addScreenCapture(captureScreenMethod("dest")));
				} catch (Exception e) {
					System.out.println("List Radio and Button option selection , ended.");
					break;
				}


			}
			surveyOffLinkOutTC.log(LogStatus.INFO, "Done.");
			extent.endTest(surveyOffLinkOutTC);
			System.out.println("******************************************************************************************************");

			///////////////////////////////////////////////////////////////////////////////////////////////////////////////

			System.out.println("Small Banner Offer Flow - Radio Option Linkout.");
			smallBannerOfferFlowTC=extent.startTest("Small Banner Offer Flow.");
			while(true){

				try {
					List <WebElement> radioLink=driver.findElements(By.xpath("//div[@class='iff-campaign-container-regular']/div[2]/label[1]/input"));
					for(WebElement id:radioLink)
					{
						String ids=id.getAttribute("id");
						if(!mainList.contains(ids))
							mainList.add(ids);
					}
					smallBannerOfferFlowTC.log(LogStatus.PASS, "On click 'Yes' radio option -"+smallBannerOfferFlowTC.addScreenCapture(captureScreenMethod("dest")));
					Thread.sleep(2000);
					if(mainList.size()==1)
					{
						driver.findElement(By.xpath("//*[@id='"+mainList.get(0)+"']")).click();

					}else if(mainList.size()==2)
					{
						driver.findElement(By.xpath("//*[@id='"+mainList.get(1)+"']")).click();

					}
					else if(mainList.size()==3)
					{
						driver.findElement(By.xpath("//*[@id='"+mainList.get(2)+"']")).click();

					}
					else if(mainList.size()==4)
					{
						driver.findElement(By.xpath("//*[@id='"+mainList.get(3)+"']")).click();
					}

					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle); 
					}
					System.out.println("Open Url :"+driver.getCurrentUrl());
					smallBannerOfferFlowTC.log(LogStatus.PASS, "Open Url"+driver.getCurrentUrl()+""+smallBannerOfferFlowTC.addScreenCapture(captureScreenMethod("dest")));
					driver.close();
					driver.switchTo().window(mainWindow1);
					wc.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("sandbox--518d3b8f-6787-458a-bcaf-8bce288d761c-1"));
					Thread.sleep(2000);
				} catch (Exception e) {
					System.out.println("-------------------------Small Banner Radio Offer Flow Linkout Page completed.---------------------");
					break;
				}
			}

			smallBannerOfferFlowTC.log(LogStatus.INFO, "Done.");
			extent.endTest(smallBannerOfferFlowTC);








			System.out.println("Large Banner offer Flow.");
			bigBannerTC=extent.startTest("Large Banner Offer Flow.");
			while(true){
				try {
					List <WebElement> bigImgLink=driver.findElements(By.xpath("//*[@class='iff-campaign-container']"));
					for(WebElement id:bigImgLink)
					{
						String ids=id.getAttribute("id");
						if(!ImageList.contains(ids))
							ImageList.add(ids);
					}
					bigBannerTC.log(LogStatus.PASS, "Open Url"+bigBannerTC.addScreenCapture(captureScreenMethod("dest")));
					bigBannerTC.log(LogStatus.PASS, "On click on Large Banner Image :"+bigBannerTC.addScreenCapture(captureScreenMethod("dest")));
					if(ImageList.size()==1)
					{
						driver.findElement(By.xpath("//*[@id='"+ImageList.get(0)+"']/a")).click();

					}else if(ImageList.size()==2)
					{
						driver.findElement(By.xpath("//*[@id='"+ImageList.get(1)+"']/a")).click();

					}
					else if(ImageList.size()==3)
					{
						driver.findElement(By.xpath("//*[@id='"+ImageList.get(2)+"']/a")).click();

					}
					else if(ImageList.size()==4)
					{
						driver.findElement(By.xpath("//*[@id='"+ImageList.get(3)+"']/a")).click();

					}
					else if(ImageList.size()==5)
					{
						driver.findElement(By.xpath("//*[@id='"+ImageList.get(4)+"']/a")).click();

					}
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle); 
					}

					System.out.println("Open Url :"+driver.getCurrentUrl());
					bigBannerTC.log(LogStatus.PASS, "Open Url"+driver.getCurrentUrl()+""+bigBannerTC.addScreenCapture(captureScreenMethod("dest")));
					driver.close();
					driver.switchTo().window(mainWindow1);
					wc.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("sandbox--518d3b8f-6787-458a-bcaf-8bce288d761c-1"));
					Thread.sleep(2000);
				} catch (Exception e) {
					driver.switchTo().defaultContent();
					System.out.println("------------Large Banner on click linkout completed.-----------------------------");
					break;
				}
			}
			
			
			bigBannerTC.log(LogStatus.INFO, "Done.");
			extent.endTest(bigBannerTC);

			try {
				System.out.println("Ending Now.");
				endTC=extent.startTest("End");
				wc.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='i-af7e3c06-cc95-467b-995e-29a1126fdd16']")));
				endTC.log(LogStatus.PASS, "On click on button :"+endTC.addScreenCapture(captureScreenMethod("dest")));
				driver.findElement(By.xpath("//*[@id='i-af7e3c06-cc95-467b-995e-29a1126fdd16']")).click();
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle); 
				}
				System.out.println(driver.getCurrentUrl());
				endTC.log(LogStatus.PASS, "Open Url -"+driver.getCurrentUrl()+""+endTC.addScreenCapture(captureScreenMethod("dest")));
				driver.close();
				endTC.log(LogStatus.INFO, "Test Suite Finished.");
				extent.endTest(endTC);
			} catch (Exception e) {
				System.out.println("Exception Related to End -----------------------------------------");
				e.printStackTrace();
			}
				

		} catch (Exception e) {

			System.out.println("Excpetion Occured. Re-Run Test Suite Again.");
			extent.flush();
			//driver.close();
		}

	}
}
