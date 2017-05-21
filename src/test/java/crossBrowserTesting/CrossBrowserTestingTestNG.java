package crossBrowserTesting;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;

public class CrossBrowserTestingTestNG {

	public String username = "dev%40aramisinteractive.com";
	public String api_key = "ube96e1b5c957d36"; 
	public String testScore = "pass";
	public  RemoteWebDriver driver;  
	public WebDriverWait wc;
	//For Reporting
	public  ExtentReports extent;
	public  String dest;
	public  File destination;
	public  String testName;
	String reportDate;



	@BeforeClass
	@org.testng.annotations.Parameters(value={"os", "browser","testEnv"})
	public void setUp(String os,String browser,String testEnv) throws Exception {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("os_api_name", os);
		capability.setCapability("browser_api_name", browser);
		capability.setCapability("name", testEnv);
		capability.setCapability("max_duration", "1200");
		capability.setCapability("screen_resolution", "1024x768");
		//capability.setCapability("record_video", "true");
		//capability.setCapability("record_network", "true");

		URI uri = new URI("http://" + username + ":" + api_key + "@hub.crossbrowsertesting.com:80/wd/hub");
		driver = new RemoteWebDriver(uri.toURL(),capability);

		//System.setProperty("webdriver.chrome.driver", "C:/Users/COD/Desktop/chromedriver.exe");
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wc= new WebDriverWait(driver,15);
		extent = new ExtentReports("./etestReport/"+testEnv+".html",true,NetworkMode.OFFLINE);

	}  


	public   String captureScreenMethod(String dest) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		dest=System.getProperty("user.dir") +"//etestReport//"+System.currentTimeMillis()+".png";
		destination = new File(dest);
		FileUtils.copyFile(source, destination);
		Path p = Paths.get(dest);
		String screenFile = p.getFileName().toString();
		return screenFile;

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

	@AfterClass (alwaysRun=true) 
	public void done() throws Exception {  
		driver.quit();
		extent.flush();
		System.out.println("*****************All test Cases Execution Done******************");
	}
}