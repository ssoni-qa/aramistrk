package testSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import crossBrowserTesting.CrossBrowserTestingTestNG;

public class DemoTest extends CrossBrowserTestingTestNG{



	@Test
	public void testSimple() throws Exception {
		try {
			driver.get("http://www.google.com");
			System.out.println("Page title is: " + driver.getTitle());
			Assert.assertEquals("Google", driver.getTitle());
			WebElement element = driver.findElement(By.name("q"));
			element.sendKeys("CrossBrowserTesting.com");
			element.submit();

			System.out.println("Test Run -----------------------------------------");
		} catch (AssertionError ae) {
			// TODO Auto-generated catch block
			ae.printStackTrace();
			// if we have an assertion error, take a snapshot of where the test fails
			// and set the score to "fail"
			//String snapshotHash = myTest.takeSnapshot(driver.getSessionId().toString());
			//myTest.setDescription(driver.getSessionId().toString(), snapshotHash, ae.toString());
		}
	}
	@AfterMethod
	public void getResult(ITestResult result)
	{
		System.out.println("TC 1 executed.");

		System.out.println("------------------------------------------------------------------------------------");

		driver.quit();

	}
}
