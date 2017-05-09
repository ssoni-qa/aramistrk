package testSuite;

import org.testng.Assert;
import org.testng.annotations.*;
import crossBrowserTesting.CrossBrowserTestingTestNG;
import crossBrowserTesting.Page;

import static org.testng.Assert.*;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends CrossBrowserTestingTestNG{
	private String baseUrl;
	String fname,lname,email,dom,dob,doy;
	String snapshotHash;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		baseUrl = "http://path.shareyourfreebies.com/";
	}



	@Test(priority=1)
	@org.testng.annotations.Parameters(value={"os", "browser"})
	public void testLandingPage(String os,String browser) throws Exception {
		CrossBrowserTestingTestNG myTest = new CrossBrowserTestingTestNG();
		Page ele=PageFactory.initElements(driver, Page.class);
		try {
			System.out.println("----Test Running On ---- >"+browser +" On Platform "+os);
			System.out.println("Device name - "+os+" Browser Name - "+browser);
			//		try {
			System.out.println("Test Scenario for Landing Page.");
			System.out.println("Open Url.");
			driver.get(baseUrl + "/?transaction_id=102526122115171190748812216317&aff_id=1018&offer_id=311&url_id={url_id}&firstname={firstname}&lastname={lastname}&email={email}&dob-m={dob-m}&dob-d={dob-d}&dob-y={dob-y}&gender={gender}&address={address}&phone={phone}&city={city2}&state={state}&zip={zip}&aff_sub=&aff_sub2=&aff_sub3=&aff_sub4=&aff_sub5=&i={i}");

			System.out.println("Enter First Name.");
			ele.firstName.clear();
			ele.firstName.sendKeys("FirstName");
			//driver.findElement(By.id("i-input-81dfe9a6-361c-4606-95f9-119ffd994f15-first-name")).clear();
			//driver.findElement(By.id("i-input-81dfe9a6-361c-4606-95f9-119ffd994f15-first-name")).sendKeys("FirstName");
			fname=ele.firstName.getAttribute("value");

			System.out.println("Enter Last Name.");
			ele.lastName.clear();
			ele.lastName.sendKeys("Last Name");
			lname=ele.lastName.getAttribute("value");

			System.out.println("Enter email address.");
			ele.emailAddress.clear();
			ele.emailAddress.sendKeys("dummyemail@domain.com");
			email=ele.emailAddress.getAttribute("value");

			snapshotHash=myTest.takeSnapshot(driver.getSessionId().toString());
			myTest.setDescription(driver.getSessionId().toString(), snapshotHash, "ScreenShots Taken");
			System.out.println("Select Month of birth.");
			new Select(ele.month).selectByVisibleText("August");
			dom=ele.month.getAttribute("value");

			System.out.println("Select Date of birth.");
			new Select(ele.day).selectByVisibleText("26");
			dob=ele.day.getText();

			System.out.println("Select year of birth.");
			new Select(ele.year).selectByVisibleText("1988");
			doy=ele.year.getText();

			System.out.println("Select gender.");
			new Select(ele.gender).selectByVisibleText("Male");

			System.out.println("Entering Phone Number.");
			ele.phoneNo.clear();
			ele.phoneNo.click();
			ele.phoneNo.sendKeys("(111) 111-1111");

			System.out.println("Enter Street Address.");
			ele.streetAdd.clear();
			ele.streetAdd.sendKeys("street address");

			System.out.println("Enter City name.");
			ele.city.sendKeys("CityName");

			System.out.println("Select state from drop down.");
			new Select(ele.state).selectByVisibleText("AL");

			System.out.println("Enter zip code.");
			ele.zipCode.sendKeys("11111");
			ele.zipCode.sendKeys("(111) 111-1111");

			//Test Case (- sometimes check the box for 'I am a Homeowner' and sometimes not.)
			System.out.println("Check if the checkbox is selectable or not for 'I am a Homeowner'.");   
			System.out.println("TC : Check-Box can checked.");
			try {
				ele.iAggree.click();
				Thread.sleep(2000);
				Assert.assertEquals(ele.iAggree.getCssValue("background-color"),
						"rgba(255, 57, 88, 1)");
				System.out.println("Pass.");

			} catch (AssertionError ae) {
				System.out.println("Fail :"+ae.getMessage());
				String snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
				myTest.setDescription(driver.getSessionId().toString(), snapshotHash, ae.toString());
				myTest.testScore = "fail";
			}
			System.out.println("TC : Check-Box can Unchecked.");
			try {
				ele.iAggree.click();
				Thread.sleep(2000);
				assertEquals(ele.iAggree.getCssValue("background-color"),
						"rgba(255, 255, 255, 1)");
				System.out.println("Pass.");

			} catch (AssertionError ae) {
				System.out.println("Fail :"+ae.getMessage());
				String snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
				myTest.setDescription(driver.getSessionId().toString(), snapshotHash, ae.toString());
				myTest.testScore = "fail";
			}
			System.out.println("Check if the checkbox is selectable or not for 'By checking this box, you agree to:'.");   
			System.out.println("TC : Check-Box can checked.");
			try {
				ele.homeOwner.click();
				Thread.sleep(2000);
				assertEquals(ele.homeOwner.getCssValue("background-color"),
						"rgba(255, 57, 88, 1)");
				System.out.println("Pass.");
			} catch (AssertionError ae) {
				System.out.println("Fail :"+ae.getMessage());
				String snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
				myTest.setDescription(driver.getSessionId().toString(), snapshotHash, ae.toString());
				myTest.testScore = "fail";
			}
			System.out.println("TC : Check-Box can Unchecked.");

			try {
				ele.homeOwner.click();
				Thread.sleep(2000);
				assertEquals(ele.homeOwner.getCssValue("background-color"),
						"rgba(255, 255, 255, 1)");
				System.out.println("Pass.");
			} catch (AssertionError ae) {
				System.out.println("Fail :"+ae.getMessage());
				String snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
				myTest.setDescription(driver.getSessionId().toString(), snapshotHash, ae.toString());
				myTest.testScore = "fail";
			}
			snapshotHash=myTest.takeSnapshot(driver.getSessionId().toString());
			myTest.setDescription(driver.getSessionId().toString(), snapshotHash, "ScreenShots Taken");
			System.out.println("Check on click the submit button to advance past registration page");
			try {
				ele.continueBtn.click();
				assertEquals(driver.findElement(By.cssSelector("p.mobile-h1")).getText(), "Take our short survey");
				System.out.println("Pass.");
			} catch (AssertionError ae) {
				System.out.println("Fail :"+ae.getMessage());
				String snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
				myTest.setDescription(driver.getSessionId().toString(), snapshotHash, ae.toString());
				myTest.testScore = "fail";
			}


			System.out.println("Information Page TC excuted.");

			//			Survey Flow
			//			//			- provides responses to the pages with questions
			//			//			- vary between yes and no answers
			//			//			- vary between multiple choice answers
			//
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("Survey Flow- "
					+ "-provides responses to the pages with questions"
					+ "-vary between yes and no answers-"
					+ "-vary between multiple choice answers");
			new WebDriverWait(driver, 15).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Yes')]")));
			System.out.println("Question Asked , reponse capture.");

			while(true){
				wc.until(ExpectedConditions.elementToBeClickable(ele.yesBtn));
				if(ele.yesBtn.isDisplayed() 
						&& !ele.lablequest.getText().contains("FIRST NAME *"))
				{
					snapshotHash=myTest.takeSnapshot(driver.getSessionId().toString());
					myTest.setDescription(driver.getSessionId().toString(), snapshotHash, ele.lablequest.getText());
					System.out.println(ele.lablequest.getText());
					System.out.println("Click on "+ele.yesBtn.getText()+" button.");
					ele.yesBtn.click();
					continue;
				}
				else
				{
					break;
				}

			}
			try {
				assertEquals(driver.findElement(By.cssSelector("span > span")).getText(), "CONFIRM YOUR INFORMATION");
			} catch (AssertionError e) {
				e.printStackTrace();
				String snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
				myTest.setDescription(driver.getSessionId().toString(), snapshotHash, e.toString());
				myTest.testScore = "fail";
			}


			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("Test Case 3 - Survey Confirmation Page.");
			//		Survey Confirmation Page
			//		- all fields should be auto-filled
			//		- vary between checking the “I CONFIRM” acceptance checkbox
			//		- make sure the “marketing partners” link is working
			//		- select large CONTINUE button
			Select dom=new Select(ele.conMonth);
			Select dod=new Select(ele.conDay);
			Select doy=new Select(ele.conYear);
			System.out.println("TC 3.1 -Check all filed must be auto filled with correct data.");
			try {
				assertEquals(lname,"Last Name");
				assertEquals(email,"dummyemail@domain.com");
				assertEquals(dom.getFirstSelectedOption().getText(), "August");
				assertEquals(dod.getFirstSelectedOption().getText(), "26");
				assertEquals(doy.getFirstSelectedOption().getText(), "1988");
			} catch (AssertionError e) {
				System.out.println("Fail");
				e.printStackTrace();
				String snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
				myTest.setDescription(driver.getSessionId().toString(), snapshotHash, e.toString());
				myTest.testScore = "fail";
			}
			
			System.out.println("Verify Marketing Link is Working.");
			ele.mktLink.click();
			wc.until(ExpectedConditions.elementToBeClickable(ele.closeWindow));
			ele.closeWindow.click();
			System.out.println("Marketing Link is working.");
			
			System.out.println("Pass.");
			System.out.println("TC 3.2 - Vary between checking the “I CONFIRM” acceptance checkbox.");

			System.out.println("'I Confirm check box is unchecked.");
			try {
				assertEquals(ele.iConfirm.getCssValue("background-color"), "rgba(255, 255, 255, 1)");
				System.out.println("Pass");

			} catch (AssertionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Fail.");
				String snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
				myTest.setDescription(driver.getSessionId().toString(), snapshotHash, e.toString());
				myTest.testScore = "fail";
			}

			System.out.println("'I Confirm check box is checked.");
			ele.iConfirm.click();
			Thread.sleep(2000);
			try {
				assertEquals(ele.iConfirm.getCssValue("background-color"), "rgba(255, 57, 88, 1)");
				System.out.println("Pass");
			} catch (AssertionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Fail.");
				String snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
				myTest.setDescription(driver.getSessionId().toString(), snapshotHash, e.toString());
				myTest.testScore = "fail";

			}
			snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
			myTest.setDescription(driver.getSessionId().toString(), snapshotHash, "Survey Confirmation Page");
			System.out.println("Survey Confirmation Page completed");
			ele.conContinueBtn.click();
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
			//
			//
			//
			//
			//			
			//
			//			
			//
			//			//			Survey Offer Linkout Pages
			//			//			- vary between clicking ‘yes’ and ‘no’ on survey link out pages
			//			//			- if you click yes, make sure it links out to a valid url
			//
			//			try {
			//
			//
			//				while(true){
			//					System.out.println("Survey Offer Linkout Pages.");
			//					Thread.sleep(5000);
			//					String parentHandle = driver.getWindowHandle();
			//					driver.switchTo().frame(0);
			//                     System.out.println("Above if statement");
			//					if(driver.findElement(By.cssSelector("span.iff-regular-container-header")).isDisplayed())
			//					{
			//						System.out.println("Sample Title : - "+driver.findElement(By.cssSelector("span.iff-regular-container-header")).getText());
			//						if(driver.findElement(By.xpath("//input[@value='Yes']")).getAttribute("onclick").contains("Yes"));
			//						{
			//							driver.findElement(By.xpath("//input[@value='Yes']")).click();
			//							for(String winHandle : driver.getWindowHandles()){
			//								driver.switchTo().window(winHandle);
			//							}
			//							System.out.println("Marketing Link URL : "+driver.getCurrentUrl());
			//							driver.close(); 
			//							driver.switchTo().window(parentHandle);
			//
			//							Thread.sleep(5000);
			//
			//						}
			//
			//					}
			//					else
			//					{
			//						break;
			//					}
			//					continue;
			//
			//				}
			//
			//
			//
			//
			//
			//			} catch (Exception e) {
			//				// TODO Auto-generated catch block
			//				e.printStackTrace();
			//			}
			myTest.setScore(driver.getSessionId().toString(), myTest.testScore);

		} catch (Exception e) {
			myTest.testScore="fail";
			myTest.setScore(driver.getSessionId().toString(), myTest.testScore);
			String snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
			myTest.setDescription(driver.getSessionId().toString(), snapshotHash, e.toString());
			System.out.println("Excpetion Occured.");
			e.printStackTrace();
		}

	}
}
