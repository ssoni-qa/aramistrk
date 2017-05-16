package testSuite;

import org.testng.Assert;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;

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
	ExtentTest test,test1,test2,test3,test4;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		baseUrl = "http://go.aramistrk.com/aff_c?offer_id=311&aff_id=1018";
	}



	@Test(priority=1)
	@org.testng.annotations.Parameters(value={"os", "browser"})
	public void testLandingPage(String os,String browser) throws Exception {
		test = extent.startTest("Landing Page."," - check to ensure all landing page fields are being auto-filled with the specified user parameters."
				+ " - sometimes check the box for 'I am a Homeowner' and sometimes not"
				+ "- select other registration page checkboxes on and off at random "
				+ "- select the “Privacy Policy & Terms” checkbox before proceeding (must be checked in order to advance) "
				+ "- click the submit button to advance past registration page");
		CrossBrowserTestingTestNG myTest = new CrossBrowserTestingTestNG();
		Page ele=PageFactory.initElements(driver, Page.class);
		try {
			System.out.println("----Test Running On ---- >"+browser +" On Platform "+os);
			test.log(LogStatus.INFO, "----Test Running On ---- >"+browser +" On Platform "+os);
			System.out.println("Device name - "+os+" Browser Name - "+browser);
			test.log(LogStatus.INFO, "Device name - "+os+" Browser Name - "+browser);
			System.out.println("Test Scenario for Landing Page.");
			System.out.println("Open Url.");
			test.log(LogStatus.INFO, "Open Url - "+baseUrl);
			driver.get(baseUrl);
			test.log(LogStatus.FAIL,
					"" + test.addScreenCapture(captureScreenMethod(dest)));
			System.out.println("Enter First Name.");
			ele.firstName.clear();
			ele.firstName.sendKeys("FirstName");
			fname=ele.firstName.getAttribute("value");

			System.out.println("Enter Last Name.");
			ele.lastName.clear();
			ele.lastName.sendKeys("Last Name");
			lname=ele.lastName.getAttribute("value");

			System.out.println("Enter email address.");
			ele.emailAddress.clear();
			ele.emailAddress.sendKeys("dummyemail@domain.com");
			email=ele.emailAddress.getAttribute("value");

			//snapshotHash=myTest.takeSnapshot(driver.getSessionId().toString());
			//myTest.setDescription(driver.getSessionId().toString(), snapshotHash, "ScreenShots Taken");
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
				test.log(LogStatus.INFO, "Checked 'I AGree' checkbox.");
				Thread.sleep(2000);
				Assert.assertEquals(ele.iAggree.getCssValue("background-color"),
						"rgba(255, 57, 88, 1)");
				System.out.println("Pass.");
				test.log(LogStatus.INFO,
						"" + test.addScreenCapture(captureScreenMethod(dest)));

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
				test.log(LogStatus.INFO, "Check on 'I am Homeowner' checkbox.");
				Thread.sleep(2000);
				assertEquals(ele.homeOwner.getCssValue("background-color"),
						"rgba(255, 57, 88, 1)");
				System.out.println("Pass.");
				test.log(LogStatus.INFO,
						"" + test.addScreenCapture(captureScreenMethod(dest)));
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
			//snapshotHash=myTest.takeSnapshot(driver.getSessionId().toString());
			//myTest.setDescription(driver.getSessionId().toString(), snapshotHash, "ScreenShots Taken");
			System.out.println("Check on click the submit button to advance past registration page");
			ele.continueBtn.click();
			extent.endTest(test);
			


           
			System.out.println("Landing Page TC excuted.");
			test1 = extent.startTest("Survey Flow.");

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
					//	snapshotHash=myTest.takeSnapshot(driver.getSessionId().toString());
					//	myTest.setDescription(driver.getSessionId().toString(), snapshotHash, ele.lablequest.getText());
					System.out.println(ele.lablequest.getText());
					test1.log(LogStatus.INFO, ""+ele.lablequest.getText());
					System.out.println("Click on "+ele.yesBtn.getText()+" button.");
					test1.log(LogStatus.INFO,
							"" + test.addScreenCapture(captureScreenMethod(dest)));
					ele.yesBtn.click();
					test1.log(LogStatus.INFO, ""+ele.yesBtn.getText()+" button.");

					continue;
				}
				else
				{
					break;
				}

			}
			
			extent.endTest(test1);
			
			test2=extent.startTest("Survey Confirmation Page");
			
			try {
				assertEquals(driver.findElement(By.cssSelector("span > span")).getText(), "CONFIRM YOUR INFORMATION");
			} catch (AssertionError e) {
				e.printStackTrace();
				String snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
				myTest.setDescription(driver.getSessionId().toString(), snapshotHash, e.toString());
				myTest.testScore = "fail";
			}

			test2.log(LogStatus.FAIL,
					"" + test1.addScreenCapture(captureScreenMethod(dest)));
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("Test Case 3 - Survey Confirmation Page.");
			//		Survey Confirmation Page
			//		- all fields should be auto-filled
			//		- vary between checking the I Confirm acceptance checkbox
			//		- make sure the marketing Link is working
			//		- select large CONTINUE button
			Select dom=new Select(ele.conMonth);
			Select dod=new Select(ele.conDay);
			Select doy=new Select(ele.conYear);
			System.out.println("TC 3.1 -Check all filed must be auto filled with correct data.");
			try {
				assertEquals(lname,"Last Name");
				test2.log(LogStatus.INFO, "Re");
				assertEquals(email,"dummyemail@domain.com");
				assertEquals(dom.getFirstSelectedOption().getText(), "August");
				assertEquals(dod.getFirstSelectedOption().getText(), "26");
				assertEquals(doy.getFirstSelectedOption().getText(), "1988");
				test2.log(LogStatus.INFO, "Checked all filed are auto filled with correct data.");

			} catch (AssertionError e) {
				System.out.println("Fail");
				e.printStackTrace();
				String snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
				myTest.setDescription(driver.getSessionId().toString(), snapshotHash, e.toString());
				myTest.testScore = "fail";
			}

            extent.endTest(test2);
			System.out.println("TC 3.2 - Vary between checking the 'I CONFIRM' acceptance checkbox.");
			System.out.println("'I Confirm check box is unchecked.");
			try {
				assertEquals(ele.iConfirm.getCssValue("background-color"), "rgba(255, 255, 255, 1)");
				System.out.println("Pass");

			} catch (AssertionError e) {
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
				e.printStackTrace();
				System.out.println("Fail.");
				//String snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
				//myTest.setDescription(driver.getSessionId().toString(), snapshotHash, e.toString());
				myTest.testScore = "fail";

			}
			System.out.println("Verify Marketing Link is Working.");
			ele.mktLink.click();
			Thread.sleep(2000);
			wc.until(ExpectedConditions.elementToBeClickable(ele.closeWindow));
			ele.closeWindow.click();
			System.out.println("Marketing Link is working.");
			Thread.sleep(2000);
			System.out.println("Pass.");
			ele.conContinueBtn.click();
			System.out.println("Survey Confirmation Page completed");
			System.out.println("***********************************************************************");
			System.out.println("");
			System.out.println("");
			System.out.println("Survey Offer Linkout Pages Started.");

			try {
				String parentHandle = driver.getWindowHandle(); 
				driver.findElement(By.id("i-3bee30e7-91ed-4eb2-902d-765f0a373ad9")).click();
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle); 
				}
				System.out.println("On click URL : "+driver.getCurrentUrl());
				driver.close();
				driver.switchTo().window(parentHandle);

			} catch (Exception e) {
				System.out.println("Survey Page with 'Yes' and 'No' button is not displayed.");
			}
			String parentHandle = driver.getWindowHandle(); 

			System.out.println("Survey Option Page Radio");

			WebDriverWait wc1= new WebDriverWait(driver, 10);
			try {
				wc1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='i-3bee30e7-91ed-4eb2-902d-765f0a373ad9']")));
				System.out.println("Yes I do button found.");
				driver.findElement(By.xpath("//*[@id='i-3bee30e7-91ed-4eb2-902d-765f0a373ad9']")).click();
				ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(1));
				System.out.println("New Open Tab "+driver.getCurrentUrl());
				driver.close();
				driver.switchTo().window(tabs2.get(0));

			} catch (Exception e) {
				System.out.println("Yes I do button not found.");
			}

			try {
				wc1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='i-c40d54a9-6e8b-46da-8ba6-6086786bfd41']")));
				System.out.println("Small Image Banner is found.");
				driver.findElement(By.xpath("//*[@id='i-c40d54a9-6e8b-46da-8ba6-6086786bfd41']")).click();
				ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(1));
				System.out.println("New Open Tab "+driver.getCurrentUrl());
				driver.close();
				driver.switchTo().window(tabs2.get(0));

			} catch (Exception e) {
				System.out.println("Small Image Banner is found. button not found.");
			}
			Thread.sleep(5000);
			driver.switchTo().frame(0);



			while(true){
				try {
					wc1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Continue')]")));
					driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
					continue;
				} catch (Exception e) {
					break;
				}


			}

			while(true){
				try {
					List <WebElement> radioLink=driver.findElements(By.xpath("//div[@class='iff-campaign-container-regular']/div[2]/label[1]/input"));
					for(WebElement id:radioLink)
					{
						String ids=id.getAttribute("id");
						if(!mainList.contains(ids))
							mainList.add(ids);
					}
					System.out.println("Size of array list now "+mainList.size());
					String mainWindow= driver.getWindowHandle();
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
					driver.close();
					driver.switchTo().window(mainWindow);
					driver.switchTo().frame(0);
				} catch (Exception e) {
					break;
				}
			}

			System.out.println("Out for loop , successfully.");


			System.out.println("Working on Large Image Baneer .");



			while(true){
				try {
					wc1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Continue')]")));
					driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
					continue;
				} catch (Exception e) {
					break;
				}


			}

			while(true){
				try {
					List <WebElement> radioLink=driver.findElements(By.xpath("//*[@class='iff-campaign-container']"));
					for(WebElement id:radioLink)
					{
						String ids=id.getAttribute("id");
						if(!ImageList.contains(ids))
							ImageList.add(ids);
					}
					System.out.println("Size of array list now "+ImageList.size());
					String mainWindow1= driver.getWindowHandle();
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


					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle); 
					}

					System.out.println("Open Url :"+driver.getCurrentUrl());
					driver.close();
					driver.switchTo().window(mainWindow1);
					driver.switchTo().frame(0);
				} catch (Exception e) {
					//e.printStackTrace();
					break;
				}
			}
			System.out.println("Now Switic.......");
			driver.switchTo().window(parentHandle);
			wc.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='i-af7e3c06-cc95-467b-995e-29a1126fdd16']"))));
			driver.findElement(By.xpath("//*[@id='i-af7e3c06-cc95-467b-995e-29a1126fdd16']")).click();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle); 
			}
			System.out.println(driver.getCurrentUrl());
			driver.close();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle); 
			}
			System.out.println(driver.getCurrentUrl());
			driver.close();


			//myTest.setScore(driver.getSessionId().toString(), myTest.testScore);

		} catch (Exception e) {
			e.printStackTrace();
			myTest.testScore="fail";
			myTest.setScore(driver.getSessionId().toString(), myTest.testScore);
			//String snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
			//myTest.setDescription(driver.getSessionId().toString(), snapshotHash, e.toString());
			System.out.println("Excpetion Occured.");
		}

	}
}
