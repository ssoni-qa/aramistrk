package testSuite;

import org.testng.Assert;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import crossBrowserTesting.BrowserStackTestNGTest;
import crossBrowserTesting.CrossBrowserTestingTestNG;
import crossBrowserTesting.Page;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BrowserStackTestNGTest{
	private String baseUrl;
	String fname,lname,email,dom,dob,doy;
	Boolean run=true;
	//String snapshotHash;
	ArrayList<String> mainList = new ArrayList<String>();
	ArrayList<String> ImageList = new ArrayList<String>();
	ExtentTest landingPageTC;



	@Test
	public void testLandingPage() throws WebDriverException, IOException, InterruptedException {

		String mainWindow1= driver.getWindowHandle();
		System.out.println("First Window Handles id - "+mainWindow1);
		landingPageTC = extent.startTest("Test Suite");
		//CrossBrowserTestingTestNG myTest = new CrossBrowserTestingTestNG();
		Page ele=PageFactory.initElements(driver, Page.class);
		//Open Url
		driver.get("http://go.aramistrk.com/aff_c?offer_id=311&aff_id=1018");
		landingPageTC.log(LogStatus.INFO, "Test Case - Check for valid Landing Page."+baseUrl);
		landingPageTC.log(LogStatus.INFO, "Open URL-"+baseUrl);
		System.out.println("Open Url.");
		//Screen Shots.
		landingPageTC.log(LogStatus.PASS,
				"Navigated to Landing Page." + landingPageTC.addScreenCapture(captureScreenMethod(dest)));

		try {
			System.out.println("Landing Page Opened.");
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
				landingPageTC.log(LogStatus.PASS,
						"Un-Checked On 'I am A Homeowner' checkbox." + landingPageTC.addScreenCapture(captureScreenMethod(dest)));


			} catch (AssertionError ae) {
				System.out.println("Fail :"+ae.getMessage());
			}

			ele.continueBtn.click();		
			landingPageTC.log(LogStatus.PASS,
					"On Click on 'SEND ME SAMPLES' button." + landingPageTC.addScreenCapture(captureScreenMethod(dest)));
			landingPageTC.log(LogStatus.INFO, "Done.");
			System.out.println("Done.");
		} catch (Exception e2) {
			// TODO Auto-generated catch block

		}
		System.out.println("**************************************************************************************************************");

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		try {
			wc.until(ExpectedConditions.elementToBeClickable(ele.yesBtn));
			System.out.println("Short Survey - Question and Answer Page Started.");
			System.out.println("Test Case - Provide response to page with question.");
			landingPageTC.log(LogStatus.INFO, "Test Case - Provide response to page with question.");

			while(true){
				wc.until(ExpectedConditions.elementToBeClickable(ele.yesBtn));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele.yesBtn);
				if(ele.yesBtn.isDisplayed())

				{
					System.out.println("Question Asked - "+ele.lablequest.getText());
					ele.yesBtn.click();
					Thread.sleep(2000);
					landingPageTC.log(LogStatus.PASS,
							"Click on "+ele.yesBtn.getText()+" button." + landingPageTC.addScreenCapture(captureScreenMethod(dest)));
					continue;
				}
				else
				{
					landingPageTC.log(LogStatus.INFO, "Done.");
					System.out.println("Done.");
					break;
				}

			}

		} catch (Exception e2) {
			// TODO Auto-generated catch block

		}
		System.out.println("**************************************************************************************************************");

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		try {
			wc.until(ExpectedConditions.elementToBeClickable(ele.conContinueBtn));
			System.out.println("Survey Confirmation Page.");
			Select dom=new Select(ele.conMonth);
			Select dod=new Select(ele.conDay);
			Select doy=new Select(ele.conYear);
			System.out.println("Test Case -Check all filed must be auto filled with correct data.");
			landingPageTC.log(LogStatus.INFO, "Test Case -Check all filed must be auto filled with correct data.");			
			try {
				assertEquals(lname,"Last Name");
				assertEquals(email,"dummyemail@domain.com");
				assertEquals(dom.getFirstSelectedOption().getText(), "August");
				assertEquals(dod.getFirstSelectedOption().getText(), "26");
				assertEquals(doy.getFirstSelectedOption().getText(), "1988");
				landingPageTC.log(LogStatus.PASS,
						"Check all field must be auto filled with correct data."
								+ landingPageTC.addScreenCapture(captureScreenMethod(dest)));


			} catch (AssertionError e) {
				System.out.println("Fail");

			}

			System.out.println("Test Case- Vary between check and Un-check the 'I CONFIRM' acceptance checkbox.");
			System.out.println("'I Confirm check box is unchecked.");
			landingPageTC.log(LogStatus.INFO, "Test Case- Vary between check and Un-check the 'I CONFIRM' acceptance checkbox.");			

			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele.iConfirm);
				assertEquals(ele.iConfirm.getCssValue("background-color"), "rgba(255, 255, 255, 1)");
				System.out.println("Pass");
				landingPageTC.log(LogStatus.PASS,
						"Unchecked ' I Confirm' check-box."
								+ landingPageTC.addScreenCapture(captureScreenMethod(dest)));
			} catch (AssertionError e) {

				System.out.println("Fail.");
			}

			System.out.println("'I Confirm check box is checked.");
			ele.iConfirm.click();
			Thread.sleep(2000);
			try {
				assertEquals(ele.iConfirm.getCssValue("background-color"), "rgba(255, 57, 88, 1)");
				System.out.println("Pass");
				landingPageTC.log(LogStatus.PASS,
						"Checked ' I Confirm' check-box."
								+ landingPageTC.addScreenCapture(captureScreenMethod(dest)));


			} catch (AssertionError e) {

				System.out.println("Fail.");
			}
			System.out.println("Verify Marketing Link is Working.");
			landingPageTC.log(LogStatus.INFO, "Test Case- Verify Marketing Link is Working.");			
			ele.mktLink.click();
			Thread.sleep(2000);
			wc.until(ExpectedConditions.elementToBeClickable(ele.closeWindow));
			landingPageTC.log(LogStatus.PASS,
					"Marketing Link is working."
							+ landingPageTC.addScreenCapture(captureScreenMethod(dest)));
			ele.closeWindow.click();
			System.out.println("Marketing Link is working.");
			Thread.sleep(2000);
			System.out.println("Pass.");
			ele.conContinueBtn.click();
			landingPageTC.log(LogStatus.INFO, "Done.");			
			System.out.println("Survey Confirmation Page completed");
		} catch (Exception e2) {
			// TODO Auto-generated catch block

		}
		System.out.println("**************************************************************************************************************");

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////

		try {

			while(true){
			wc.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='blockFormButtonList']/button")));
			List<WebElement> linkbtn=driver.findElements(By.xpath("//div[@class='blockFormButtonList']/button"));
			if(linkbtn.get(0).isDisplayed())
			{				
				System.out.println("Survey Offer Button Linkout Pages.");
				Thread.sleep(3000);
				WebElement button=linkbtn.get(0);
				button.click();
				System.out.println("Clicked.");
				ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
				try {
					driver.switchTo().window(tabs1.get(1));
				} catch (Exception e) {
					continue;
				}
				Thread.sleep(5000);
				System.out.println("Linkout Marketing Url - "+driver.getCurrentUrl());
				landingPageTC.log(LogStatus.PASS, "Open URL on click on button."+landingPageTC.addScreenCapture(captureScreenMethod("dest")));
				driver.close();
				Thread.sleep(2000);
				driver.switchTo().window(tabs1.get(0));
				continue;
			}
			else
			{
				break;
			}
		}

		} catch (Exception e1) {
            e1.printStackTrace();
		}
		System.out.println("**************************************************************************************************************");



		try {
			driver.switchTo().defaultContent();
			wc.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector("iframe[id='sandbox--518d3b8f-6787-458a-bcaf-8bce288d761c']"))));
			System.out.println("6-Survey Offer Linkout Page Single Radio Option.");
			landingPageTC.log(LogStatus.INFO, "Next Page "+ landingPageTC.addScreenCapture(captureScreenMethod(dest)));
			driver.findElement(By.cssSelector("input[type='radio'][value='Yes']")).click();
			System.out.println("Clicked on Radio Yes Button.");
			ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs1.get(1));
			System.out.println("Linkout Marketing Url - "+driver.getCurrentUrl());
			landingPageTC.log(LogStatus.PASS, "Open URL on click on button."+landingPageTC.addScreenCapture(captureScreenMethod("dest")));
			driver.close();
			Thread.sleep(2000);
			driver.switchTo().window(tabs1.get(0));
			System.out.println("Done.");

		} catch (Exception e2) {
			// TODO Auto-generated catch block

		}
		System.out.println("**************************************************************************************************************");


		try {
			driver.switchTo().defaultContent();
			wc.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector("iframe[id='sandbox--518d3b8f-6787-458a-bcaf-8bce288d761c']"))));
			wc.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='impressureButton--large userenroll-next']")));
			System.out.println("Survey Radio Option List selecte Page.");
			landingPageTC.log(LogStatus.INFO, "Next Page "+ landingPageTC.addScreenCapture(captureScreenMethod(dest)));
			while(true)
			{
				wc.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='impressureButton--large userenroll-next']")));
				landingPageTC.log(LogStatus.INFO, "Next Page "+ landingPageTC.addScreenCapture(captureScreenMethod(dest)));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("button[class='impressureButton--large userenroll-next']")));
				driver.findElement(By.cssSelector("button[class='impressureButton--large userenroll-next']")).click();
				Thread.sleep(5000);
				landingPageTC.log(LogStatus.PASS, "On click on 'Continue' button -"+landingPageTC.addScreenCapture(captureScreenMethod("dest")));
				continue;

			}
		} catch (Exception e2) {
			System.out.println("Done.");
			landingPageTC.log(LogStatus.INFO, "Done.");

		}
		System.out.println("Done.");
		System.out.println("**************************************************************************************************************");



		try {
			wc.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='iff-campaign-container-regular' and not(@style)]/div[2]/label/input[@value='Yes']"))));
			System.out.println("Radio Option 'Yes' - Linkout Page.");
			landingPageTC.log(LogStatus.INFO, "Next Page "+ landingPageTC.addScreenCapture(captureScreenMethod(dest)));

			while(true){
				Thread.sleep(3000);
				String headerTxt=driver.findElement(By.xpath("//h3")).getText();
				System.out.println("Radio Linkout Page Label - "+headerTxt);
				if(headerTxt.equals("Take our short survey now!"))
				{
					Thread.sleep(3000);
					driver.findElement(By.xpath("//div[@class='iff-campaign-container-regular' and not(@style)]/div/a")).click();
					ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
					try {
						driver.switchTo().window(tabs1.get(1));
					} catch (Exception e) {
						continue;
					}
					System.out.println("Linkout Marketing Url - "+driver.getCurrentUrl());
					landingPageTC.log(LogStatus.PASS, "Open URL on click on button."+landingPageTC.addScreenCapture(captureScreenMethod("dest")));
					driver.close();
					Thread.sleep(2000);
					driver.switchTo().window(tabs1.get(0));
					driver.switchTo().defaultContent();
					wc.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector("iframe[id='sandbox--518d3b8f-6787-458a-bcaf-8bce288d761c']"))));
					landingPageTC.log(LogStatus.PASS, "Next Page"+landingPageTC.addScreenCapture(captureScreenMethod("dest")));
					continue;
				}
				else
				{
					landingPageTC.log(LogStatus.INFO, "Done");
					System.out.println("Done.");
					break;

				}

			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		System.out.println("**************************************************************************************************************");



		try {
			try {
				wc.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector("iframe[id='sandbox--518d3b8f-6787-458a-bcaf-8bce288d761c']"))));
			} catch (Exception e) {
			}

			wc.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='iff-campaign-container' and not(@style)]/a"))));
			System.out.println("Survey Flow Large Banner Flow .");
			landingPageTC.log(LogStatus.INFO, "Next Page "+ landingPageTC.addScreenCapture(captureScreenMethod(dest)));
			while(true){
				Thread.sleep(3000);
				String headerTxt=driver.findElement(By.xpath("//h3")).getText();
				System.out.println(headerTxt);
				if(headerTxt.equals("You Qualify for These Special Offers:"))
				{
					driver.findElement(By.xpath("//div[@class='iff-campaign-container' and not(@style)]/a")).click();
					ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
					driver.switchTo().window(tabs1.get(1));
					System.out.println("Linkout Marketing Url - "+driver.getCurrentUrl());
					landingPageTC.log(LogStatus.PASS, "On click on 'Continue' button -"+landingPageTC.addScreenCapture(captureScreenMethod("dest")));
					driver.close();
					Thread.sleep(2000);
					driver.switchTo().window(tabs1.get(0));
					driver.switchTo().defaultContent();
					wc.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector("iframe[id='sandbox--518d3b8f-6787-458a-bcaf-8bce288d761c']"))));
					landingPageTC.log(LogStatus.PASS, "Next Page"+landingPageTC.addScreenCapture(captureScreenMethod("dest")));
					continue;
				}
				else if(headerTxt.equals("Please wait..."))
				{
					landingPageTC.log(LogStatus.PASS, "Next Page"+landingPageTC.addScreenCapture(captureScreenMethod("dest")));
					continue;

				}
				else
				{
					System.out.println("Done.");
					landingPageTC.log(LogStatus.INFO, "Done");
					break;
				}

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println("**************************************************************************************************************");

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		try {
			Thread.sleep(5000);
			try {
				wc.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector("iframe[id='sandbox--518d3b8f-6787-458a-bcaf-8bce288d761c']"))));
				driver.switchTo().defaultContent();

			} catch (Exception e) {
				driver.switchTo().defaultContent();
			}
			wc.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='i-af7e3c06-cc95-467b-995e-29a1126fdd16']")));
			System.out.println("Survey End Page button Linkout.");
			landingPageTC.log(LogStatus.INFO, "Next Page "+ landingPageTC.addScreenCapture(captureScreenMethod(dest)));
			Thread.sleep(3000);
			WebElement endbtn=driver.findElement(By.xpath("//*[@id='i-af7e3c06-cc95-467b-995e-29a1126fdd16']"));
			endbtn.click();
			ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs1.get(1));
			System.out.println("Linkout Marketing Url - "+driver.getCurrentUrl());
			landingPageTC.log(LogStatus.PASS, "On click on 'Continue' button -"+landingPageTC.addScreenCapture(captureScreenMethod("dest")));
			driver.close();
			Thread.sleep(2000);
			driver.switchTo().window(tabs1.get(0));
			landingPageTC.log(LogStatus.PASS, "Open URL on click on button."+landingPageTC.addScreenCapture(captureScreenMethod("dest")));
			landingPageTC.log(LogStatus.INFO, "Completed Successfully");
			extent.endTest(landingPageTC);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("**************************************************************************************************************");

	}

}
