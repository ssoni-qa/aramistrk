package testSuite;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import crossBrowserTesting.CrossBrowserTestingTestNG;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class LandingPage extends CrossBrowserTestingTestNG{
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		baseUrl = "http://path.shareyourfreebies.com/";
	}

	@Test
	public void testLandingPage() throws Exception {
		driver.get(baseUrl + "/?transaction_id=102526122115171190748812216317&aff_id=1018&offer_id=311&url_id={url_id}&firstname={firstname}&lastname={lastname}&email={email}&dob-m={dob-m}&dob-d={dob-d}&dob-y={dob-y}&gender={gender}&address={address}&phone={phone}&city={city2}&state={state}&zip={zip}&aff_sub=&aff_sub2=&aff_sub3=&aff_sub4=&aff_sub5=&i={i}");

		System.out.println("Test Scenario for Landing Page.");
		driver.findElement(By.id("i-input-81dfe9a6-361c-4606-95f9-119ffd994f15-first-name")).clear();

		driver.findElement(By.id("i-input-81dfe9a6-361c-4606-95f9-119ffd994f15-first-name")).sendKeys("FirstName");

		driver.findElement(By.id("i-input-81dfe9a6-361c-4606-95f9-119ffd994f15-last-name")).clear();

		driver.findElement(By.id("i-input-81dfe9a6-361c-4606-95f9-119ffd994f15-last-name")).sendKeys("LastName");

		driver.findElement(By.id("i-input-9af4f79d-c77e-4b69-a975-2b46df37610d-default")).clear();

		driver.findElement(By.id("i-input-9af4f79d-c77e-4b69-a975-2b46df37610d-default")).sendKeys("dummyemail@domain.com");

		new Select(driver.findElement(By.id("i-input-9a9d8356-5ef8-4f0e-aed4-e1fa700307a2-month"))).selectByVisibleText("August");

		new Select(driver.findElement(By.id("i-input-9a9d8356-5ef8-4f0e-aed4-e1fa700307a2-day"))).selectByVisibleText("26");

		new Select(driver.findElement(By.id("i-input-9a9d8356-5ef8-4f0e-aed4-e1fa700307a2-year"))).selectByVisibleText("1988");

		new Select(driver.findElement(By.id("i-input-aed8d9b3-04f0-42fa-9d8f-2ae196b0aa66-default"))).selectByVisibleText("Male");

		driver.findElement(By.id("i-input-e2391395-ae36-45cd-ab79-f1330f00c4ff-default")).clear();

		driver.findElement(By.id("i-input-e2391395-ae36-45cd-ab79-f1330f00c4ff-default")).sendKeys("(111) 111-1111");

		driver.findElement(By.id("i-input-ec58cc90-9cc1-448a-a95a-f33ed26163a2-address-1")).clear();

		driver.findElement(By.id("i-input-ec58cc90-9cc1-448a-a95a-f33ed26163a2-address-1")).sendKeys("street address");

		driver.findElement(By.name("ec58cc90-9cc1-448a-a95a-f33ed26163a2-city")).sendKeys("CityName");

		new Select(driver.findElement(By.id("i-input-ec58cc90-9cc1-448a-a95a-f33ed26163a2-state"))).selectByVisibleText("AL");

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
		}

		System.out.println("TC : Check-Box can Unchecked.");

		try {
			driver.findElement(By.cssSelector("span.checkbox-material > span")).click();

			Thread.sleep(2000);

			Assert.assertEquals(driver.findElement(By.cssSelector("span.checkbox-material > span")).getCssValue("background-color"),
					"rgba(255, 255, 255, 1)");

			System.out.println("Pass.");


		} catch (AssertionError ae) {

			System.out.println("Fail :"+ae.getMessage());
		}

		System.out.println("Check if the checkbox is selectable or not for 'By checking this box, you agree to:'.");   

		System.out.println("TC : Check-Box can checked.");

		try {

			driver.findElement(By.cssSelector("#i-cb7a990e-5267-4fa0-a4fb-5bbc843625e4-default > div.validation__wrapper > div.checkboxes > label > span.checkbox-material > span")).click();

			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.cssSelector("#i-cb7a990e-5267-4fa0-a4fb-5bbc843625e4-default > div.validation__wrapper > div.checkboxes > label > span.checkbox-material > span")).getCssValue("background-color"),
					"rgba(255, 57, 88, 1)");

			System.out.println("Pass.");

		} catch (AssertionError ae) {

			System.out.println("Fail :"+ae.getMessage());
		}

		System.out.println("TC : Check-Box can Unchecked.");

		try {
			driver.findElement(By.cssSelector("#i-cb7a990e-5267-4fa0-a4fb-5bbc843625e4-default > div.validation__wrapper > div.checkboxes > label > span.checkbox-material > span")).click();

			Thread.sleep(2000);

			Assert.assertEquals(driver.findElement(By.cssSelector("#i-cb7a990e-5267-4fa0-a4fb-5bbc843625e4-default > div.validation__wrapper > div.checkboxes > label > span.checkbox-material > span")).getCssValue("background-color"),
					"rgba(255, 255, 255, 1)");

			System.out.println("Pass.");


		} catch (AssertionError ae) {

			System.out.println("Fail :"+ae.getMessage());
		}

		System.out.println("Test Scenario :“Privacy Policy & Terms” checkbox must be checked in order to advance. ");	

		try {
			driver.findElement(By.id("i-316651b8-b3cb-48bb-93b3-6f16675349ad")).click();
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//*[@class='validation validation--error']")).getText(),
					"Please check one or more options.");
			System.out.println("Pass.");
		} catch (AssertionError ae) {

			System.out.println("Fail :"+ae.getMessage());
		}

		driver.findElement(By.cssSelector("#i-cb7a990e-5267-4fa0-a4fb-5bbc843625e4-default > div.validation__wrapper > div.checkboxes > label > span.checkbox-material > span")).click();

		Thread.sleep(2000);

		System.out.println("Check on click the submit button to advance past registration page");


		try {

			driver.findElement(By.id("i-316651b8-b3cb-48bb-93b3-6f16675349ad")).click();

			assertEquals(driver.findElement(By.cssSelector("p.mobile-h1")).getText(), "Take our short survey");

			System.out.println("Pass.");
		} catch (AssertionError ae) {

			System.out.println("Fail :"+ae.getMessage());
		}
		System.out.println("Done");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		//driver.quit();
	}






}
