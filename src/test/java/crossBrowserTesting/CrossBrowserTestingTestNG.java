package crossBrowserTesting;
/*
 * Run from the xml suit file
 */


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;

public class CrossBrowserTestingTestNG {

	public String username = "dev%40aramisinteractive.com";
	public String api_key = "ube96e1b5c957d36"; 
	public String testScore = "pass";
	public  RemoteWebDriver driver;  
	public WebDriverWait wc;


	@BeforeClass
	@org.testng.annotations.Parameters(value={"os", "browser"})
	public void setUp(String os,String browser) throws Exception {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("os_api_name", os);
		capability.setCapability("browser_api_name", browser);
		capability.setCapability("name", "AT Script - "+os);
        capability.setCapability("screen_resolution", "1024x768");
		//capability.setCapability("record_video", "true");
		//capability.setCapability("record_network", "true");
		//driver = new RemoteWebDriver(
			//	new URL("http://" + username + ":" + api_key + "@hub.crossbrowsertesting.com:80/wd/hub"),
			//	capability);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wc= new WebDriverWait(driver,30);
	}  

	public JsonNode setScore(String seleniumTestId, String score) throws UnirestException {
		// Mark a Selenium test as Pass/Fail
		HttpResponse<JsonNode> response = Unirest.put("http://crossbrowsertesting.com/api/v3/selenium/{seleniumTestId}")
				.basicAuth(username, api_key)
				.routeParam("seleniumTestId", seleniumTestId)
				.field("action","set_score")
				.field("score", score)
				.asJson();
		return response.getBody();
	}

	public String takeSnapshot(String seleniumTestId) throws UnirestException {
		System.out.println("Screen Shots Taken.");

		/*
		 * Takes a snapshot of the screen for the specified test.
		 * The output of this function can be used as a parameter for setDescription()
		 */
		HttpResponse<JsonNode> response = Unirest.post("http://crossbrowsertesting.com/api/v3/selenium/{seleniumTestId}/snapshots")
				.basicAuth(username, api_key)
				.routeParam("seleniumTestId", seleniumTestId)
				.asJson(); 
		// grab out the snapshot "hash" from the response
		String snapshotHash = (String) response.getBody().getObject().get("hash");

		return snapshotHash;
	}

	public JsonNode setDescription(String seleniumTestId, String snapshotHash, String description) throws UnirestException{
		/* 
		 * sets the description for the given seleniemTestId and snapshotHash
		 */

		HttpResponse<JsonNode> response = Unirest.put("http://crossbrowsertesting.com/api/v3/selenium/{seleniumTestId}/snapshots/{snapshotHash}")
				.basicAuth(username, api_key)
				.routeParam("seleniumTestId", seleniumTestId)
				.routeParam("snapshotHash", snapshotHash)
				.field("description", description)
				.asJson();
		return response.getBody();
	}
	@AfterClass  
	public void tearDown() throws Exception {  
		//driver.quit();
		System.out.println("*****************All test Cases Execution Done******************");
	}
}