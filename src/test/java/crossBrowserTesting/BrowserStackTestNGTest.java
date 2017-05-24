package crossBrowserTesting;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.browserstack.local.Local;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.HTMLReporter;
import com.relevantcodes.extentreports.NetworkMode;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BrowserStackTestNGTest {
	public  WebDriver driver;
	public WebDriverWait wc;
	private Local l;
	public  ExtentReports extent;
	public  String dest;
	public  File destination;
	public  String testName;
	public SoftAssert s_assert;
	String reportDate;


	@BeforeMethod(alwaysRun=true)
	@org.testng.annotations.Parameters(value={"config", "environment"})
	public void setUp(String config_file, String environment) throws Exception {

		//To set report name 

		Date start = new Date(System.currentTimeMillis());
		reportDate = start.toString().replaceAll("(\\d\\d:){2}\\d\\d\\s", "");


		JSONParser parser = new JSONParser();
		JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/" + config_file));
		JSONObject newcap = (JSONObject) config.get("capabilities");
		newcap.put("name", ""+getClass().getName());
		newcap.put("build", ""+getClass().getPackage());
		JSONObject envs = (JSONObject) config.get("environments");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		Map<String, String> envCapabilities = (Map<String, String>) envs.get(environment);
		Iterator it = envCapabilities.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
		}

		Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
		it = commonCapabilities.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			if(capabilities.getCapability(pair.getKey().toString()) == null){
				capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
			}
		}

		String username = System.getenv("BROWSERSTACK_USERNAME");
		if(username == null) {
			username = (String) config.get("user");
		}

		String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
		if(accessKey == null) {
			accessKey = (String) config.get("key");
		}

		try {
			if(capabilities.getCapability("browserstack.local") != null && capabilities.getCapability("browserstack.local") == "true"){
				l = new Local();
				Map<String, String> options = new HashMap<String, String>();
				options.put("key", accessKey);
				l.start(options);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			l.stop();
		}
		driver = new RemoteWebDriver(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		System.setProperty("webdriver.chrome.driver", "C://Users//COD//Desktop//chromedriver_win32");
		driver= new ChromeDriver(options);*/
		wc=new WebDriverWait(driver, 30);
		extent = new ExtentReports("./etestReport/"+environment+".html",false,NetworkMode.OFFLINE);
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

	@AfterMethod(alwaysRun=true)
	public void tearDown() throws Exception {
		driver.quit();
		extent.flush();
		if(l != null) 
			l.stop();

	}
}
