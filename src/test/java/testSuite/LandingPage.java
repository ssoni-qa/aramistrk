package testSuite;

import org.testng.Assert;
import org.testng.annotations.*;
import crossBrowserTesting.CrossBrowserTestingTestNG;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends CrossBrowserTestingTestNG{
	private String baseUrl;
	String fname,lname,email,dom,dob,doy;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		baseUrl = "http://path.shareyourfreebies.com/";
	}



	@Test(priority=1)
	@org.testng.annotations.Parameters(value={"os", "browser"})
	public void testLandingPage(String os,String browser) throws Exception {
		CrossBrowserTestingTestNG myTest = new CrossBrowserTestingTestNG();
		try {
			System.out.println("----Test Running On ---- >"+browser +" On Platform "+os);
			System.out.println("Device name - "+os+" Browser Name - "+browser);
			//		try {
			System.out.println("Test Scenario for Landing Page.");
			System.out.println("Open Url.");
			driver.get(baseUrl + "/?transaction_id=102526122115171190748812216317&aff_id=1018&offer_id=311&url_id={url_id}&firstname={firstname}&lastname={lastname}&email={email}&dob-m={dob-m}&dob-d={dob-d}&dob-y={dob-y}&gender={gender}&address={address}&phone={phone}&city={city2}&state={state}&zip={zip}&aff_sub=&aff_sub2=&aff_sub3=&aff_sub4=&aff_sub5=&i={i}");

			System.out.println("Enter First Name.");
			driver.findElement(By.id("i-input-81dfe9a6-361c-4606-95f9-119ffd994f15-first-name")).clear();
			driver.findElement(By.id("i-input-81dfe9a6-361c-4606-95f9-119ffd994f15-first-name")).sendKeys("FirstName");
			fname=driver.findElement(By.id("i-input-81dfe9a6-361c-4606-95f9-119ffd994f15-first-name")).getAttribute("value");

			System.out.println("Enter Last Name.");
			driver.findElement(By.id("i-input-81dfe9a6-361c-4606-95f9-119ffd994f15-last-name")).clear();
			driver.findElement(By.id("i-input-81dfe9a6-361c-4606-95f9-119ffd994f15-last-name")).sendKeys("LastName");
			lname=driver.findElement(By.id("i-input-81dfe9a6-361c-4606-95f9-119ffd994f15-last-name")).getAttribute("value");

			System.out.println("Enter email address.");
			driver.findElement(By.id("i-input-9af4f79d-c77e-4b69-a975-2b46df37610d-default")).clear();
			driver.findElement(By.id("i-input-9af4f79d-c77e-4b69-a975-2b46df37610d-default")).sendKeys("dummyemail@domain.com");
			email=driver.findElement(By.id("i-input-9af4f79d-c77e-4b69-a975-2b46df37610d-default")).getAttribute("value");

			System.out.println("Select Month of birth.");
			new Select(driver.findElement(By.id("i-input-9a9d8356-5ef8-4f0e-aed4-e1fa700307a2-month"))).selectByVisibleText("August");
			dom=driver.findElement(By.id("i-input-9a9d8356-5ef8-4f0e-aed4-e1fa700307a2-month")).getAttribute("value");
			System.out.println("Select Date of birth.");
			new Select(driver.findElement(By.id("i-input-9a9d8356-5ef8-4f0e-aed4-e1fa700307a2-day"))).selectByVisibleText("26");
			dob=driver.findElement(By.id("i-input-9a9d8356-5ef8-4f0e-aed4-e1fa700307a2-day")).getText();
			System.out.println("Select year of birth.");
			new Select(driver.findElement(By.id("i-input-9a9d8356-5ef8-4f0e-aed4-e1fa700307a2-year"))).selectByVisibleText("1988");
			doy=driver.findElement(By.id("i-input-9a9d8356-5ef8-4f0e-aed4-e1fa700307a2-year")).getText();
			System.out.println("Select gender.");
			new Select(driver.findElement(By.id("i-input-aed8d9b3-04f0-42fa-9d8f-2ae196b0aa66-default"))).selectByVisibleText("Male");
			driver.findElement(By.id("i-input-e2391395-ae36-45cd-ab79-f1330f00c4ff-default")).clear();
			System.out.println("Enter Phone number.");
			driver.findElement(By.id("i-input-e2391395-ae36-45cd-ab79-f1330f00c4ff-default")).sendKeys("(111) 111-1111");
			driver.findElement(By.id("i-input-ec58cc90-9cc1-448a-a95a-f33ed26163a2-address-1")).clear();
			System.out.println("Enter Street Address.");
			driver.findElement(By.id("i-input-ec58cc90-9cc1-448a-a95a-f33ed26163a2-address-1")).sendKeys("street address");
			System.out.println("Enter City name.");
			driver.findElement(By.name("ec58cc90-9cc1-448a-a95a-f33ed26163a2-city")).sendKeys("CityName");
			System.out.println("Select state from drop down.");
			new Select(driver.findElement(By.id("i-input-ec58cc90-9cc1-448a-a95a-f33ed26163a2-state"))).selectByVisibleText("AL");
			System.out.println("Enter zip code.");
			driver.findElement(By.id("i-input-ec58cc90-9cc1-448a-a95a-f33ed26163a2-zip")).sendKeys("11111");
			driver.findElement(By.id("i-input-e2391395-ae36-45cd-ab79-f1330f00c4ff-default")).sendKeys("(111) 111-1111");

			//Test Case (- sometimes check the box for 'I am a Homeowner' and sometimes not.)
			System.out.println("Check if the checkbox is selectable or not for 'I am a Homeowner'.");   
			System.out.println("TC : Check-Box can checked.");
			try {
				driver.findElement(By.cssSelector("span.checkbox-material > span")).click();
				Thread.sleep(2000);
				Assert.assertEquals(driver.findElement(By.cssSelector("span.checkbox-material > span")).getCssValue("background-color"),
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
				driver.findElement(By.cssSelector("span.checkbox-material > span")).click();
				Thread.sleep(2000);
				assertEquals(driver.findElement(By.cssSelector("span.checkbox-material > span")).getCssValue("background-color"),
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
				driver.findElement(By.cssSelector("#i-e071ae69-c557-4da7-9acf-9b395e77e72c-default > div.validation__wrapper > div.checkboxes > label > span.checkbox-material > span")).click();
				Thread.sleep(2000);
				assertEquals(driver.findElement(By.cssSelector("#i-e071ae69-c557-4da7-9acf-9b395e77e72c-default > div.validation__wrapper > div.checkboxes > label > span.checkbox-material > span")).getCssValue("background-color"),
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
				driver.findElement(By.cssSelector("#i-e071ae69-c557-4da7-9acf-9b395e77e72c-default > div.validation__wrapper > div.checkboxes > label > span.checkbox-material > span")).click();
				Thread.sleep(2000);
				assertEquals(driver.findElement(By.cssSelector("#i-e071ae69-c557-4da7-9acf-9b395e77e72c-default > div.validation__wrapper > div.checkboxes > label > span.checkbox-material > span")).getCssValue("background-color"),
						"rgba(255, 255, 255, 1)");
				System.out.println("Pass.");
			} catch (AssertionError ae) {
				System.out.println("Fail :"+ae.getMessage());
				String snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
				myTest.setDescription(driver.getSessionId().toString(), snapshotHash, ae.toString());
				myTest.testScore = "fail";
			}


			System.out.println("Check on click the submit button to advance past registration page");
			try {
				driver.findElement(By.id("i-316651b8-b3cb-48bb-93b3-6f16675349ad")).click();
				assertEquals(driver.findElement(By.cssSelector("p.mobile-h1")).getText(), "Take our short survey");
				System.out.println("Pass.");
			} catch (AssertionError ae) {
				System.out.println("Fail :"+ae.getMessage());
				String snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
				myTest.setDescription(driver.getSessionId().toString(), snapshotHash, ae.toString());
				myTest.testScore = "fail";
			}
			System.out.println("Done");




			//			Survey Flow
			//			- provides responses to the pages with questions
			//			- vary between yes and no answers
			//			- vary between multiple choice answers

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
				wc.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.label__text")));
				if(driver.findElement(By.cssSelector("span.label__text")).isDisplayed() 
						&& !driver.findElement(By.cssSelector("label.form-label")).getText().contains("FIRST NAME *"))
				{
					System.out.println(driver.findElement(By.cssSelector("label.form-label")).getText());
					System.out.println("Click on "+driver.findElement(By.cssSelector("span.label__text")).getText()+" button.");
					driver.findElement(By.cssSelector("span.label__text")).click();
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
			Select dom=new Select(driver.findElement(By.id("i-input-35e8359f-517c-44d1-b22c-6b61140e024a-month")));
			Select dod=new Select(driver.findElement(By.id("i-input-35e8359f-517c-44d1-b22c-6b61140e024a-day")));
			Select doy=new Select(driver.findElement(By.id("i-input-35e8359f-517c-44d1-b22c-6b61140e024a-year")));
			System.out.println("TC 3.1 -Check all filed must be auto filled with correct data.");
			try {
				assertEquals(lname,"LastName");
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
			System.out.println("Pass.");
			System.out.println("TC 3.2 - Vary between checking the “I CONFIRM” acceptance checkbox.");

			System.out.println("'I Confirm check box is unchecked.");
			try {
				assertEquals(driver.findElement(By.cssSelector("span.checkbox-material > span")).getCssValue("background-color"), "rgba(255, 255, 255, 1)");
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
			driver.findElement(By.cssSelector("span.checkbox-material > span")).click();
			Thread.sleep(2000);
			try {
				assertEquals(driver.findElement(By.cssSelector("span.checkbox-material > span")).getCssValue("background-color"), "rgba(255, 57, 88, 1)");
				System.out.println("Pass");
			} catch (AssertionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Fail.");
				String snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
				myTest.setDescription(driver.getSessionId().toString(), snapshotHash, e.toString());
				myTest.testScore = "fail";

			}

			driver.findElement(By.cssSelector("div.imageInner.pt > img")).click();
			System.out.println("");
			System.out.println("");
			System.out.println("");

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
