package crossBrowserTesting;
/*
 * Run from the xml suit file
 */


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class CrossBrowserTestingTestNG {

	private String username = "dev%40aramisinteractive.com";
	private String api_key = "ube96e1b5c957d36";  
	public String testScore = "unset";



	public WebDriver driver;  

	@BeforeMethod(alwaysRun=true)
	@org.testng.annotations.Parameters(value={"os", "browser"})
	public void setUp(String os,String browser) throws Exception {


		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("os_api_name", os);
		capability.setCapability("browser_api_name", browser);
		capability.setCapability("name", "TestNG-Parallel");
		capability.setCapability("screen_resolution", "1080x1920");
		capability.setCapability("record_video", "true");
		capability.setCapability("record_network", "true");
//		driver = new RemoteWebDriver(
//				new URL("http://" + username + ":" + api_key + "@hub.crossbrowsertesting.com:80/wd/hub"),
//				capability);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		driver=new ChromeDriver(options);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



		driver.manage().window().maximize();
	}  


	@AfterMethod(alwaysRun=true)
	public void tearDown() throws Exception {  
		//driver.quit();  
	}
}
